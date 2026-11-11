package com.example.proyecto_programadores;

import com.example.proyecto_programadores.dao.UsuarioDAO;
import com.example.proyecto_programadores.entity.Usuario;
import com.example.proyecto_programadores.util.GenerarExcel;
import com.example.proyecto_programadores.util.GenerarPDF;
import com.example.proyecto_programadores.util.NombreUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

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

        // Mostramos el título de bienvenida con el nombre de usuario que recogimos en LoginController
        lblBienvenida.setText("¡Bienvenido/a, " + NombreUsuario.getNombreUsuario() + "!");

        // Indicamos qué atributo de Usuario muestra cada columna
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colLenguaje.setCellValueFactory(new PropertyValueFactory<>("lenguaje"));

        cbFiltroLenguaje.getItems().addAll("Todos", "Java", "Python", "JavaScript");
        cbFiltroLenguaje.setValue("Todos");

        llenarTabla();
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

        // Intentamos generar el excel y mostramos una ventana emergente confirmando si se ha logrado
        try {
            GenerarExcel.generarExcel(tablaProgramadores.getItems());
            mostrarAlerta(Alert.AlertType.INFORMATION, "Excel",
                    "Excel generado correctamente.");
        } catch (IOException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error",
                    "No se ha podido generar el Excel.");
        }
    }

    public void onPdfClick(ActionEvent actionEvent) {

        // Intentamos generar el PDF y mostramos una ventana emergente confirmando si se ha logrado
        try {
            GenerarPDF.generarPDF(tablaProgramadores.getItems());
            mostrarAlerta(Alert.AlertType.INFORMATION, "PDF",
                    "PDF generado correctamente.");
        } catch (IOException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error",
                    "No se ha podido generar el PDF.");
        }
    }

    public void cambiarFiltroLenguaje(ActionEvent actionEvent) {
        llenarTabla();
    }

    // Método que rellena la tabla según el filtro seleccionado
    public void llenarTabla() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Guardamos en el arrayList los usuarios que tengan el lenguaje que está seleccionado en
        // el filtro. También pasamos nuestro nombre de usuario por si estuviese seleccionado "Todos"
        // indicar que no aparezca nuestro usuario. Luego rellenamos la tabla con los usuarios del arrayList
        ArrayList<Usuario> usuarios = usuarioDAO.listarPorLenguaje(cbFiltroLenguaje.getValue(), NombreUsuario.getNombreUsuario());
        tablaProgramadores.getItems().setAll(usuarios);
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
