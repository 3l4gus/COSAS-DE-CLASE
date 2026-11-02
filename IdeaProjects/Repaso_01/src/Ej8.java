import java.util.Scanner;

public class Ej8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int menor = 100, menor2 = 101, random = 0, min = 0, max = 0;

        System.out.println("Escribe un valor mínimo:");
        min = sc.nextInt();
        System.out.println("Escribe un valor màximo:");
        max = sc.nextInt();

        for (int i = 0; i < 20; i++) {
            random = (int) (Math.random() * (max - min + 1)) + min;
            System.out.println(random);
            if(random < menor){
                menor2 = menor;
                menor = random;
            }else if(random < menor2 && random > menor){
                menor2 = random;
            }
        }

        System.out.println("El segundo menor es: " + menor2);

        sc.close();
    }
}
