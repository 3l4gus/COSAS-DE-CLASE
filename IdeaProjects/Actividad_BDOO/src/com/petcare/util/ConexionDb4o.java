package com.petcare.util;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class ConexionDb4o {

    // Método que abre una conexión con el archivo de base de datos indicado
    public ObjectContainer abrirConexion(String archivo){
        return Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), archivo);
    }
}
