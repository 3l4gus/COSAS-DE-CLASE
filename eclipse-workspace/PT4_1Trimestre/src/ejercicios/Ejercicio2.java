package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Variables
		long inicio = 0;
		long tTotal = 0;
		int codigo = 0;
		String linea = "";

		// Creamos el proceso
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ver");
		
		// Indicamos que la comunicación con la consola sea directa, guardamos el tiempo actual
		// y ejecutamos el proceso
		pb.inheritIO();
		inicio = System.currentTimeMillis();
		Process p = pb.start();

		// Espera a que la ejecución del proceso termine por completo (devuelve 0 si
		// todo ok y 1 si no ok) y calculamos cuanto tiempo tarda en ms
		codigo = p.waitFor();
		tTotal = System.currentTimeMillis() - inicio;

		// Creamos un BufferedReader que leerá los caracteres (antes bytes) que fueron
		// convertidos por el InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

		// Vamos leyendo todas las líneas y mostrandolas		
		do {
			linea = br.readLine();
			if (linea != null) {
				System.out.println(linea);
			}
		} while (linea != null);

		// Mostramos el código y el tiempo que ha tardado en ejecutarse
		System.out.println("El tiempo es de " + tTotal + " ms" + "\nEl código de ejecución es: " + codigo);

		br.close();
	}
}
