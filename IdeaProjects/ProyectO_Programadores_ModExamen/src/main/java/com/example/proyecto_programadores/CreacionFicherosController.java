package com.example.proyecto_programadores;

import com.example.proyecto_programadores.dao.UsuarioDAO;
import com.example.proyecto_programadores.entity.Usuario;
import com.example.proyecto_programadores.util.CrearFicheroBinario;
import com.example.proyecto_programadores.util.CrearFicheroSecuencial;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CreacionFicherosController {
    public void onVolverClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 550);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    public void onBinarioClick(ActionEvent actionEvent) throws IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            ArrayList<Usuario> usuarios = usuarioDAO.listarTodos();
            CrearFicheroBinario.generarBinario(usuarios);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Fichero Binario",
                    "Fichero binario generado correctamente.");
        }catch (IOException e){
            mostrarAlerta(Alert.AlertType.ERROR, "Error",
                    "No se ha podido generar el fichero binario.");
        }
    }

    public void onSecuencialClick(ActionEvent actionEvent) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            ArrayList<Usuario> usuarios = usuarioDAO.listarTodos();
            CrearFicheroSecuencial.generarSecuencial(usuarios);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Fichero Secuencial",
                    "Fichero secuencial generado correctamente.");
        }catch (IOException e){
            mostrarAlerta(Alert.AlertType.ERROR, "Error",
                    "No se ha podido generar el fichero secuencial.");
        }
    }

    public void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
