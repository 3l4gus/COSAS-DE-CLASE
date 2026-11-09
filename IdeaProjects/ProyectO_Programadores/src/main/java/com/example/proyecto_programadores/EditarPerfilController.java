package com.example.proyecto_programadores;

import com.example.proyecto_programadores.services.UsuarioService;
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
    static UsuarioService us = new UsuarioService();

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 480);

        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    public void onCancelarClick(ActionEvent actionEvent) throws IOException {

        // Cambiamos la vista
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 480);

        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
