import java.util.Scanner;

public class Ej7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nVentas = 0, suma = 0, venta = 0;

        System.out.println("Escribe un número de ventas:");
        nVentas = sc.nextInt();

        for (int i = 0; i < nVentas; i++) {
            System.out.println("Escribe una el precio de una venta:");
            venta = sc.nextInt();
            suma += venta;
        }

        System.out.println("Suma de ventas: " + suma);
    }
}
