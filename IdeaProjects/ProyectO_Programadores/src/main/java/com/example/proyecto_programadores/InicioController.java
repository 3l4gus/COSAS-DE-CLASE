package com.example.proyecto_programadores;

import com.example.proyecto_programadores.entity.Usuario;
import com.example.proyecto_programadores.util.NombreUsuario;
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

    @FXML
    private Label lblBienvenida;

    @FXML
    private ComboBox<String> cbFiltroLenguaje;

    @FXML
    private TableView<Usuario> tablaProgramadores;

    @FXML
    private TableColumn<Usuario, String> colUsuario;

    @FXML
    private TableColumn<Usuario, String> colGenero;

    @FXML
    private TableColumn<Usuario, String> colLenguaje;

    @FXML
    public void initialize(){
        lblBienvenida.setText("¡Bienvenido/a, " + NombreUsuario.getNombreUsuario() + "!");
    }

    public void onCerrarSesionClick(ActionEvent actionEvent) throws IOException {

        // Cambiamos la vista
        cambiarVista(actionEvent, "login.fxml", 450, 550);
    }

    public void onEditarPerfilClick(ActionEvent actionEvent) throws IOException {

        // Cambiamos la vista
        cambiarVista(actionEvent, "editarPerfil.fxml", 600, 300);
    }

    public void onExcelClick(ActionEvent actionEvent) {
    }

    public void onPdfClick(ActionEvent actionEvent) {
    }

    public void cambiarVista(ActionEvent actionEvent, String fxml, int ancho, int alto) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), ancho, alto);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
