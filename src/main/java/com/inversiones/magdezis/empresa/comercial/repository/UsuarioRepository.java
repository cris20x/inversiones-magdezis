
package main.java.com.inversiones.magdezis.empresa.comercial.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.com.inversiones.magdezis.empresa.comercial.confing.DatabaseConnection;
import main.java.com.inversiones.magdezis.empresa.comercial.model.Usuario;


public class UsuarioRepository {

    public boolean existeCorreo(String correo) throws SQLException {

        String sql =
                "SELECT id_usuario FROM usuarios WHERE correo = ?";

        try (
                Connection conexion = DatabaseConnection.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, correo);

            try (ResultSet resultado = sentencia.executeQuery()) {
                return resultado.next();
            }
        }
    }

    public Usuario buscarPorCorreo(String correo) throws SQLException {

        String sql = """
                SELECT u.id_usuario, u.id_rol, u.nombre, u.apellido,
                       u.correo, u.password_hash, r.nombre_rol
                FROM usuarios u
                INNER JOIN roles r ON r.id_rol = u.id_rol
                WHERE u.correo = ?
                """;

        try (
                Connection conexion = DatabaseConnection.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, correo);

            try (ResultSet resultado = sentencia.executeQuery()) {

                if (resultado.next()) {

                    return new Usuario(
                            resultado.getString("id_usuario"),
                            resultado.getInt("id_rol"),
                            resultado.getString("nombre"),
                            resultado.getString("apellido"),
                            resultado.getString("correo"),
                            resultado.getString("password_hash"),
                            resultado.getString("nombre_rol")
                    );
                }

                return null;
            }
        }
    }

    public int obtenerIdRolPorNombre(String nombreRol) throws SQLException {

        String sql =
                "SELECT id_rol FROM roles WHERE nombre_rol = ?";

        try (
                Connection conexion = DatabaseConnection.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, nombreRol);

            try (ResultSet resultado = sentencia.executeQuery()) {

                if (resultado.next()) {
                    return resultado.getInt("id_rol");
                }

                throw new SQLException(
                        "No existe el rol '" + nombreRol + "'."
                        + " Verifica la tabla 'roles'."
                );
            }
        }
    }

    public boolean registrarUsuario(Usuario usuario) throws SQLException {

        String sql = """
                INSERT INTO usuarios
                    (id_usuario, id_rol, nombre, apellido, correo, password_hash)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection conexion = DatabaseConnection.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, usuario.getIdUsuario());
            sentencia.setInt(2, usuario.getIdRol());
            sentencia.setString(3, usuario.getNombre());
            sentencia.setString(4, usuario.getApellido());
            sentencia.setString(5, usuario.getCorreo());
            sentencia.setString(6, usuario.getPasswordHash());

            return sentencia.executeUpdate() > 0;
        }
    }
}

}
