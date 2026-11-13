package com.example.proyecto_programadores;

import com.example.proyecto_programadores.dao.UsuarioDAO;
import com.example.proyecto_programadores.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroController {

    @FXML
    private TextField txtNombreRegistro;

    @FXML
    private TextField txtPasswordRegistro;

    @FXML
    private RadioButton rbHombre;

    @FXML
    private RadioButton rbMujer;

    @FXML
    private RadioButton rbPrefieroNoDecirlo;

    @FXML
    private ComboBox<String> cbLenguajeRegistro;

    // Método que se ejecuta al abrir la ventana de registrarse
    @FXML
    public void initialize() {
        cbLenguajeRegistro.getItems().addAll("Java", "Python", "JavaScript");
    }

    // Método que se ejecuta al hacer click en el botón de registrarse
    public void onRegistrarBotonClick(ActionEvent actionEvent) throws IOException {

        // Guardamos los datos introducidos por el usuario
        String nombre = txtNombreRegistro.getText().trim();
        String contrasena = txtPasswordRegistro.getText();
        String lenguaje = cbLenguajeRegistro.getValue();
        String genero = obtenerGeneroSeleccionado();

        // Validamos el formato de los datos, si alguno no es válido se guardará un String en error y
        // mostrará una ventana emergente de error
        String error = validarRegistro(nombre, contrasena, genero, lenguaje);

        if (error != null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", error);
            return;
        }

        // Al ser todo válido guardamos el usuario en la base de datos, mostramos una ventana emergente
        // confirmando que se ha registrado y volvemos al login
        Usuario u = new Usuario(nombre, contrasena, genero, lenguaje);

        if (!registrar(u)) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se ha podido registrar el usuario.");
            return;
        }
        mostrarAlerta(Alert.AlertType.INFORMATION, "Registro", "Usuario registrado correctamente.");

        volverAlLogin(actionEvent);

    }

    // Método que se ejecuta al hacer click en el botón de volver al login
    public void onVolverAlLoginBotonClick(ActionEvent actionEvent) throws IOException {
        volverAlLogin(actionEvent);
    }

    // Método que valida todos los datos del registro.
    public String validarRegistro(String nombre, String contrasena, String genero, String lenguaje) {
        String error = validarNombre(nombre);

        if (error == null) {
            error = validarNombreNoRepetido(nombre);
        }

        if (error == null) {
            error = validarContrasena(contrasena);
        }

        if (error == null) {
            error = validarGenero(genero);
        }

        if (error == null) {
            error = validarLenguaje(lenguaje);
        }

        return error;
    }

    // Método para validar que el nombre no esté vacío y tenga al menos 5 caracteres
    public String validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return "El nombre de usuario no puede estar vacío.";
        }

        if (nombre.length() < 5) {
            return "El nombre de usuario debe tener al menos 5 caracteres.";
        }

        return null;
    }

    // Método para validar que el nombre no está en la base de datos
    public String validarNombreNoRepetido(String nombre) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (usuarioDAO.consultarNombre(nombre) != null) {
            return "Ya existe un usuario con ese nombre.";
        }

        return null;
    }

    // Método para validar que la contraseña tiene al menos 8 caracteres, una mayúscula y
    // una minúscula
    public String validarContrasena(String contrasena) {
        if (contrasena == null || contrasena.length() < 8) {
            return "La contraseña debe tener al menos 8 caracteres.";
        }

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;

        // Recorremos la contraseña para comprobar si tiene mayúsculas y minúsculas
        for (int i = 0; i < contrasena.length(); i++) {
            char caracter = contrasena.charAt(i);

            if (Character.isUpperCase(caracter)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(caracter)) {
                tieneMinuscula = true;
            }

            // Si ya hemos encontrado una mayúscula y una minúscula, dejamos de comprobar
            if (tieneMayuscula && tieneMinuscula) {
                break;
            }
        }

        if (!tieneMayuscula) {
            return "La contraseña debe contener al menos una mayúscula.";
        }

        if (!tieneMinuscula) {
            return "La contraseña debe contener al menos una minúscula.";
        }

        return null;
    }

    // Método para validar que hay un género seleccionado
    public String validarGenero(String genero) {
        if (genero == null) {
            return "Selecciona un género.";
        }

        return null;
    }

    // Método para validar que hay un lenguaje seleccionado
    public String validarLenguaje(String lenguaje) {
        if (lenguaje == null) {
            return "Selecciona un lenguaje.";
        }

        return null;
    }

    // Método que guarda el usuario en la base de datos. Devuelve true si se ha registrado correctamente
    public boolean registrar(Usuario u) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.registrarUsuario(u);
        return true;
    }

    // Método que devuelve el texto del RadioButton seleccionado o null si no hay ninguno
    public String obtenerGeneroSeleccionado() {
        if (rbHombre.isSelected()) {
            return rbHombre.getText();
        }

        if (rbMujer.isSelected()) {
            return rbMujer.getText();
        }

        if (rbPrefieroNoDecirlo.isSelected()) {
            return rbPrefieroNoDecirlo.getText();
        }

        return null;
    }

    // Método que cambia la vista actual por la del login
    public void volverAlLogin(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 550);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    // Método que muestra una ventana emergente con el tipo, título y mensaje indicados
    public void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
