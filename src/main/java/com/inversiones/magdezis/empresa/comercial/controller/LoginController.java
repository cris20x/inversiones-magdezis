
package main.java.com.inversiones.magdezis.empresa.comercial.controller;
import  javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import main.java.com.inversiones.magdezis.empresa.comercial.service.LoginService;

public class LoginController {
 public class textField{
     
 }
    
public class loginView{
    @FXML
private textField txtUsuario;
    @FXML
private PasswordField txtContrasena; 
    @FXML
private textField txtCorreo;
    
 private LoginService  loginService;

    public loginView() {
        loginService = new LoginService(); 
    }

    @FXML
    private void iniciarSesion() {
 
        String usuario = txtUsuario.getText();
 
        String contrasena = txtContrasena.getText();
 
        boolean resultado = 
                LoginService.iniciarSesion(
                        usuario,
                        contrasena
                );
 
        if (resultado) {
 
            mostrarMensaje(
                    Alert.AlertType.INFORMATION,
                    "Login",
                    "Inicio de sesión correcto"
            );
 
        } else {
 
            mostrarMensaje(
                    Alert.AlertType.ERROR,
                    "Login",
                    "Usuario o contraseña incorrectos"
            );
        }
    }
}

    
        
        
        
    
    
    
    
    
    
 
    
    

}


