import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] array = new double[5];
        double media = 0;

        System.out.println("Introduce 5 números:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Número " + (i + 1) + ":");
            array[i] = sc.nextDouble();
            media += array[i];
        }

        media = media/5;

        for (int i = 0; i < 5; i++) {
            if (array[i] > media) {
                System.out.println(array[i] + " es mayor que la media.");
            }
        }

        sc.close();
    }
}
