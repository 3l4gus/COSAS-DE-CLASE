package com.petcare.services;

import com.petcare.dao.MascotaDAO;
import com.petcare.dao.VeterinarioDAO;
import com.petcare.entity.Mascota;
import com.petcare.entity.Veterinario;

import java.util.ArrayList;

public class VeterinarioService {

    // DAO utilizado para acceder a la base de datos de veterinarios
    VeterinarioDAO VeterinarioDAO;

    // Método que registra un veterinario si todos sus datos son válidos y el número de colegiado no se repite
    public boolean registrarVeterinario(Veterinario v){
        VeterinarioDAO = new VeterinarioDAO();

        // El número de colegiado debe tener entre 1 y 20 caracteres
        if(v.getNumColegiado().length() < 1 || v.getNumColegiado().length() > 20){
            System.out.println("Número de colegiado no válido.");
            return false;
        }

        // El nombre debe tener entre 1 y 50 caracteres
        if(v.getNombre().length() < 1 || v.getNombre().length() > 50){
            System.out.println("Nombre no válido.");
            return false;
        }

        // La especialidad debe tener entre 1 y 30 caracteres
        if(v.getEspecialidad().length() < 1 || v.getEspecialidad().length() > 30){
            System.out.println("Especialidad no válida.");
            return false;
        }

        // El número de colegiado debe ser único
        if (VeterinarioDAO.buscarNumColegiado(v.getNumColegiado())) {
            System.out.println("El número de colegiado debe ser único.");
            return false;
        }

        // Si el nuevo veterinario es válido aparecerá un mensaje que lo confirma y lo registra
        boolean registrado = VeterinarioDAO.registrarVeterinario(v);

        if (registrado) {
            System.out.println("Veterinario registrado.");
        }
        return registrado;
    }

    // Método que busca un veterinario por su número de colegiado y lo muestra por consola
    public void buscarVeterinarioPorColegiado(Veterinario v) {
        VeterinarioDAO = new VeterinarioDAO();
        Veterinario veterinario = VeterinarioDAO.buscarVeterinarioPorColegiado(v);

        if(veterinario != null){
            System.out.println(veterinario);
        }else{
            System.out.println("No existe el veterinario.");
        }
    }

    // Método que muestra todos los veterinarios registrados en la base de datos
    public void listarVeterinarios() {
        VeterinarioDAO = new VeterinarioDAO();
        ArrayList<Veterinario> listaVeterinarios = VeterinarioDAO.listarVeterinarios();

        for (Veterinario veterinario : listaVeterinarios){
            System.out.println(veterinario);
        }
    }

    // Método que modifica la especialidad del veterinario
    public void modificarEspecialidadVeterinario(Veterinario v) {
        VeterinarioDAO = new VeterinarioDAO();
        boolean estaModificada = VeterinarioDAO.modificarEspecialidadVeterinario(v);

        if(estaModificada){
            System.out.println("\nVeterinario modificado.\n");
        }else{
            System.out.println("\nVeterinario no existe.\n");
        }
    }

    // Método para eliminar un veterinario de la base de datos por su ID
    public void eliminarVeterinario(Veterinario v) {
        VeterinarioDAO = new VeterinarioDAO();
        boolean estaEliminado =  VeterinarioDAO.eliminarVeterinario(v);

        if(estaEliminado){
            System.out.println("El veterinario ha sido eliminada.");
        }else{
            System.out.println("El veterinario no existe.");
        }
    }
}
