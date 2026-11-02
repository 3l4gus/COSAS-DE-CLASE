public abstract class Empleado {

    // Atributos
    protected int id;
    protected String nombre;
    protected double salario;

    // Constructor
    public Empleado(int id, String nombre, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
    }

    // Getters
    public double getSalario() {
        return salario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract String toString();
}
