package com.example.proyecto_programadores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroController {

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
    private ComboBox cbLenguajeRegistro;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnIrLogin;

    public void onRegistrarBotonClick(ActionEvent actionEvent) {
    }

    public void onVolverAlLoginBotonClick(ActionEvent actionEvent) throws IOException {

        // Cambiamos la vista
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 550);

        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
