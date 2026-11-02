package services;

import Entity.PersonaEntity;
import model.PersonaDAO;

import java.util.ArrayList;

public class PersonaService {

    PersonaDAO personaDAO;

    public boolean altaPersona(PersonaEntity p){

        personaDAO = new PersonaDAO();

        if(p.getNombre().length() < 2 || p.getNombre().length() > 50){
            return false;
        }

        if(p.getApellido().length() < 1 || p.getApellido().length() > 100){
            return false;
        }

        if(p.getEdad() < 18 || p.getEdad() > 120){
            return false;
        }

        return personaDAO.altaPersona(p);
    }


    public void consultaPersona(PersonaEntity p){

        personaDAO = new PersonaDAO();
        PersonaEntity pers =  personaDAO.consultaPersona(p);

        if(pers != null){
            System.out.println(pers);
        }else{
            System.out.println("No existe la persona");
        }
    }

    public void eliminarPersona(PersonaEntity p){

        personaDAO = new PersonaDAO();
        boolean estaEliminado =  personaDAO.eliminarPersona(p);

        if(estaEliminado){
            System.out.println("La persona ha sido eliminada");
        }else{
            System.out.println("La persona no existe");
        }

    }

    //mirar
    public void listadoPersona(){

        personaDAO = new PersonaDAO();

        ArrayList<PersonaEntity> lista = personaDAO.listadoPersona();

        for (PersonaEntity p : lista){
            System.out.println(p);
        }
    }
    //mirar
    public void modificarPersona(PersonaEntity p){

        personaDAO = new PersonaDAO();

        boolean estaModificada = personaDAO.modificarPersona(p);

        if(estaModificada){
            System.out.println("\nPersona modificada\n");
        }else{
            System.out.println("\nPersona no existe \n");
        }

    }

}
