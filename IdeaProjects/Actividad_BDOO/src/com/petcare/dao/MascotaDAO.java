package com.petcare.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.petcare.entity.Mascota;
import com.petcare.util.ConexionDb4o;

import java.util.ArrayList;

public class MascotaDAO {

    // Objeto utilizado para abrir conexiones con la base de datos
    ConexionDb4o conexionDb4o;

    // Método que registra una nueva mascota asignándole automáticamente un ID
    public boolean registrarMascota(Mascota m){
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion("mascotas.db4o");

        // Calcula el siguiente ID disponible y lo asigna a la mascota
        int id = calcularIDMascota(bd);
        m.setId(id);

        // Guarda la mascota, confirma los cambios y cierra la conexión
        bd.store(m);
        bd.commit();
        bd.close();
        return true;
    }

    // Método que calcula el siguiente ID disponible recorriendo todas las mascotas guardadas
    private int calcularIDMascota(ObjectContainer bd) {
        ObjectSet<Mascota> mascotas = bd.queryByExample(new Mascota());

        int maxId = 0;

        // Busca el ID más alto existente
        for (Mascota m : mascotas) {
            if (m.getId() > maxId) {
                maxId = m.getId();
            }
        }

        // Devuelve el siguiente ID
        return maxId + 1;
    }

    // Método que comprueba si ya existe una mascota con el chip indicado
    public boolean buscarChip(String chip) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion("mascotas.db4o");

        // Creamos una mascota provisional solo con el chip para buscar por ese campo.
        Mascota mascota = new Mascota();
        mascota.setChip(chip);
        ObjectSet<Mascota> resultado = bd.queryByExample(mascota);

        // Si hay resultados, el chip ya está registrado
        boolean existe = resultado.size() > 0;

        bd.close();
        return existe;
    }

    // Método que busca una mascota por el chip del objeto recibido
    public Mascota buscarMascotaPorChip(Mascota m) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion("mascotas.db4o");

        ObjectSet<Mascota> resultado = bd.queryByExample(m);

        // Si existe una coincidencia, devuelve la mascota encontrada
        if(resultado.hasNext()){
            m = resultado.next();
            return m;
        }
        return null;
    }

    // Método que devuelve una lista con todas las mascotas guardadas
    public ArrayList<Mascota> listarMascotas() {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion("mascotas.db4o");

        ObjectSet<Mascota> resultado = bd.queryByExample(new Mascota());
        ArrayList<Mascota> listaMascotas = new ArrayList<>();

        // Añade cada mascota encontrada a la lista
        for (Mascota mascota : resultado){
            listaMascotas.add(mascota);
        }
        bd.close();
        return listaMascotas;
    }

    // Método que modifica el nombre o la edad de una mascota buscada por su ID
    public boolean modificarDatosMascota(Mascota m, int opcion) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion("mascotas.db4o");

        // Creamos una mascota provisional con el ID para buscar la mascota
        Mascota mascotaProv = new Mascota();
        mascotaProv.setId(m.getId());
        ObjectSet<Mascota> resultado = bd.queryByExample(mascotaProv);

        // Si no existe la mascota, cierra la conexión y devuelve false
        if(!resultado.hasNext()){
            bd.close();
            return false;
        }

        // Creamos otra mascota para almacenar en ella la que está en la base de datos
        Mascota mascota = resultado.next();

        // Modificamos el nombre o la edad según la opción recibida
        if(opcion == 1){
            mascota.setNombre(m.getNombre());
        }else if(opcion == 2){
            mascota.setEdad(m.getEdad());
        }

        // Guarda la mascota, confirma los cambios y cierra la conexión
        bd.store(mascota);
        bd.commit();
        bd.close();
        return true;
    }

    // Método que elimina una mascota de la base de datos buscando por su ID
    public boolean eliminarMascota(Mascota m) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion("mascotas.db4o");

        // Creamos una mascota provisional con el ID para buscar la mascota
        Mascota mascotaProv = new Mascota();
        mascotaProv.setId(m.getId());
        ObjectSet<Mascota> resultado = bd.queryByExample(mascotaProv);

        // Si no existe la mascota, cierra la conexión y devuelve false
        if (!resultado.hasNext()) {
            bd.close();
            return false;
        }

        // Creamos otra mascota para almacenar en ella la que está en la base de datos
        Mascota mascota = resultado.next();

        // Borra la mascota, confirma los cambios y cierra la conexión
        bd.delete(mascota);
        bd.commit();
        bd.close();
        return true;
    }
}
