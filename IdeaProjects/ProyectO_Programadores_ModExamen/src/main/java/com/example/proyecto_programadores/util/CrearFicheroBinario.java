package com.example.proyecto_programadores.util;

import com.example.proyecto_programadores.entity.Usuario;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CrearFicheroBinario {
    public static void generarBinario(List<Usuario> usuarios) throws IOException {
        String nombre = "", contrasena = "", genero = "", lenguaje = "";

        FileOutputStream fos = new FileOutputStream("ficheroBinario.dat", true);
        DataOutputStream dos = new DataOutputStream(fos);

        for (Usuario u : usuarios){
            nombre = u.getNombre();
            contrasena = u.getContrasena();
            genero = u.getGenero();
            lenguaje = u.getLenguaje();

            dos.writeUTF(nombre);
            dos.writeUTF(contrasena);
            dos.writeUTF(genero);
            dos.writeUTF(lenguaje);
        }
        dos.close();
        fos.close();
    }
}
