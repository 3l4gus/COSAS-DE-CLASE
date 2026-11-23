package com.example.examennelsontrimestre1_agustinolivera.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.example.examennelsontrimestre1_agustinolivera.entity.Datos;
import com.example.examennelsontrimestre1_agustinolivera.util.ConexionDb4o;

import java.util.ArrayList;

public class DatosDAO {
    ConexionDb4o conexionDb4o;

    // Registramos los datos que ya fueron validados en la base de datos
    public void registrarDatos(Datos d) {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        bd.store(d);
        bd.commit();
        bd.close();
    }

    // Devolvemos un arrayList con los datos de la base de datos
    public ArrayList<Datos> mandarDatos() {
        conexionDb4o = new ConexionDb4o();
        ObjectContainer bd = conexionDb4o.abrirConexion();

        Datos datosProv = new Datos();

        ObjectSet<Datos> resultado = bd.queryByExample(datosProv);

        ArrayList<Datos> datos = new ArrayList<>(resultado);

        bd.close();
        return datos;
    }
}
