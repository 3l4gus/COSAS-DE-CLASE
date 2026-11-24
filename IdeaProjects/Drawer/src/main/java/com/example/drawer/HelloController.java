package com.example.drawer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;

public class HelloController {
    @FXML
    private VBox drawer;
    FontIcon icono = new FontIcon(FontAwesomeSolid.HOME);
    FontIcon iconoSegundo = new FontIcon(FontAwesomeSolid.AWARD);
    FontIcon iconoTercero = new FontIcon(FontAwesomeSolid.BATTERY_THREE_QUARTERS);

    @FXML
    Button inicio, segundo, tercero;

    @FXML
    private StackPane contenedorContenido;

    @FXML
    public void initialize() {
        drawer.setVisible(false);

        icono.setIconSize(18);
        icono.setIconColor(Color.WHITE);

        iconoSegundo.setIconSize(18);
        iconoSegundo.setIconColor(Color.WHITE);

        iconoTercero.setIconSize(18);
        iconoTercero.setIconColor(Color.WHITE);

        inicio.setGraphic(icono);
        segundo.setGraphic(iconoSegundo);
        tercero.setGraphic(iconoTercero);
    }

    @FXML
    public void mostrarDrawer() {

        boolean mostrar = !drawer.isVisible();

        drawer.setVisible(mostrar);

    }

    private void cargarVista(String ruta) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            Parent vista = loader.load();

            contenedorContenido.getChildren().clear();

            contenedorContenido.getChildren().add(vista);
        } catch (IOException e) {
        }

    }

    @FXML
    private void mostrarInicio() {

        cargarVista("/com/example/drawer/inicio.fxml");
    }

    @FXML
    private void mostrarSegundo() {

        cargarVista("/com/example/drawer/segunda.fxml");
    }

    //Propiedad: onMouseClicked en el StackPane principal
    public void cerrarDrawer(MouseEvent mouseEvent) {

        if (drawer.isVisible()) {

                drawer.setVisible(false);
            }
    }
}
