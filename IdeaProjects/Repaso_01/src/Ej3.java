import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Variables
        double n1 = 0, n2 = 0;
        String op = "";

        // Pedimos datos
        System.out.println("Introduce el primer número:");
        n1 = sc.nextDouble();
        System.out.println("Introduce el segundo número:");
        n2 = sc.nextDouble();
        sc.nextLine();

        //Pedimos el tipo de operación que queremos hacer
        System.out.println("¿Qué tipo de operación quieres hacer? (+,-,*,/)");
        op = sc.nextLine();

        //Hará una operación dependiendo del String que escribas
        switch (op) {

            case "+":
                System.out.println("El resultado es " + (n1 + n2) + ".");
                break;
            case "-":
                System.out.println("El resultado es " + (n1 - n2) + ".");
                break;
            case "*":
                System.out.println("El resultado es " + (n1 * n2) + ".");
                break;
            case "/":
                System.out.println("El resultado es " + (n1 / n2) + ".");
                break;
            default:
                break;
        }
        sc.close();

    }
}
