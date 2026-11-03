package explicacion2;

import java.io.BufferedReader;	
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Explicacion2_2 {
	public static void main(String[] args) throws IOException {
// PASO 1: creamos el proceceso

		ProcessBuilder proceso = new ProcessBuilder("cmd", "/c", "ipconfig");
// PASO 2: lanzamos el proceso con start y lo guardamos en una objeto
//process

		Process p = proceso.start();

// PASO 3: guardamos la salida en un InputStream
		InputStream salida = p.getInputStream();
// PASO 4: lo convertimos de bytes a caracteres

		InputStreamReader conversor = new InputStreamReader(salida);
// PASO 5: lo metemos en un buffer para nos mostrar caracter a cracter sino
//linea a linea

		BufferedReader buffer = new BufferedReader(conversor);

// PASO 6: leemos TODAS LAS LINEAS

		String linea = "";
		System.out.println("liena 1");

//

		while (linea != null) {
			System.out.println(linea);

// avanzamos

			linea = buffer.readLine();

// }
		}
	}
}