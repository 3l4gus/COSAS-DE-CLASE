package com.example.proyecto_programadores;

import com.example.proyecto_programadores.entity.Usuario;
import com.example.proyecto_programadores.services.UsuarioService;
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
    static UsuarioService us = new UsuarioService();

    @FXML
    private TextField txtPasswordLogin;

    @FXML
    private TextField txtUsuarioLogin;

    public void onLoginBotonClick(ActionEvent actionEvent) throws IOException {
        String nombre = txtUsuarioLogin.getText().trim();
        String contrasena = txtPasswordLogin.getText();

        // Validamos el formato de los datos, si no lo es mostrará una ventana emergente de error
        String error = us.validarLogin(nombre, contrasena);
        if (error != null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", error);
            return;
        }

        // Comprobamos los datos del usuario en la base de datos, si el usuario no existe mostrará
        // una ventana emergente de error
        Usuario u = us.login(nombre, contrasena);
        if (u == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Usuario o contraseña incorrectos.");
            return;
        }

        // Cambiamos la vista
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 480);

        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

    public void onRegistrarseBotonClick(ActionEvent actionEvent) throws IOException {

        // Cambiamos la vista
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 550);

        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
