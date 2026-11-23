package Ejercicios;

import java.io.File;
import java.io.IOException;

public class Ejercicio4 {
	public static void main(String[] args) throws IOException {
		File fichero = new File("salida.txt");
		
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "hostname");
		
		pb.redirectErrorStream(true);
		pb.redirectOutput(fichero);
		
		Process p = pb.start();
		
		System.out.println("Ruta del archivo: " + fichero.getAbsolutePath());
	}
}
