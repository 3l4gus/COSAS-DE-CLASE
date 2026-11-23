package com.example.examennelsontrimestre1_agustinolivera.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Datos {
    private String contrasena;
    private int numero;
    private String opcion;

    public String toString() {
        return "\nContraseña: " + contrasena +
                "\nNúmero: " + numero +
                "\nOpción: " + opcion +
                "\n";
    }
}
