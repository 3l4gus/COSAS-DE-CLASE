package com.petcare.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.petcare.entity.Mascota;
import com.petcare.entity.Veterinario;
import com.petcare.util.ConexionDb4o;

public class VeterinarioDAO {
    ConexionDb4o conexionDb4o;

    public boolean registrarVeterinario(Veterinario v){
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion("veterinarios.db4o");

        int id = calcularIDVeterinario(bd);
        v.setId(id);

        bd.store(v);
        bd.commit();

        bd.close();
        return true;
    }

    private int calcularIDVeterinario(ObjectContainer bd) {
        ObjectSet<Veterinario> veterinarios = bd.queryByExample(new Veterinario());

        int maxId = 0;

        for (Veterinario v : veterinarios) {
            if (v.getId() > maxId) {
                maxId = v.getId();
            }
        }
        return maxId + 1;
    }

    public boolean buscarNumColegiado(String numColegiado) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion("veterinarios.db4o");

        Veterinario veterinario = new Veterinario();
        ObjectSet<Veterinario> resultado = bd.queryByExample(veterinario);

        boolean existe = resultado.size() > 0;

        bd.close();

        return existe;
    }
}
