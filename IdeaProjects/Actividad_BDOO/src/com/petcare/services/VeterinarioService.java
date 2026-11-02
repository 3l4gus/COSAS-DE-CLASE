package com.petcare.services;

import com.petcare.dao.MascotaDAO;
import com.petcare.dao.VeterinarioDAO;
import com.petcare.entity.Mascota;
import com.petcare.entity.Veterinario;

public class VeterinarioService {

    VeterinarioDAO VeterinarioDAO;

    public boolean registrarVeterinario(Veterinario v){
        VeterinarioDAO = new VeterinarioDAO();

        if(v.getNumColegiado().isEmpty() || v.getNumColegiado().length() > 20){
            System.out.println("Número de colegiado no válido.");
            return false;
        }

        if(v.getNombre().isEmpty() || v.getNombre().length() > 50){
            System.out.println("Nombre no válido.");
            return false;
        }

        if(v.getEspecialidad().isEmpty() || v.getEspecialidad().length() > 30){
            System.out.println("Especialidad no válida.");
            return false;
        }

        if (VeterinarioDAO.buscarNumColegiado(v.getNumColegiado())) {
            System.out.println("El chip debe ser único.");
            return false;
        }

        System.out.println("Veterinario registrado");
        return VeterinarioDAO.registrarVeterinario(v);
    }

    public void buscarVeterinarioPorColegiado(Veterinario v) {
        VeterinarioDAO = new VeterinarioDAO();
        Veterinario veterinario = VeterinarioDAO.buscarVeterinarioPorColegiado(v);

        if(veterinario != null){
            System.out.println(veterinario);
        }else{
            System.out.println("No existe el veterinario.");
        }
    }
}
