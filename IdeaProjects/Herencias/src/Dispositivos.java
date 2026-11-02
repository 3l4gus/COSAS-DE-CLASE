public class Dispositivos {

    //Atributos
    private String marca;
    private double precio;

    //Constructor vacío
    public Dispositivos(){

    }

    //Constructor con datos
    public Dispositivos(String marca, double precio){
        this.marca = marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void imprimirMensaje(){
        if(precio > 20){
            System.out.println("Caro");
        }else {
            System.out.println("Barato");
        }
    }

    //No es static porque no tiene ningún atributo de la clase
    public void imprimirNombre(String nombre){
        System.out.println("El dispositivo se llama " + nombre);
    }
}