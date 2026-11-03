package ejercicios;

import java.io.File;
import java.io.IOException;

public class Ejercicio7 {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Variables
		long inicio = 0;
		long tTotal = 0;
		int codigo = 0;

		// Creamos el fichero
		File fichero = new File("red.txt");

		// Creamos el proceso, indicamos que la salida se guarde en el fichero,
		// guardamos el tiempo actual y ejecutamos el proceso
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ipconfig");
		pb.redirectOutput(fichero);
		inicio = System.currentTimeMillis();
		Process p = pb.start();

		// Espera a que la ejecución del proceso termine por completo (devuelve 0 si
		// todo ok y 1 si no ok) y calculamos cuanto tiempo tarda en ms
		codigo = p.waitFor();
		tTotal = System.currentTimeMillis() - inicio;

		// Mostramos el código, el tiempo que ha tardado en ejecutarse y la ruta del
		// fichero
		System.out.println("El tiempo es de " + tTotal + " ms" + "\nEl código de ejecución es: " + codigo + "\n"
				+ fichero.getAbsolutePath());
	}
}
