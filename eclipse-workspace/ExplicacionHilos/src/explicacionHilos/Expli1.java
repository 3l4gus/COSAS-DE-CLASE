package explicacionHilos;

public class Expli1 {
	public static void main(String[] args) {
		System.out.println("Inicio programa");
		System.out.println("Fin programa");
		
		// Guardamos en el hilo principal el hilo actual
		Thread hiloPrincipal = Thread.currentThread();
		
		System.out.println("El nombre del hilo es: " + hiloPrincipal.getName()
		+ "\nEl ID es: " + hiloPrincipal.getId());
	}
}
