package com.example.examennelsontrimestre1_agustinolivera;

import com.example.examennelsontrimestre1_agustinolivera.dao.DatosDAO;
import com.example.examennelsontrimestre1_agustinolivera.entity.Datos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Interfaz2Controller {
    @FXML
    private javafx.scene.control.TextArea txaDatos;

    // Rellenamos el textArea con los datos recogidos
    @FXML
    public void initialize(){
        ArrayList<Datos> datos = recibirDatos();
        txaDatos.setText(datos.toString());
    }

    // Método para recibir los datos de la base de datos y devolver solo los 3 primeros
    private ArrayList<Datos> recibirDatos() {
        DatosDAO datosDAO = new DatosDAO();
        ArrayList<Datos> datos = datosDAO.mandarDatos();
        ArrayList<Datos> tresPrimeros = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            try {
                tresPrimeros.add(datos.get(i));
            }catch (IndexOutOfBoundsException e){
                break;
            }
        }
        return tresPrimeros;
    }

    // Al pulsar el botón de atras se volverá a la primera interfaz
    public void onAtrasButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfaz1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 350);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
