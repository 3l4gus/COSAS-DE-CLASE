package com.example.primerproyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class SegundaVistaController {

    //Variables
    @FXML
    TextField textFieldNombre;

    @FXML
    TextField textFieldApellidos;

    @FXML
    TextField textFieldEdad;

    @FXML
    Label labelError;

    @FXML
    TextArea textArea;

    @FXML
    ComboBox<String> comboBox;

    @FXML
    RadioButton hombre, mujer;

    @FXML
            CheckBox checkBox;

    String texto = "";

    public void initialize(){
        comboBox.getItems().addAll("hola", "mundo");
    }

    public void cambiarValorCombo(ActionEvent actionEvent){
        String valor = comboBox.getValue();
        int pos = comboBox.getSelectionModel().getSelectedIndex();

        textArea.setText(pos + ": " + valor);
    }

    public void rellenarTextArea(ActionEvent actionEvent) {
        texto = comboBox.getSelectionModel().getSelectedIndex() + " " + comboBox.getValue();

        labelError.setText("");
        String nombre = textFieldNombre.getText().trim();
        String apellidos = textFieldApellidos.getText().trim();
        String edadTexto = textFieldEdad.getText().trim();

        if (nombre.length() < 3 || nombre.length() > 10) {
            labelError.setText("El nombre debe tener entre 3 y 10 caracteres.");
            return;
        }

        if (apellidos.length() < 10 || apellidos.length() > 20) {
            labelError.setText("Los apellidos deben tener entre 10 y 20 caracteres.");
            return;
        }

        try {
            int edad = Integer.parseInt(edadTexto);
        } catch (NumberFormatException e) {
            labelError.setText("La edad debe de ser un número entero válido.");
            return;
        }

        String datos = "Nombre : " + nombre +
                "\nApellidos: " + apellidos +
                "\nEdad: " + edadTexto;
        textArea.setText(datos);

        try {
            BufferedWriter bw =
                    new BufferedWriter(new FileWriter("src/main/java/modelo.modelo.fichero.fichero/datos.txt", true));

            bw.write("Nombre: " + nombre);
            bw.newLine();

            bw.write("Apellidos: " + apellidos);
            bw.newLine();

            bw.write("Edad: " + edadTexto);
            bw.newLine();
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            labelError.setText("No se encuentra la ruta.");
        }
    }

    public void comprobarEstado(ActionEvent actionEvent) {
        String texto = "";

        if(hombre.isSelected()){
            texto = "hombre";
        }else if(mujer.isSelected()){
            texto = "mujer";
        }else{
            texto = "No has seleccionado sexo.";
        }

        if(checkBox.isSelected()){
            texto = "Seleccionado checkbox.";
        }else{
            texto = "No seleccionado checkbox.";
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Titulo de prueba");
        alert.setContentText(texto);

        alert.show();
    }

    public void cambiarVentana(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        Stage stage = (Stage)((Node)(actionEvent.getSource())).getScene().getWindow();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
