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

    public void onLoginBotonClick(ActionEvent actionEvent) throws IOException {
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
        NombreUsuario.setNombreUsuario(nombre);

        // Cambiamos la vista
        cambiarVista(actionEvent, "inicio.fxml", 480, 480);

    }

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

        for (int i = 0; i < contrasena.length(); i++) {
            char caracter = contrasena.charAt(i);

            if (Character.isUpperCase(caracter)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(caracter)) {
                tieneMinuscula = true;
            }

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

    public Usuario login(String nombre, String contrasena) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.comprobarUsuario(nombre, contrasena);
    }

    public void cambiarVista(ActionEvent actionEvent, String fxml, int ancho, int alto) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), ancho, alto);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    public void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
