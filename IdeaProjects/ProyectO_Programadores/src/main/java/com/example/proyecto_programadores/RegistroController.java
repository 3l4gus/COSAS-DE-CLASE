package com.example.proyecto_programadores;

import com.example.proyecto_programadores.entity.Usuario;
import com.example.proyecto_programadores.services.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroController {
    static UsuarioService us = new UsuarioService();

    @FXML
    private TextField txtNombreRegistro;

    @FXML
    private TextField txtPasswordRegistro;

    @FXML
    private RadioButton rbHombre;

    @FXML
    private RadioButton rbMujer;

    @FXML
    private RadioButton rbPrefieroNoDecirlo;

    @FXML
    private ComboBox<String> cbLenguajeRegistro;

    @FXML
    private void initialize() {
        cbLenguajeRegistro.getItems().addAll("Java", "Python", "JavaScript");
    }

    public void onRegistrarBotonClick(ActionEvent actionEvent) throws IOException {
        String nombre = txtNombreRegistro.getText().trim();
        String contrasena = txtPasswordRegistro.getText();
        String lenguaje = cbLenguajeRegistro.getValue();
        String genero = obtenerGeneroSeleccionado();

        // Validamos el formato de los datos, si alguno no es válido se guardará un String en error y
        // mostrará una ventana emergente de error
        String error = us.validarRegistro(nombre, contrasena, genero, lenguaje);

        if (error != null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", error);
            return;
        }

        // Al ser todo válido guardamos el usuario en la base de datos, mostramos una ventana emergente
        // confirmando que se ha registrado y volvemos al login
        Usuario u = new Usuario(nombre, contrasena, genero, lenguaje);
        us.registrar(u);
        mostrarAlerta(Alert.AlertType.INFORMATION, "Registro", "Usuario registrado correctamente.");

        volverAlLogin(actionEvent);

    }

    public void onVolverAlLoginBotonClick(ActionEvent actionEvent) throws IOException {
        volverAlLogin(actionEvent);
    }

    private void volverAlLogin(ActionEvent actionEvent) throws IOException {

        // Cambiamos la vista
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 550);

        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    // Método para obtener el género que se ha seleccionado de los RadioButton y devolverá su texto o null
    // si no se ha seleccionado ninguno
    private String obtenerGeneroSeleccionado() {
        if (rbHombre.isSelected()) {
            return rbHombre.getText();
        }

        if (rbMujer.isSelected()) {
            return rbMujer.getText();
        }

        if (rbPrefieroNoDecirlo.isSelected()) {
            return rbPrefieroNoDecirlo.getText();
        }

        return null;
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
