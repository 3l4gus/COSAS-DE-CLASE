package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio8 {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Variables
		long inicio = 0;
		long tTotal = 0;
		int codigo = 0, contLineas = 0, contPares = 0;
		String linea = "";

		// Creamos el fichero
		File fichero = new File("procesos.txt");

		// Creamos el proceso
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "tasklist");

		// Guardamos el tiempo actual y ejecutamos el proceso
		inicio = System.currentTimeMillis();
		Process p = pb.start();

		// Creamos un BufferedReader que leerá los caracteres (antes bytes) que fueron
		// convertidos por el InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

		// Abrimos el fichero para escribir en él
		BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, false));

		// Vamos leyendo y contando todas las líneas
		do {
			linea = br.readLine();
			if (linea != null) {
				contLineas++;
			}

			// Guardamos las líneas pares y sumamos el contador
			if (contLineas % 2 == 0) {
				bw.write(linea);
				bw.newLine();
				contPares++;
			}
		} while (linea != null);

		// Espera a que la ejecución del proceso termine por completo (devuelve 0 si
		// todo ok y 1 si no ok) y calculamos cuanto tiempo tarda en ms
		codigo = p.waitFor();
		tTotal = System.currentTimeMillis() - inicio;

		// Mostramos el número de líneas totales y pares, el código, el tiempo que ha
		// tardado en ejecutarse y la ruta del fichero
		System.out.println("Total de líneas leídas: " + contLineas + "\nLíneas pares guardadas: " + contPares
				+ "\nEl tiempo es de " + tTotal + " ms" + "\nEl código de ejecución es: " + codigo + "\n"
				+ fichero.getAbsolutePath());

		bw.close();
		br.close();
	}
}
