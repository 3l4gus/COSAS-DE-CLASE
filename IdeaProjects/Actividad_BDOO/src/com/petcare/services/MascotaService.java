package com.petcare.services;

import com.petcare.dao.MascotaDAO;
import com.petcare.entity.Mascota;

import java.util.ArrayList;

public class MascotaService {

    // DAO utilizado para acceder a la base de datos de mascotas
    MascotaDAO MascotaDAO;

    // Método que registra una mascota si todos sus datos son válidos y el chip no se repite
    public boolean registrarMascota(Mascota m){
        MascotaDAO = new MascotaDAO();

        // El chip debe tener entre 1 y 20 caracteres
        if(m.getChip().length() < 1 || m.getChip().length() > 20){
            System.out.println("Chip no válido.");
            return false;
        }

        // El nombre debe tener entre 1 y 50 caracteres
        if(m.getNombre().length() < 1 || m.getNombre().length() > 50){
            System.out.println("Nombre no válido.");
            return false;
        }

        // La especie debe tener entre 1 y 50 caracteres
        if(m.getEspecie().length() < 1 || m.getEspecie().length() > 50){
            System.out.println("Especie no válida.");
            return false;
        }

        // La edad debe tener estar entre 0 y 100
        if(m.getEdad() < 0 || m.getEdad() > 100){
            System.out.println("Edad no válida.");
            return false;
        }

        // El chip debe ser único
        if (MascotaDAO.buscarChip(m.getChip())) {
            System.out.println("El chip debe ser único.");
            return false;
        }

        // Si la nueva mascota es válida aparecerá un mensaje que lo confirma y lo registra
        boolean registrada = MascotaDAO.registrarMascota(m);

        if (registrada) {
            System.out.println("Mascota registrada.");
        }
        return registrada;
    }

    // Método que busca una mascota por su chip y la muestra por consola
    public void buscarMascotaPorChip(Mascota m){
        MascotaDAO = new MascotaDAO();
        Mascota mascota = MascotaDAO.buscarMascotaPorChip(m);

        if(mascota != null){
            System.out.println(mascota);
        }else{
            System.out.println("No existe la mascota.");
        }
    }

    // Método que muestra todas las mascotas registradas en la base de datos
    public void listarMascotas() {
        MascotaDAO = new MascotaDAO();
        ArrayList<Mascota> listaMascotas = MascotaDAO.listarMascotas();

        for (Mascota mascota : listaMascotas){
            System.out.println(mascota);
        }
    }

    // Método que modifica el nombre o la edad dependiendo del número de opción tenga como parámetro
    public void modificarDatosMascota(Mascota m, int opcion) {
        MascotaDAO = new MascotaDAO();
        boolean estaModificada = MascotaDAO.modificarDatosMascota(m, opcion);

        if(estaModificada){
            System.out.println("\nMascota modificada.\n");
        }else{
            System.out.println("\nMascota no existe.\n");
        }
    }

    // Método para eliminar una mascota de la base de datos por su ID
    public void eliminarMascota(Mascota m) {
        MascotaDAO = new MascotaDAO();
        boolean estaEliminado =  MascotaDAO.eliminarMascota(m);

        if(estaEliminado){
            System.out.println("La mascota ha sido eliminada.");
        }else{
            System.out.println("La mascota no existe.");
        }
    }
}
