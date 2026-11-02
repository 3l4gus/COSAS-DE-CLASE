package com.example.ejerciciosclase2_parte1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class HelloController {

    static String ruta = "src/main/java/fichero/paises.bin";

    // Le damos un id a cada control
    @FXML
    TextField TextFieldNombre;

    @FXML
    TextField TextFieldPoblacion;

    @FXML
    TextField TextFieldIdioma;

    @FXML
    TextField TextFieldMoneda;

    @FXML
    TextField TextFieldContinente;

    @FXML
    Label labelError;

    @FXML
    ComboBox<String> comboBox;

    @FXML
    TextArea textArea;

    @FXML
    Button botonAtras, botonVentanaIntroducir, botonVentanaElegir;

    // Método que se ejecuta cuando hacemos click en el botón guardar
    @FXML
    protected void onGuardarButtonClick() throws IOException {

        // Guardamos lo escrito en cada textField en variables
        String nombre = TextFieldNombre.getText().trim();
        String poblacionTexto = TextFieldPoblacion.getText().trim();
        String idioma = TextFieldIdioma.getText().trim();
        String moneda = TextFieldMoneda.getText().trim();
        String continente = TextFieldContinente.getText().trim();

        // Verificamos que todos los textField tengan texto y si no aparecerá un error
        if (nombre.isEmpty() || poblacionTexto.isEmpty() || idioma.isEmpty()
                || moneda.isEmpty() || continente.isEmpty()) {
            labelError.setText("Debes rellenar todos los campos.");
            return;
        }

        // Validamos que la población sea un número mayor que 0 y si no aparecerá un error
        int poblacion;

        try {
            poblacion = Integer.parseInt(poblacionTexto);

            if (poblacion <= 0) {
                labelError.setText("La población debe ser un número mayor que 0.");
                return;
            }
        } catch (NumberFormatException e) {
            labelError.setText("La población debe ser un valor numérico.");
            return;
        }

        // Verificamos que el continente escrito esté dentro de las opciones y si no aparecerá un error
        switch (continente.toLowerCase()) {
            case "america":
                continente = "America";
                break;
            case "europa":
                continente = "Europa";
                break;
            case "asia":
                continente = "Asia";
                break;
            case "africa":
                continente = "Africa";
                break;
            case "oceania":
                continente = "Oceania";
                break;
            case "antartida":
                continente = "Antartida";
                break;
            default:
                labelError.setText("Debes elegir entre America, Europa, Asia, Africa, Oceania o Antartida.");
                return;
        }

        // Comprobamos que no exista otro país con el mismo nombre y si no aparecerá un error
        if (existePais(nombre)) {
            labelError.setText("Ya existe un país con ese nombre.");
            return;
        }

        // Llamamos al método para guardar el país en el fichero binario y mostramos un mensaje
        guardarPais(nombre, poblacion, idioma, moneda, continente);
        labelError.setText("País guardado correctamente.");

        // Borramos el contenido de todos los textField
        TextFieldNombre.clear();
        TextFieldPoblacion.clear();
        TextFieldIdioma.clear();
        TextFieldMoneda.clear();
        TextFieldContinente.clear();
    }

    // Método que se ejecuta al abrir la vista
    public void initialize() {

        // Hacemos que no se pueda escribir en el textArea
        if (textArea != null) {
            textArea.setEditable(false);
        }

        // Si estamos en la segunda vista, agregamos los países que hayan en el fichero
        // al comboBox
        if (comboBox != null) {
            try {
                File fichero = new File(ruta);

                // Si el fichero existe lo recorremos y agregamos las opciones al comboBox,
                // si no aparecerá un mensaje en el textArea de que no hay países guardados
                if (fichero.exists()) {
                    int cont = 0;
                    FileInputStream fis = new FileInputStream(fichero);
                    DataInputStream dis = new DataInputStream(fis);

                    // Nos aseguramos de que haya como máximo 5 opciones en el comboBox
                    while (cont < 5) {
                        try {
                            String nombre = dis.readUTF();
                            dis.readInt();
                            dis.readUTF();
                            dis.readUTF();
                            dis.readUTF();

                            // Agregamos el nombre del país al comboBox
                            comboBox.getItems().add(nombre);
                            cont++;
                        } catch (IOException e) {
                            break;
                        }
                    }
                    dis.close();
                    fis.close();
                } else {
                    textArea.setText("No hay países guardados.");
                }
            } catch (IOException e) {
                textArea.setText("Error al cargar los países guardados.");
            }
            textArea.clear();
        }
    }

    // Método para rellenar el textArea con la información del país escogido
    public void onRellenarTextArea() {
        String paisSeleccionado = comboBox.getValue();

        if (paisSeleccionado == null) {
            textArea.setText("No hay países guardados.");
            return;
        }

        try {
            FileInputStream fis = new FileInputStream(ruta);
            DataInputStream dis = new DataInputStream(fis);

            // Recorremos el fichero y cuando encuentre el nombre que seleccionamos agregará
            // la información de ese país al textArea y saldrá del while
            while (true) {
                String nombre = dis.readUTF();
                int poblacion = dis.readInt();
                String idioma = dis.readUTF();
                String moneda = dis.readUTF();
                String continente = dis.readUTF();

                if (nombre.equals(paisSeleccionado)) {
                    textArea.setText("Nombre: " + nombre + "\n" +
                            "Población: " + poblacion + "\n" +
                            "Idioma: " + idioma + "\n" +
                            "Moneda: " + moneda + "\n" +
                            "Continente: " + continente);
                    return;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para que dirá si ya se ha guardado anteriormente el nombre del país que acabamos
    // de escribir
    private boolean existePais(String nombrePais) throws IOException {
        File fichero = new File(ruta);

        if (!fichero.exists()) {
            return false;
        }

        // Abrimos un fichero binario indicando la ruta con FileInputStream y convertimos de bytes
        // a caracteres legibles con DataInputStream
        FileInputStream fis = new FileInputStream(ruta);
        DataInputStream dis = new DataInputStream(fis);

        // Usamos un while (true) para que lea el fichero hasta que este llegue a su fin
        while (true) {
            try {
                String nombreGuardado = dis.readUTF();
                dis.readInt();
                dis.readUTF();
                dis.readUTF();
                dis.readUTF();

                // Si el nombre del país guardado es el mismo que el que hemos escrito devolveremos true,
                // si no false
                if (nombreGuardado.equalsIgnoreCase(nombrePais)) {
                    return true;
                }
            } catch (IOException e) {
                break;
            }
        }

        //Cerramos el fichero
        dis.close();
        fis.close();

        return false;
    }

    // Método para guardar los datos en el fichero
    private void guardarPais(String nombre, int poblacion, String idioma,
                             String moneda, String continente) throws IOException {

        // Abrimos el fichero indicado en ruta sin borrar lo que ya contiene
        FileOutputStream fos = new FileOutputStream(ruta, true);
        DataOutputStream dos = new DataOutputStream(fos);

        // Guardamos en el fichero los datos que damos por parámetros del método
        dos.writeUTF(nombre);
        dos.writeInt(poblacion);
        dos.writeUTF(idioma);
        dos.writeUTF(moneda);
        dos.writeUTF(continente);

        // Cerramos el fichero
        dos.close();
        fos.close();
    }

    // Método para que al hacer click en ciertos botones cambie la vista
    public void cambiarVentana(ActionEvent actionEvent) throws IOException {
        String vista;

        // Dependiendo de lo que haya en botón guardaremos en la variable el nombre de la vista
        if (actionEvent.getSource() == botonAtras) {
            vista = "vistaMenu.fxml";
        } else if (actionEvent.getSource() == botonVentanaIntroducir) {
            vista = "hello-view.fxml";
        } else if (actionEvent.getSource() == botonVentanaElegir) {
            vista = "segundaVista.fxml";
        } else {
            return;
        }

        // Cambiamos la vista usando la variable anterior
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(vista));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);

        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
}