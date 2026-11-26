package explicacionHilos2;

public class Tarea3 implements Runnable{

	private String nombre;
	private int repeticiones;
	
	// Contructor
	public Tarea3(String nombre, int repeticiones) {
		this.nombre = nombre;
		this.repeticiones = repeticiones;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	@Override
	public void run() {
		for(int i = 0; i < repeticiones; i++) {
			System.out.println(nombre + " trabajo: " + (i + 1));
		}
		System.out.println(nombre + " ha terminado");
	}
	
}
