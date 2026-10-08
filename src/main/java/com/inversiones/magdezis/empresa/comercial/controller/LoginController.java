
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


/*import java.io.IOException;
 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
public class LoginController {

 
public class LoginViewController {
 
    @FXML
    private TextField txtUsuario;
 
    @FXML
    private PasswordField txtContrasena;
 
    private LoginService loginService;
 
    public LoginViewController() {
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
 
    @FXML
    private void irRegistro() {
 
        try {
 
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/view/registro-view.fxml"
                            )
                    );
 
            Parent root = loader.load();
 
            Stage stage =
                    (Stage) txtUsuario
                            .getScene()
                            .getWindow();
 
            stage.setScene(new Scene(root));
 
            stage.show();
 
        } catch (IOException e) {
 
            e.printStackTrace();
        }
    }
 
    private void mostrarMensaje(
            Alert.AlertType tipo,
            String titulo,
            String mensaje) {
 
        Alert alert = new Alert(tipo);
 
        alert.setTitle(titulo);
 
        alert.setHeaderText(null);
 
        alert.setContentText(mensaje);
 
        alert.showAndWait();
    }
}
}*/
