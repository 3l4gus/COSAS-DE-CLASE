package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio5 {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Variables
		long inicio = 0;
		long tTotal = 0;
		int codigo = 0, contComandos = 0, contCorrectos = 0;
		String linea = "";
		
		// Creamos el ArrayList con los comandos
		ArrayList<String> comandos = new ArrayList<>(Arrays.asList("type fichero.txt", "whoami", "ver", "getmac"));

		// Recorremos el ArrayList de comandos
		for (String comando : comandos) {
			
			// Creamos el proceso
			System.out.println("----------------------------------" + 
			"\nComando: " + comando + 
					"\n----------------------------------");
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", comando);

			// Indicamos que la comunicación con la consola sea directa, guardamos el tiempo
			// actual y ejecutamos el proceso
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
			contComandos++;

			if (codigo == 0) {
				contCorrectos++;
			}
			br.close();
		}

		System.out.println("\n==== INFORME FINAL ====" + "\nTotal de comandos: " + contComandos + "\nCorrectos: "
				+ contCorrectos + "\nCon errores: " + (contComandos - contCorrectos));
	}
}
