package com.petcare.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.petcare.entity.Mascota;
import com.petcare.util.ConexionDb4o;

public class MascotaDAO {
    ConexionDb4o conexionDb4o;

    public boolean registrarMascota(Mascota m){
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion("mascotas.db4o");

        int id = calcularIDMascota(bd);
        m.setId(id);

        bd.store(m);
        bd.commit();

        bd.close();
        return true;
    }

    private int calcularIDMascota(ObjectContainer bd) {
        ObjectSet<Mascota> mascotas = bd.queryByExample(new Mascota());

        int maxId = 0;

        for (Mascota m : mascotas) {
            if (m.getId() > maxId) {
                maxId = m.getId();
            }
        }
        return maxId + 1;
    }

    public boolean buscarChip(String chip) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion("mascotas.db4o");

        Mascota mascota = new Mascota();
        ObjectSet<Mascota> resultado = bd.queryByExample(mascota);

        boolean existe = resultado.size() > 0;

        bd.close();

        return existe;
    }

    public Mascota buscarMascotaPorChip(Mascota m) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion("mascotas.db4o");

        ObjectSet<Mascota> resultado = bd.queryByExample(m);

        if(resultado.hasNext()){
            m = resultado.next();
            return m;
        }
        return null;
    }
}
