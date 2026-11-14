package com.example.proyecto_programadores.util;

import com.example.proyecto_programadores.entity.Usuario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CrearFicheroSecuencial {
    public static void generarSecuencial(List<Usuario> usuarios) throws IOException {
        FileWriter fw = new FileWriter("ficheroSecuencialProgramadores.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (Usuario u : usuarios){
            bw.write(u.toString());
            bw.newLine();
        }
        bw.close();
    }
}
