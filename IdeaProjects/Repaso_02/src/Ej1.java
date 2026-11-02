import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {

        // Realiza un programa que pida una cadena de caracteres y diga cuantas vocales hay
        Scanner sc = new Scanner(System.in);

        int cont = 0;
        String s = "", s2 = "";

        System.out.println("Escribe una cadena de caracteres:");
        s = sc.nextLine();
        s2 = s.toLowerCase();

        for (int i = 0; i < s2.length(); i++) {
            if(s2.charAt(i) == 'a'
                    || s2.charAt(i) == 'e'
                    || s2.charAt(i) == 'i'
                    || s2.charAt(i) == 'o'
                    || s2.charAt(i) == 'u'){
                cont++;
            }
        }

        System.out.println(s2);
        System.out.println("Hay un total de " + cont + " vocales.");
    }
}
