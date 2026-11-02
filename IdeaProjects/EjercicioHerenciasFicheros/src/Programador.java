public class Programador extends Empleado{

    // Atributo
    private String lengPrincipal;

    // Constructor
    public Programador(int id, String nombre, double salario, String lengPrincipal){
        super(id, nombre, salario);
        this.lengPrincipal = lengPrincipal;
    }

    // Getter y Setter
    public String getLengPrincipal() {
        return lengPrincipal;
    }

    public void setLengPrincipal(String lengPrincipal) {
        this.lengPrincipal = lengPrincipal;
    }

    @Override
    public String toString(){
        return "PROGRAMADOR [ID = " + id
                + ", Nombre = " + nombre
                + ", Salario = " + salario
                + ", Lenguaje principal = " + lengPrincipal + "]";
    }
}
