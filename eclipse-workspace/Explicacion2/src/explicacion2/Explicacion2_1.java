package explicacion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Explicacion2_1 {
	public static void main(String[] args) throws IOException {
// ProcessBuilder proceso = new ProcessBuilder("calc");
// proceso.start();
// COMENTAMOS, ESTO ES LO QUE HACÍAMOS HASTA AHORA, PERO ¿Y SI QUIERO
//LLAMAR AL CMD
// PARA LEER EL NOMBERE DEL EQUIPO POR EJEMPLO
// /c ejecuta el comando y cierra la consola
		ProcessBuilder proceso = new ProcessBuilder("cmd", "/c", "hostname");
		Process p = proceso.start();
// se ejecuta pero hace nada porque en este caso nos interesa y comando
// específico y tendríamos que capturar la salida
		InputStream salidaProceso = p.getInputStream();
		System.out.println(salidaProceso);

// EJECUTAMOS, lo que devuelve es java.io... esto es el objeto, no el contenido
		System.out.println(salidaProceso.read());
// Esto devuelve un número, tampoco nos vale porque lee el priemr caracter del
// resultado solo en bytes
		InputStreamReader conversor = new InputStreamReader(salidaProceso);
		System.out.println(conversor);
// ahora devuelve otro java.io vamos a hacer el read para ver el caracter
		System.out.println((char) conversor.read());
		System.out.println((char) conversor.read());
		System.out.println((char) conversor.read());
// Ahora hacemos que salga todo bien, haciedo un buffer para leer linea por
// linea
		BufferedReader lector = new BufferedReader(conversor);
		String linea = lector.readLine();
		System.out.println(linea);
	}
}