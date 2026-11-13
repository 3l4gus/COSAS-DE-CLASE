package com.example.proyecto_programadores;

import com.example.proyecto_programadores.dao.UsuarioDAO;
import com.example.proyecto_programadores.entity.Usuario;
import com.example.proyecto_programadores.util.NombreUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.IOException;

public class EditarPerfilController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPassword;

    @FXML
    private RadioButton rbHombre;

    @FXML
    private RadioButton rbMujer;

    @FXML
    private RadioButton rbPrefieroNoDecirlo;

    @FXML
    private ComboBox<String> cbLenguaje;

    // Método que se ejecuta al abrir la ventana de editar perfil
    @FXML
    public void initialize(){

        // Añadimos los lenguajes disponibles al ComboBox
        cbLenguaje.getItems().addAll("Java", "Python", "JavaScript");

        // Consultamos en la base de datos los datos actuales del usuario y los mostramos
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario u = usuarioDAO.consultarNombre(NombreUsuario.getNombreUsuario());

        txtNombre.setText(u.getNombre());
        txtPassword.setText(u.getContrasena());
        cbLenguaje.setValue(u.getLenguaje());
        seleccionarGenero(u.getGenero());
    }

    // Método que se ejecuta al hacer click en el botón de guardar cambios
    public void onGuardarCambiosClick(ActionEvent actionEvent) throws IOException {

        // Guardamos los datos introducidos por el usuario
        String contrasena = txtPassword.getText();
        String lenguaje = cbLenguaje.getValue();
        String genero = obtenerGeneroSeleccionado();

        // Validamos el formato de los datos, si alguno no es válido se guardará un String en error y
        // mostrará una ventana emergente de error
        String error = validarEdicion(contrasena, genero, lenguaje);

        if (error != null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", error);
            return;
        }

        // Al ser todo válido actualizamos el usuario en la base de datos, mostramos una ventana
        // emergente confirmando el cambio y volvemos a la pantalla de inicio
        Usuario usuarioActualizado = new Usuario(NombreUsuario.getNombreUsuario(), contrasena, genero, lenguaje);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.modificarUsuario(usuarioActualizado);

        mostrarAlerta(Alert.AlertType.INFORMATION, "Perfil", "Los datos se han actualizado correctamente.");

        // Cambiamos la vista
        cambiarVista(actionEvent, "inicio.fxml", 480, 480);
    }

    // Método que se ejecuta al hacer click en el botón de cancelar
    public void onCancelarClick(ActionEvent actionEvent) throws IOException {

        // Cambiamos la vista
        cambiarVista(actionEvent, "inicio.fxml", 480, 480);
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

    // Método que selecciona el RadioButton que coincide con el género del usuario
    public void seleccionarGenero(String genero) {
        if (genero.equals(rbHombre.getText())) {
            rbHombre.setSelected(true);
        } else if (genero.equals(rbMujer.getText())) {
            rbMujer.setSelected(true);
        } else if (genero.equals(rbPrefieroNoDecirlo.getText())) {
            rbPrefieroNoDecirlo.setSelected(true);
        }
    }

    // Método que valida los datos que hemos modificado, devolviendo null si todos son válidos
    // o un String si alguno no es válido
    public String validarEdicion(String contrasena, String genero, String lenguaje) {
        String error = validarContrasena(contrasena);

        if (error == null) {
            error = validarGenero(genero);
        }

        if (error == null) {
            error = validarLenguaje(lenguaje);
        }
        return error;
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

    // Método que cambia la vista actual por otra que le indicamos en los parámetros
    public void cambiarVista(ActionEvent actionEvent, String fxml, int ancho, int alto) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), ancho, alto);

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
