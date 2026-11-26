package juegos;

import java.util.Scanner;

public class Circuito {
	public static void jugar() throws InterruptedException {
		Scanner sc = new Scanner(System.in);

		// Escribimos por consola el nombre de los coches que vamos a crear
		System.out.println("---OPERACIÓN MAZMORRA---" + "\nEscribe el nombre del coche rojo: ");
		Vehiculo rojo = new Vehiculo(sc.nextLine());
		System.out.println("Escribe el nombre del coche azul: ");
		Vehiculo azul = new Vehiculo(sc.nextLine());
		System.out.println("Escribe el nombre del coche verde: ");
		Vehiculo verde = new Vehiculo(sc.nextLine());

		System.out.println("\n¡COMIENZA LA CARRERA!");

		// Ejecutamos el método para crear los hilos y los guardamos en un Thread para poder controlarlos individualmente.
		// En este caso ejecutaremos uno y esperaremos a que acabe para ejecutar el siguiente
		Thread hiloRojo = empezarHilo(rojo, "Coche rojo");
		hiloRojo.join();
		System.out.println("\n¡RELEVO! Ahora sale " + azul.getNombre());
		Thread hiloAzul = empezarHilo(azul, "Coche azul");
		hiloAzul.join();
		System.out.println("\n¡RELEVO! Ahora sale " + verde.getNombre());
		Thread hiloVerde = empezarHilo(verde, "Coche verde");
		hiloVerde.join();

		// Una vez se han acabado de ejecutar los 3 se mostrará la siguiente información
		System.out.println("\n---RESULTADOS---" + "\n" + rojo.getNombre() + ": " + rojo.getTiempo() + " segundos" + "\n"
				+ azul.getNombre() + ": " + azul.getTiempo() + " segundos" + "\n" + verde.getNombre() + ": "
				+ verde.getTiempo() + " segundos" + "\n-------------" + "\nTIEMPO TOTAL DEL EQUIPO: "
				+ (rojo.getTiempo() + azul.getTiempo() + verde.getTiempo()) + " segundos");
		
		// Creamos un nuevo objeto Vehiculo para ir guardando el que menos tiempo haya hecho para mostrarlo al final
		Vehiculo masRapido = rojo;
		
		if (azul.getTiempo() < masRapido.getTiempo()) {
			masRapido = azul;
		}
		
		if (verde.getTiempo() <  masRapido.getTiempo()) {
			masRapido = verde;
		}
		System.out.println("\n¡EL COCHE MÁS RÁPIDO HA SIDO " + masRapido.getNombre() + "!" + 
		"\n¡VAYA LENTORROS! ¡NECESITÁIS MÁS ENTRENAMIENTO!\n");
		sc.close();
	}

	// Método para crear hilos, devolverá el hilo
	public static Thread empezarHilo(Vehiculo color, String nombre) {

		// Creamos el hilo pasandole la tarea y el nombre y lo ejecutamos
		Thread hilo = new Thread(color, nombre);
		hilo.start();

		return hilo;
	}
}
