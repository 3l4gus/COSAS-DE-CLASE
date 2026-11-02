import java.util.Scanner;
public class Ej1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = 0, cont = 0;

        System.out.println("Escribe un número:");
        num = sc.nextInt();

        if (num % 2 == 0) {
            cont++;
            System.out.println("El número es par.");
        }
        if(num % 7 == 0){
            cont++;
            System.out.println("El número es múltiplo de 7.");
        }

        System.out.println("Se cumple/n un total de " + cont + " condicion/es.");

        sc.close();
    }
}