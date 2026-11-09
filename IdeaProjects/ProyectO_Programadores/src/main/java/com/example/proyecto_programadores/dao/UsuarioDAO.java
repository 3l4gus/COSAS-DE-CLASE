package com.example.proyecto_programadores.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.example.proyecto_programadores.entity.Usuario;
import com.example.proyecto_programadores.util.ConexionDb4o;

public class UsuarioDAO {

    // Objeto utilizado para abrir conexiones con la base de datos
    ConexionDb4o conexionDb4o;

    // Método que devuelve el usuario si el nombre y la contraseña son correctos, o null si no
    public Usuario comprobarUsuario(String nombre, String contrasena) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        Usuario u = buscarPorNombre(bd, nombre);

        bd.close();

        if (u != null && u.getContrasena().equals(contrasena)) {
            return u;
        }
        return null;
    }

    private Usuario buscarPorNombre(ObjectContainer bd, String nombre) {
        Usuario usuarioBuscado = new Usuario();
        usuarioBuscado.setNombre(nombre);

        ObjectSet<Usuario> resultado = bd.queryByExample(usuarioBuscado);

        if (resultado.hasNext()) {
            return resultado.next();
        }

        return null;
    }

    public Usuario consultarNombre(String nombre) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        Usuario u = buscarPorNombre(bd, nombre);

        bd.close();
        return u;
    }

    // Método que guarda un nuevo usuario en la base de datos
    public void registrarUsuario(Usuario u) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        bd.store(u);
        bd.commit();

        bd.close();
    }
}
