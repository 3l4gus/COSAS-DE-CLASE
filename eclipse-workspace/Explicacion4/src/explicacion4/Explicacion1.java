package explicacion4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Explicacion1 {
	public static void main(String[] args) throws IOException {
		
		//Variables
		long inicio = 0;
		long tTotal = 0;
		String linea = "";
		
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ping 8.8.8.8 && laura");
		
		//Nos da el tiempo actual en milisegundos
		inicio = System.currentTimeMillis();
		
		//Salida normal y salida de errores van juntas
		pb.redirectErrorStream(true);
		Process p = pb.start();
		
		InputStream salida = p.getInputStream();
		
		InputStreamReader conversor = new InputStreamReader(salida);
		
		BufferedReader br = new BufferedReader(conversor);
		
		linea = br.readLine();
		
		while(linea != null) {
			System.out.println(linea);
			linea = br.readLine();
		}
		
		System.out.println("---SALIDA FLUJO ERRORES---");
		
		InputStream salidaErrores = p.getErrorStream();
		
		InputStreamReader conversorErrores = new InputStreamReader(salidaErrores);
		
		BufferedReader brErrores = new BufferedReader(conversorErrores);
		
		linea = brErrores.readLine();
		while(linea != null) {
			System.out.println(linea);
			linea = brErrores.readLine();
		}
		
		tTotal = System.currentTimeMillis() - inicio;
		System.out.println("---TIEMPO DE EJECUCIÓN---" + 
		"\nEl tiempo de ejecución es de " + tTotal + " ms");
	}
}
