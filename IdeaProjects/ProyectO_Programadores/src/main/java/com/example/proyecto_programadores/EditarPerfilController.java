package com.example.proyecto_programadores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.IOException;

public class EditarPerfilController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPassword;

    @FXML
    private RadioButton rbHombre;

    @FXML
    private RadioButton rbMujer;

    @FXML
    private RadioButton rbPrefieroNoDecirlo;

    @FXML
    private ComboBox<String> cbLenguaje;

    public void onGuardarCambiosClick(ActionEvent actionEvent) throws IOException {

        // Cambiamos la vista
        cambiarVista(actionEvent, "inicio.fxml", 480, 480);
    }

    public void onCancelarClick(ActionEvent actionEvent) throws IOException {

        // Cambiamos la vista
        cambiarVista(actionEvent, "inicio.fxml", 480, 480);
    }

    public void cambiarVista(ActionEvent actionEvent, String fxml, int ancho, int alto) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), ancho, alto);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
