package com.example.correcciones;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimeraVentanaController {

    @FXML
    TextField txtNombre;

    @FXML
    TextField txtEdad;

    @FXML
    TextField txtCorreo;

    public void generarPDF(ActionEvent actionEvent) {

        String nombre = txtNombre.getText().trim();

        int edad = Integer.parseInt(txtEdad.getText());

        String correo = txtCorreo.getText().trim();

        try {
            GenerarPDF.generarPDF(nombre,edad, correo);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Error pdf");
        }


//        String texto = "hoLa123";

//otra forma
//        if(!texto.equals(texto.toLowerCase()) ){
//            System.out.println("Hay mayusculas");
//        }
//
//        if(!texto.equals(texto.toUpperCase()) ){
//            System.out.println("Hay minusculas");
//        }

       /*
        * String texto = "hola123";

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;

       for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            if (Character.isUpperCase(caracter)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(caracter)) {
                tieneMinuscula = true;
            }

            if (tieneMayuscula && tieneMinuscula) {
                break;
            }
        * */

    }

    public void salir(ActionEvent actionEvent) {

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.close();
    }

    public void generarExcel(ActionEvent actionEvent) {


        //    controller.recibirUsuario(usuario);

//        segunda ventana
/*
    private Usuario usuario;

*   public void recibirUsuario(Usuario usuario) {

        this.usuario = usuario;

        System.out.println("Usuario recibido: "
                + usuario.getNombre());
    }
* */


        String nombre = txtNombre.getText().trim();

        int edad = Integer.parseInt(txtEdad.getText());

        String correo = txtCorreo.getText().trim();


        try {
            GenerarExcel.generarExcel(nombre,edad,correo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
