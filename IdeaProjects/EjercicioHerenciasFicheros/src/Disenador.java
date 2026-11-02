public class Disenador extends Empleado{

    // Atributo
    private String herrDiseno;

    // Constructor
    public Disenador(int id, String nombre, double salario, String herrDiseno){
        super(id, nombre, salario);
        this.herrDiseno = herrDiseno;
    }

    // Getter y Setter
    public String getHerrDiseno() {
        return herrDiseno;
    }

    public void setHerrDiseno(String herrDiseno) {
        this.herrDiseno = herrDiseno;
    }

    @Override
    public String toString(){
        return "DISEÑADOR [ID = " + id
                + ", Nombre = " + nombre
                + ", Salario = " + salario
                + ", Herramienta de diseño = " + herrDiseno + "]";
    }
}
