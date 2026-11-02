package model;

import Entity.PersonaEntity;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;

public class PersonaDAO {


    ConexionBD conexionBD;

    public boolean altaPersona(PersonaEntity p){

        conexionBD = new ConexionBD();

        ObjectContainer bd = conexionBD.abrirConexion();

        int id = calcularID(bd);
        p.setId(id);

        bd.store(p);
        bd.commit();

        bd.close();
        return true;
    }

    private int calcularID( ObjectContainer bd) {

        ObjectSet<PersonaEntity> todasPersonas = bd.queryByExample(new PersonaEntity());

        int maxId = 0;

        for (PersonaEntity p : todasPersonas) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }


    public PersonaEntity consultaPersona(PersonaEntity p){

        conexionBD = new ConexionBD();

        ObjectContainer bd = conexionBD.abrirConexion();
        ObjectSet<PersonaEntity> todasPersonas = bd.queryByExample(p);

        PersonaEntity pers = null;

        if(todasPersonas.hasNext()){
            pers = todasPersonas.next();
        }


        bd.close();

        return pers;
    }


    public boolean eliminarPersona(PersonaEntity p){

        conexionBD = new ConexionBD();

        ObjectContainer bd = conexionBD.abrirConexion();

        PersonaEntity pers = buscarPersonaPorId(bd, p);

        if(pers != null){
            bd.delete(pers);
            bd.commit();
            bd.close();
            return true;
        }
        bd.close();
        return false;
    }


    private PersonaEntity buscarPersonaPorId(ObjectContainer db, PersonaEntity p) {

        ObjectSet<PersonaEntity> resultado = db.queryByExample(p);

        if(resultado.hasNext()){
            p = resultado.next();
            return p;
        }
        return null;
    }

    public ArrayList<PersonaEntity> listadoPersona(){

        conexionBD = new ConexionBD();

        ObjectContainer bd = conexionBD.abrirConexion();

        ObjectSet<PersonaEntity> resultado = bd.queryByExample(new PersonaEntity());

        //select * from persona where id != 0;

        ArrayList<PersonaEntity> listaPersonas = new ArrayList<>();

        for (PersonaEntity p: resultado){
            listaPersonas.add(p);
        }
        bd.close();
        return listaPersonas;

    }

    public boolean modificarPersona(PersonaEntity p){

        conexionBD = new ConexionBD();

        ObjectContainer bd = conexionBD.abrirConexion();

        PersonaEntity pers = new PersonaEntity();
        pers.setId(p.getId());

        pers = buscarPersonaPorId(bd, pers);

        pers.setNombre(p.getNombre());
        pers.setApellido(p.getApellido());
        pers.setEdad(p.getEdad());



        if(pers != null){
            bd.store(pers);
            bd.commit();
            bd.close();
            return true;
        }else{
            bd.close();
            return false;
        }
    }
}
