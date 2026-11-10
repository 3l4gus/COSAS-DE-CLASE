package com.example.proyecto_programadores.util;

import java.io.FileOutputStream;

public class GenerarPDF {
    public static void generarPDF(String nombre, String genero, String lenguaje){
        Document doc = new Document();

        FileOutputStream fos = new FileOutputStream("empleados.xlsx");

        PdfWriter.getInstance(doc, fos);

        doc.open();

        doc.add(new Paragraph("Listado empleados"));
        doc.add(new Paragraph("\n\n"));

        PdfPTable tabla = new PdfPTable(3);

        tabla.addCell("Nombre");
        tabla.addCell("Edad");
        tabla.addCell("Correo");

        tabla.addCell(n);
        tabla.addCell(String.valueOf(e));
        tabla.addCell(c);

        doc.add(tabla);

        doc.close();
    }
}
