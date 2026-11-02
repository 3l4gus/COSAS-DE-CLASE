import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Variables
        double n1 = 0;
        final double CONSTANTE = 0.3;

        //Pedimos un número
        System.out.println("Escribe un nùmero:");
        n1 = sc.nextDouble();

        //Mostrará una cosa u otra dependiendo de si cumple las condiciones
        if((n1 * CONSTANTE) >= 4.5 && (n1 * CONSTANTE) <= 7.2){
            System.out.println("El resultado está comprendido entre 4.5 y 7.2.");
        }else{
            System.out.println("El resultado NO está comprendido entre 4.5 y 7.2.");

        }

        sc.close();
    }
}
