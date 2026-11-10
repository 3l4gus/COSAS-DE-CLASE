package com.example.proyecto_programadores.util;

import java.io.FileOutputStream;

public class GenerarExcel {
    public static void generarExcel(String nombre, String genero, String lenguaje){
        GenerarPDF pdf = new GenerarPDF();

        String r = pdf.getRuta();

        FileOutputStream fos = new FileOutputStream("empleados.xlsx");

        Workbook libro = new SXSSFWorkbook();
        Sheet hojas = libro.createSheet("nombre_empleado");

        Row cabecera = hojas.createRow(0);

        cabecera.createCell(0).setCellValue("Nombre");
        cabecera.createCell(1).setCellValue("Edad");
        cabecera.createCell(2).setCellValue("Correo");

        Row fila1 = hojas.createRow(1);

        fila1.createCell(0).setCellValue(n);
        fila1.createCell(1).setCellValue(e);
        fila1.createCell(2).setCellValue(c);

        libro.write(fos);
        fos.close();
        libro.close();
    }
}
