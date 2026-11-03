package explicacion4;

import java.io.IOException;

public class Explicacion2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// Variables
		long inicio = 0;
		long tTotal = 0;
		int codigo = 0;
		
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ping 8.8.8.8");
		
		//Indicamos que la comunicación con la consola sea directa, hay que hacerlo antes del start()
		pb.inheritIO();
		
		inicio = System.currentTimeMillis();
		
		Process p = pb.start();
		
		//Espera a que la ejecución del proceso termine por completo y devuelve 0 si todo ok y 1 si no ok
		codigo = p.waitFor();
		
		tTotal = System.currentTimeMillis() - inicio;
		
		System.out.println("El tiempo es de " + tTotal + " ms" +
		"\nEl código de ejecución es: " + codigo);
	}
}
