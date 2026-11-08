package com.example.proyecto_programadores.util;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class ConexionDb4o {
    static final String DB_FILE = "comunidadProgramadores.db4o";

    // Método que abre una conexión con el archivo de base de datos indicado
    public ObjectContainer abrirConexion(){
        return Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB_FILE);
    }
}
