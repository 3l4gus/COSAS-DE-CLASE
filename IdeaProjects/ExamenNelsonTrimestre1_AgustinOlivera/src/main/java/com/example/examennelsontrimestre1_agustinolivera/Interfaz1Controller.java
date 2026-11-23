package com.example.examennelsontrimestre1_agustinolivera;

import com.example.examennelsontrimestre1_agustinolivera.dao.DatosDAO;
import com.example.examennelsontrimestre1_agustinolivera.entity.Datos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Interfaz1Controller {


    @FXML
    private javafx.scene.control.TextField txtContrasena;

    @FXML
    private javafx.scene.control.TextField txtNumero;

    @FXML
    private ComboBox<String> cbOpciones;

    // Añadimos al comboBox las opciones
    @FXML
    public void initialize(){
        cbOpciones.getItems().addAll(
                "Rojo", "Verde", "Azul", "Amarillo", "Negro");
    }

    // Al pulsar el boton de guardar se validaran los datos y se guardaran en la base de
    // datos si son correctos
    public void onGuardarButtonClick(ActionEvent actionEvent) {
        String contrasena = txtContrasena.getText().trim();
        String numero = txtNumero.getText().trim();
        String opcion = cbOpciones.getValue();

        String error = validarDatos(contrasena, numero, opcion);

        if (error != null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", error);
            return;
        }

        int n = Integer.parseInt(numero);
        Datos d = new Datos(contrasena, n, opcion);

        if (!registrar(d)) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se han podido registrar los datos.");
            return;
        }
        mostrarAlerta(Alert.AlertType.INFORMATION, "Registro", "Datos registrados correctamente.");

        txtContrasena.clear();
        txtNumero.clear();
    }

    // Metodo para registrar los datos en la base de datos
    private boolean registrar(Datos d) {
        DatosDAO datosDAO = new DatosDAO();
        datosDAO.registrarDatos(d);
        return true;
    }

    // Metodo para cambiar de ventana al pulsar el boton de ver datos
    public void onVerDatosButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfaz2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    // Metodo para validar los datos que devolverá un String con el error si alguno no es válido
    public String validarDatos(String contrasena, String numero, String opcion){
        String error = validarContrasena(contrasena);

        if (error == null) {
            error = validarNumero(numero);
        }

        if (error == null){
            error = validarOpcion(opcion);
        }

        return error;
    }

    // Metodo para validar la contraseña que devolverá un String con el error si no es válido
    public String validarContrasena(String contrasena){
        if (contrasena == null) {
            return "La contraseña no puede estar vacía.";
        }

        if(!contrasena.startsWith(".pass")){
            return "La contraseña debe empezar por '.pass'.";
        }

        boolean tieneHashtag = false;

        for (int i = 0; i < contrasena.length(); i++) {
            if (contrasena.charAt(i) == '#') {
                tieneHashtag = true;
                break;
            }
        }

        if (!tieneHashtag) {
            return "La contraseña debe contener '#'.";
        }

        return null;
    }

    // Metodo para validar el número que devolverá un String con el error si no es válido
    public String validarNumero(String numero){
        try {
            Integer.parseInt(numero);

            if(numero.endsWith("2")){
                return null;
            }
            return "El número debe de acabar en '2'.";
        } catch (NumberFormatException e) {
            return "El número debe de ser un número entero.";
        }
    }

    // Metodo para validar la opción del comboBox que devolverá un String con el
    // error si está vacío
    public String validarOpcion(String opcion){
        if(opcion == null){
            return "Debes escoger una opción del ComboBox";
        }
        return null;
    }

    // Método para mostrar una alerta pasandole los parámetros
    public void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
