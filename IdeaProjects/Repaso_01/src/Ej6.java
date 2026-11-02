import java.util.Scanner;

public class Ej6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 0, suma = 0;

        System.out.println("Escribe un número:");
        n = sc.nextInt();

        for (int i = 1; i < n; i++) {
            suma += i;
        }

        System.out.println("Suma: " + suma);

        sc.close();
    }
}
