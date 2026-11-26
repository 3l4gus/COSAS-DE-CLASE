package juegos;

import java.util.Scanner;

public class Mazmorra {
	public static void jugar() throws InterruptedException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Escribe el nombre del guerrero: ");
		Personaje guerrero = new Personaje(sc.nextLine(), "Guerrero");
		System.out.println("Escribe el nombre del mago: ");
		Personaje mago = new Personaje(sc.nextLine(), "Mago");

		Thread hiloGuerrero = empezarHilo(guerrero, "Hilo-Guerrero");
		Thread hiloMago = empezarHilo(mago, "Hilo-Mago");
		
		hiloGuerrero.join();
		hiloMago.join();
	}

	// Método para crear hilos
	public static Thread empezarHilo(Personaje personaje, String nombre) {

		// Creamos el hilo pasandole la tarea y el nombre y lo ejecutamos
		Thread hilo = new Thread(personaje, nombre);
		hilo.start();
		
		return hilo;
	}
}
