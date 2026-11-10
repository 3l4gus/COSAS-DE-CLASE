package com.example.correcciones;





import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerarPDF {

    public static void generarPDF(String n, int e, String c) throws IOException {

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
