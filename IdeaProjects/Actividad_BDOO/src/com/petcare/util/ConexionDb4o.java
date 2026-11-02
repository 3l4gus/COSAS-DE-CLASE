package com.petcare.util;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class ConexionDb4o {
    public ObjectContainer abrirConexion(String archivo){
        return Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), archivo);
    }
}
