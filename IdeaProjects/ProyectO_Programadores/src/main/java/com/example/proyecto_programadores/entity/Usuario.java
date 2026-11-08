package com.example.proyecto_programadores.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    private String nombre;
    private String contrasena;
    private String genero;
    private String lenguaje;
}
