package ejercicios;

import java.io.IOException;

public class Ejercicio3 {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Variables
		long inicio = 0;
		long tTotal = 0;
		int codigo = 0;
		String linea = "";

		// Creamos el proceso
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "type", "nombreFichero.txt");

		// Juntamos el flujo de salida y de errores, indicamos que la comunicación con
		// la consola sea directa, guardamos el tiempo actual y ejecutamos el proceso
		// (mostrará que no existe el archivo)
		pb.redirectErrorStream(true);
		pb.inheritIO();
		inicio = System.currentTimeMillis();
		Process p = pb.start();

		// Espera a que la ejecución del proceso termine por completo (devuelve 0 si
		// todo ok y 1 si no ok) y calculamos cuanto tiempo tarda en ms
		codigo = p.waitFor();
		tTotal = System.currentTimeMillis() - inicio;

		// Mostramos el código y el tiempo que ha tardado en ejecutarse
		System.out.println("El tiempo es de " + tTotal + " ms" + "\nEl código de ejecución es: " + codigo);
	}
}
