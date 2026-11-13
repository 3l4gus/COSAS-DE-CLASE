package com.example.proyecto_programadores.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

// Clase para guardar el nombre del usuario que ha iniciado sesión, lo hacemos static
// para usarlo en distintas clases
public class NombreUsuario {
    @Getter
    @Setter
    private static String nombreUsuario;
}
