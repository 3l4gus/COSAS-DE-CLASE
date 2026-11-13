package com.example.proyecto_programadores;

import com.example.proyecto_programadores.dao.UsuarioDAO;
import com.example.proyecto_programadores.entity.Usuario;
import com.example.proyecto_programadores.util.NombreUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtPasswordLogin;

    @FXML
    private TextField txtUsuarioLogin;

    // Método que se ejecuta al hacer click en el botón de iniciar sesión
    public void onLoginBotonClick(ActionEvent actionEvent) throws IOException {

        // Guardamos el nombre y la contraseña introducidos por el usuario
        String nombre = txtUsuarioLogin.getText().trim();
        String contrasena = txtPasswordLogin.getText();

        // Validamos el formato de los datos, si no lo es mostrará una ventana emergente de error
        String error = validarLogin(nombre, contrasena);

        if (error != null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", error);
            return;
        }

        // Comprobamos los datos del usuario en la base de datos, si el usuario no existe mostrará
        // una ventana emergente de error
        Usuario u = login(nombre, contrasena);

        if (u == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Usuario o contraseña incorrectos.");
            return;
        }

        // Guardamos el nombre del usuario para usarlo en las demás ventanas y cambiamos la vista
        NombreUsuario.setNombreUsuario(nombre);
        cambiarVista(actionEvent, "inicio.fxml", 480, 480);

    }

    // Método que se ejecuta al hacer click en el botón de registrarse
    public void onRegistrarseBotonClick(ActionEvent actionEvent) throws IOException {
        cambiarVista(actionEvent, "registro.fxml", 450, 550);
    }

    // Método que valida si el nombre y la contraseña son válidos, y devolverá un String error
    // si alguno no es válido
    public String validarLogin(String nombre, String contrasena) {
        String error = validarNombre(nombre);

        if (error == null) {
            error = validarContrasena(contrasena);
        }

        return error;
    }

    // Método para validar que el nombre no esté vacío y tenga al menos 5 caracteres
    public String validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return "El nombre de usuario no puede estar vacío.";
        }

        if (nombre.length() < 5) {
            return "El nombre de usuario debe tener al menos 5 caracteres.";
        }

        return null;
    }

    // Método para validar que la contraseña tiene al menos 8 caracteres, una mayúscula y
    // una minúscula
    public String validarContrasena(String contrasena) {
        if (contrasena == null || contrasena.length() < 8) {
            return "La contraseña debe tener al menos 8 caracteres.";
        }

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;

        // Recorremos la contraseña para comprobar si tiene mayúsculas y minúsculas
        for (int i = 0; i < contrasena.length(); i++) {
            char caracter = contrasena.charAt(i);

            if (Character.isUpperCase(caracter)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(caracter)) {
                tieneMinuscula = true;
            }

            // Si ya hemos encontrado una mayúscula y una minúscula, dejamos de comprobar
            if (tieneMayuscula && tieneMinuscula) {
                break;
            }
        }

        if (!tieneMayuscula) {
            return "La contraseña debe contener al menos una mayúscula.";
        }

        if (!tieneMinuscula) {
            return "La contraseña debe contener al menos una minúscula.";
        }

        return null;
    }

    // Método que comprueba en la base de datos si el nombre y la contraseña son correctos
    public Usuario login(String nombre, String contrasena) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.comprobarUsuario(nombre, contrasena);
    }

    // Método que cambia la vista actual por otra que le indicamos en los parámetros
    public void cambiarVista(ActionEvent actionEvent, String fxml, int ancho, int alto) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), ancho, alto);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    // Método que muestra una ventana emergente con el tipo, título y mensaje indicados
    public void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
