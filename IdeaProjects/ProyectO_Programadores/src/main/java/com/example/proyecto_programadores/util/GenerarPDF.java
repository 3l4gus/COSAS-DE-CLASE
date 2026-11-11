package com.example.proyecto_programadores.util;


import com.example.proyecto_programadores.entity.Usuario;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class GenerarPDF {
    public static void generarPDF(List<Usuario> usuarios) throws FileNotFoundException {
        Document doc = new Document();

        FileOutputStream fos = new FileOutputStream("programadores.pdf");

        PdfWriter.getInstance(doc, fos);

        doc.open();

        // Ponemos un título
        doc.add(new Paragraph("Listado de Programadores"));
        doc.add(new Paragraph("\n\n"));

        PdfPTable tabla = new PdfPTable(3);

        // La primera fila contendrá los nombres de los atributos del usuario
        tabla.addCell("Nombre");
        tabla.addCell("Genero");
        tabla.addCell("Lenguaje");

        // Recorremos la lista de usuarios que le pasamos como parámetro y los vamos agregando a la tabla
        for (Usuario u : usuarios) {
            tabla.addCell(u.getNombre());
            tabla.addCell(u.getGenero());
            tabla.addCell(u.getLenguaje());
        }

        doc.add(tabla);

        doc.close();
    }
}
