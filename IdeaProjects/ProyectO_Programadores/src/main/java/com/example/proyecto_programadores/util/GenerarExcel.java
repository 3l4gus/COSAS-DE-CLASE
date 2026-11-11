package com.example.proyecto_programadores.util;

import com.example.proyecto_programadores.entity.Usuario;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GenerarExcel {
    public static void generarExcel(List<Usuario> usuarios) throws IOException {
        int numFila = 1;

        FileOutputStream fos = new FileOutputStream("programadores.xlsx");

        Workbook libro = new SXSSFWorkbook();
        Sheet hojas = libro.createSheet("datos_programadores");

        // La primera fila contendrá los nombres de los atributos del usuario
        Row cabecera = hojas.createRow(0);

        cabecera.createCell(0).setCellValue("Nombre");
        cabecera.createCell(1).setCellValue("Género");
        cabecera.createCell(2).setCellValue("Lenguaje");

        // Recorremos la lista de usuarios que le pasamos como parámetro y los vamos agregando a la tabla
        for(Usuario u : usuarios) {
            Row fila1 = hojas.createRow(numFila);

            fila1.createCell(0).setCellValue(u.getNombre());
            fila1.createCell(1).setCellValue(u.getGenero());
            fila1.createCell(2).setCellValue(u.getLenguaje());

            numFila++;
        }
        libro.write(fos);
        fos.close();
        libro.close();
    }
}
