package com.petcare.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.petcare.entity.Veterinario;
import com.petcare.util.ConexionDb4o;

import java.util.ArrayList;

public class VeterinarioDAO {

    // Objeto utilizado para abrir conexiones con la base de datos
    ConexionDb4o conexionDb4o;

    // Método que registra un nuevo veterinario asignándole automáticamente un ID
    public boolean registrarVeterinario(Veterinario v){
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        // Calcula el siguiente ID disponible y lo asigna al veterinario
        int id = calcularIDVeterinario(bd);
        v.setId(id);

        // Guarda el veterinario, confirma los cambios y cierra la conexión
        bd.store(v);
        bd.commit();
        bd.close();
        return true;
    }

    // Método que calcula el siguiente ID disponible recorriendo todas los veterinarios guardados
    private int calcularIDVeterinario(ObjectContainer bd) {
        ObjectSet<Veterinario> veterinarios = bd.queryByExample(new Veterinario());

        int maxId = 0;

        // Calcula el siguiente ID disponible y lo asigna a la mascota
        for (Veterinario v : veterinarios) {
            if (v.getId() > maxId) {
                maxId = v.getId();
            }
        }
        return maxId + 1;
    }

    // Método que comprueba si ya existe un veterinario con el número de colegiado indicado
    public boolean buscarNumColegiado(String numColegiado) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        // Creamos un veterinario provisional solo con el número de colegiado para buscar por ese campo.
        Veterinario veterinario = new Veterinario();
        veterinario.setNumColegiado(numColegiado);
        ObjectSet<Veterinario> resultado = bd.queryByExample(veterinario);

        // Si hay resultados, el número de colegiado ya está registrado
        boolean existe = resultado.size() > 0;

        bd.close();
        return existe;
    }

    // Método que busca un veterinario por el número de colegiado del objeto recibido
    public Veterinario buscarVeterinarioPorColegiado(Veterinario v) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        ObjectSet<Veterinario> resultado = bd.queryByExample(v);

        // Si existe una coincidencia, devuelve el veterinario encontrado
        if(resultado.hasNext()){
            v = resultado.next();
            bd.close();
            return v;
        }
        bd.close();
        return null;
    }

    // Método que devuelve una lista con todos los veterinarios guardados
    public ArrayList<Veterinario> listarVeterinarios() {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        ObjectSet<Veterinario> resultado = bd.queryByExample(new Veterinario());
        ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();

        // Añade cada veterinario encontrado a la lista
        for (Veterinario veterinario : resultado){
            listaVeterinarios.add(veterinario);
        }
        bd.close();
        return listaVeterinarios;
    }

    // Método que modifica la especialidad de un veterinario buscado por su ID
    public boolean modificarEspecialidadVeterinario(Veterinario v) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        // Creamos una mascota provisional con el ID para buscar el veterinario
        Veterinario veterinarioProv = new Veterinario();
        veterinarioProv.setId(v.getId());
        ObjectSet<Veterinario> resultado = bd.queryByExample(veterinarioProv);

        // Si no existe el veterinario, cierra la conexión y devuelve false
        if (!resultado.hasNext()) {
            bd.close();
            return false;
        }

        // Creamos otro veterinario para almacenar en él el que está en la base de datos y le
        // modificamos la especialidad
        Veterinario veterinario = resultado.next();
        veterinario.setEspecialidad(v.getEspecialidad());

        // Guarda el veterinario, confirma los cambios y cierra la conexión
        bd.store(veterinario);
        bd.commit();
        bd.close();
        return true;
    }

    // Método que elimina un veterinario de la base de datos buscando por su ID
    public boolean eliminarVeterinario(Veterinario v) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        // Creamos una mascota provisional con el ID para buscar el veterinario
        Veterinario veterinarioProv = new Veterinario();
        veterinarioProv.setId(v.getId());
        ObjectSet<Veterinario> resultado = bd.queryByExample(veterinarioProv);

        // Si no existe el veterinario, cierra la conexión y devuelve false
        if (!resultado.hasNext()) {
            bd.close();
            return false;
        }

        // Creamos otro veterinario para almacenar en él el que está en la base de datos
        Veterinario veterinario = resultado.next();

        // Borra el veterinario, confirma los cambios y cierra la conexión
        bd.delete(veterinario);
        bd.commit();
        bd.close();
        return true;
    }
}