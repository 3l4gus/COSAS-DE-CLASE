package explicacion4;

import java.io.File;
import java.io.IOException;

public class Explicacion3 {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ping 8.8.8.8");
		
		pb.redirectErrorStream(true);
		
		File fichero = new File("salida.txt");
		
		//Indicamos que la salida se guarde en el fichero
		pb.redirectOutput(fichero);
		
		Process p = pb.start();
		
		p.waitFor();
		
		System.out.println(fichero.getAbsolutePath());
	}
}
