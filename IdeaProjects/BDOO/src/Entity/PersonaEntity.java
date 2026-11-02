package Entity;

public class PersonaEntity {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;

    public PersonaEntity(String nombre, String apellido, int edad) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public PersonaEntity() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "ID -> " + id + " nombre -> " + nombre  + " apellido -> " + apellido
                + " edad -> " + edad ;
    }
}
