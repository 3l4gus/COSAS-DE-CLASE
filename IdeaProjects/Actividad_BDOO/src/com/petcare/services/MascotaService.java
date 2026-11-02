package com.petcare.services;

import com.petcare.dao.MascotaDAO;
import com.petcare.entity.Mascota;

public class MascotaService {

    MascotaDAO MascotaDAO;

    public boolean registrarMascota(Mascota m){
        MascotaDAO = new MascotaDAO();

        if(m.getChip().isEmpty() || m.getChip().length() > 20){
            System.out.println("Chip no válido.");
            return false;
        }

        if(m.getNombre().isEmpty() || m.getNombre().length() > 50){
            System.out.println("Nombre no válido.");
            return false;
        }

        if(m.getEspecie().isEmpty() || m.getEspecie().length() > 50){
            System.out.println("Especie no válida.");
            return false;
        }

        if(m.getEdad() < 0 || m.getEdad() > 100){
            System.out.println("Edad no válida.");
            return false;
        }

        if (MascotaDAO.buscarChip(m.getChip())) {
            System.out.println("El chip debe ser único.");
            return false;
        }

        System.out.println("Mascota registrada.");
        return MascotaDAO.registrarMascota(m);
    }

    public void buscarMascotaPorChip(Mascota m){
        MascotaDAO = new MascotaDAO();
        Mascota mascota = MascotaDAO.buscarMascotaPorChip(m);

        if(mascota != null){
            System.out.println(mascota);
        }else{
            System.out.println("No existe la mascota.");
        }
    }
}
