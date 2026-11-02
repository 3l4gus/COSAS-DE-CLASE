import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String frase = "";
        boolean esPerfecta = true;
        char p1 = ' ', p2 = ' ', f1 = ' ', f2 = ' ';

        System.out.println("Escribe un cadena de caracteres:");
        frase = sc.nextLine();

        String[] array = frase.trim().toLowerCase().split("\\s+");

        for (int i = 0; i < array.length; i++) {
            String palabra = array[i];
            p1 = palabra.charAt(0);
            f1 = palabra.charAt(palabra.length()-1);

            if (i != 0){
                if(p1 != p2 || f1 != f2) {
                    esPerfecta = false;
                    break;
                }
            }
            p2 = p1;
            f2 = f1;
        }

        if(esPerfecta){
            System.out.println("La frase es perfecta.");
        }else{
            System.out.println("La frase no es perfecta.");
        }
    }
}
