package com.example.proyecto_programadores;

import com.example.proyecto_programadores.entity.Usuario;
import com.example.proyecto_programadores.services.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioController {
    static UsuarioService us = new UsuarioService();

    @FXML
    private Label lblBienvenida;

    @FXML
    private ComboBox<String> cbFiltro;

    @FXML
    private TableView<Usuario> tablaProgramadores;

    @FXML
    private TableColumn<Usuario, String> colUsuario;

    @FXML
    private TableColumn<Usuario, String> colGenero;

    @FXML
    private TableColumn<Usuario, String> colLenguaje;

    public void onCerrarSesionClick(ActionEvent actionEvent) throws IOException {

        // Cambiamos la vista
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 550);

        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    public void onEditarPerfilClick(ActionEvent actionEvent) throws IOException {

        // Cambiamos la vista
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editarPerfil.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);

        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    public void onExcelClick(ActionEvent actionEvent) {
    }

    public void onPdfClick(ActionEvent actionEvent) {
    }
}
