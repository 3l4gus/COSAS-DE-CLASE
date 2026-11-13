package com.example.proyecto_programadores.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.example.proyecto_programadores.entity.Usuario;
import com.example.proyecto_programadores.util.ConexionDb4o;

import java.util.ArrayList;

public class UsuarioDAO {

    // Objeto utilizado para abrir conexiones con la base de datos
    ConexionDb4o conexionDb4o;

    // Método que devuelve el usuario si el nombre y la contraseña son correctos, o null si no
    public Usuario comprobarUsuario(String nombre, String contrasena) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        // Buscamos el usuario por su nombre
        Usuario u = buscarPorNombre(bd, nombre);

        bd.close();

        // Si el usuario existe y la contraseña coincide, devolvemos el usuario, si no devolvemos null
        if (u != null && u.getContrasena().equals(contrasena)) {
            return u;
        }
        return null;
    }

    // Método que busca un usuario en la base de datos a partir de su nombre
    public Usuario buscarPorNombre(ObjectContainer bd, String nombre) {

        // Creamos un usuario provisional y le asignamos el nombre que queremos buscar
        Usuario usuarioBuscado = new Usuario();
        usuarioBuscado.setNombre(nombre);

        // Buscamos en la base de datos los usuarios que coincidan con el nombre
        ObjectSet<Usuario> resultado = bd.queryByExample(usuarioBuscado);

        // Si hemos encontrado algún usuario, devolvemos el primero, si no devolvemos null
        if (resultado.hasNext()) {
            return resultado.next();
        }
        return null;
    }

    // Método que busca y devuelve un usuario a partir de su nombre
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

        // Guardamos el usuario y confirmamos los cambios
        bd.store(u);
        bd.commit();

        bd.close();
    }

    // Método que devuelve una lista con los programadores del lenguaje que pasamos por parámetro.
    // Con "Todos" devuelve todos menos el usuario indicado en 'excluir'
    public ArrayList<Usuario> listarPorLenguaje(String lenguaje, String excluir) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        // Creamos un usuario provisional para guardar el lenguaje pasado por parámetro en él
        // si este no es "Todos"
        Usuario usuarioProv = new Usuario();

        if (!lenguaje.equals("Todos")) {
            usuarioProv.setLenguaje(lenguaje);
        }

        // Buscamos en la base de datos los usuarios que conicidan con el lenguaje buscado y los guardamos
        // en el ObjectSet y creamos un arrayList
        ObjectSet<Usuario> resultado = bd.queryByExample(usuarioProv);
        ArrayList<Usuario> usuarios = new ArrayList<>();

        // Añadimos cada usuario encontrado al array
        for (Usuario u : resultado) {

            // Cuando en parámetro pasemos "Todos" no incluiremos en la lista el usuario que tenga
            // el nombre que pasamos por parámetro el cual será el que ha iniciado sesión
            if (lenguaje.equals("Todos") && u.getNombre().equals(excluir)) {
                continue;
            }
            usuarios.add(u);
        }
        bd.close();

        return usuarios;
    }

    // Método que actualiza los datos del usuario que coincide con el nombre del usuario que
    // pasamos por parámetro
    public void modificarUsuario(Usuario usuarioActualizado) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        // Buscamos el usuario guardado y si existe le cambiamos los datos
        Usuario u = buscarPorNombre(bd, usuarioActualizado.getNombre());
        if (u != null) {
            u.setContrasena(usuarioActualizado.getContrasena());
            u.setGenero(usuarioActualizado.getGenero());
            u.setLenguaje(usuarioActualizado.getLenguaje());

            bd.store(u);
            bd.commit();
        }
        bd.close();
    }
}
