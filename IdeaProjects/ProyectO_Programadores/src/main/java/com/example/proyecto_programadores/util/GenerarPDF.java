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

    // Método que genera un archivo PDF con los datos de los usuarios que pasamos por parámetro
    public static void generarPDF(List<Usuario> usuarios) throws FileNotFoundException {

        // Creamos el documento PDF
        Document doc = new Document();

        // Creamos el archivo PDF donde se guardarán los datos
        FileOutputStream fos = new FileOutputStream("programadores.pdf");

        // Indicamos que el documento se escribirá en el archivo creado
        PdfWriter.getInstance(doc, fos);

        // Abrimos el documento y le añadimos un título
        doc.open();
        doc.add(new Paragraph("Listado de Programadores"));
        doc.add(new Paragraph("\n\n"));

        // Creamos una tabla con 3 columanas e indicamos que la primera fila contendrá los
        // nombres de los atributos del usuario
        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("Nombre");
        tabla.addCell("Genero");
        tabla.addCell("Lenguaje");

        // Recorremos la lista de usuarios que le pasamos como parámetro y los vamos agregando a la tabla
        for (Usuario u : usuarios) {
            tabla.addCell(u.getNombre());
            tabla.addCell(u.getGenero());
            tabla.addCell(u.getLenguaje());
        }

        // Añadimos la tabla al documento y cerramos el documento
        doc.add(tabla);
        doc.close();
    }
}
