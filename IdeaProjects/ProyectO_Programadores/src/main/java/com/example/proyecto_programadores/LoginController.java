package com.example.proyecto_programadores;

import com.example.proyecto_programadores.entity.Usuario;
import com.example.proyecto_programadores.services.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
        String usuario = txtUsuarioLogin.getText().trim();
        String password = txtPasswordLogin.getText();

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
}
