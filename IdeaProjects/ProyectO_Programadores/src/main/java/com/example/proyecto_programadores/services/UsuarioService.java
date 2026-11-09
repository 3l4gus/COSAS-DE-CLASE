package com.example.proyecto_programadores.services;

import com.example.proyecto_programadores.dao.UsuarioDAO;
import com.example.proyecto_programadores.entity.Usuario;

public class UsuarioService {

    // DAO utilizado para acceder a la base de datos de usuarios
    UsuarioDAO UsuarioDAO = new UsuarioDAO();

    // Método que valida si el nombre y la contraseña son válidos, y devolverá un String error
    // si alguno no es válido
    public String validarLogin(String nombre, String contrasena) {
        String error = validarNombre(nombre);

        if (error == null){
            error = validarContrasena(contrasena);
        }
        return error;
    }


    // Método para validar que el nombre no esté vacío y tenga al menos 5 caracteres
    public String validarNombre(String nombre){
        if (nombre == null || nombre.isEmpty()) {
            return "El nombre de usuario no puede estar vacío.";
        }

        if (nombre.length() < 5) {
            return "El nombre de usuario debe tener al menos 5 caracteres.";
        }
        return null;
    }

    // Método para validar que la contraseña tiene al menos 8 caracteres, una mayúscula y
    // una minúscula
    public String validarContrasena(String contrasena){
        if (contrasena == null || contrasena.length() < 8) {
            return "La contraseña debe tener al menos 8 caracteres.";
        }

        boolean tieneMayuscula = false, tieneMinuscula = false;

        // Recorremos la contraseña y comprobamos si cada letra es mayúscula o minúscula,
        // si encuentra las dos sale del for
        for (int i = 0; i < contrasena.length(); i++) {
            char caracter = contrasena.charAt(i);

            if (Character.isUpperCase(caracter)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(caracter)) {
                tieneMinuscula = true;
            }

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
    public String validarGenero(String genero){
        if (genero == null) {
            return "Selecciona un género.";
        }
        return null;
    }

    // Método para validar que hay un lenguaje seleccionado
    public String validarLenguaje(String lenguaje){
        if (lenguaje == null) {
            return "Selecciona un lenguaje.";
        }
        return null;
    }

    // Método para validar que el nombre no está en la base de datos
    private String validarNombreNoRepetido(String nombre) {
        if (UsuarioDAO.consultarNombre(nombre) != null) {
            return "Ya existe un usuario con ese nombre.";
        }
        return null;
    }

    public Usuario login(String nombre, String contrasena) {
        return UsuarioDAO.comprobarUsuario(nombre, contrasena);
    }

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

    public void registrarUsuario(Usuario u) {
        UsuarioDAO.registrarUsuario(u);

    }
}
