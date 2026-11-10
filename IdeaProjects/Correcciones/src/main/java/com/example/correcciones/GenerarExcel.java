package com.example.correcciones;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerarExcel {


    public static void generarExcel(String n, int e, String c) throws IOException {

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
