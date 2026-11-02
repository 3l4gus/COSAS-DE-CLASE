import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cadenaA = "", cadenaB = "";
        int cont = 0;

        do{
            System.out.println("Escribe la primera cadena de caracteres:");
            cadenaA = sc.nextLine().toLowerCase();
            if(cadenaA.charAt(cadenaA.length()-1) != '#'){
                System.out.println("La cadena debe de acabar con #");
            }
        }while(!cadenaA.endsWith("#")
                || cadenaA.length() > 80);

        do{
            System.out.println("Escribe la segunda cadena de caracteres:");
            cadenaB = sc.nextLine().toLowerCase();
            if(cadenaB.charAt(cadenaB.length()-1) != '#'){
                System.out.println("La cadena debe de acabar con #");
            }
        }while(cadenaB.charAt(cadenaB.length()-1) != '#'
                || cadenaA.length() > 25);

        System.out.println("\nCadena 1: " + cadenaA +
                "\nCadena 2: " + cadenaB);

        for (int i = 0; i < cadenaB.length(); i++) {
            for (int j = 0; j < cadenaA.length(); j++) {
                if(cadenaA.charAt(j) == cadenaB.charAt(i)){
                    cont++;
                }
            }
            if(cadenaB.charAt(i) != '#') {
                System.out.println(cadenaB.charAt(i) + ": " + cont);
                cont = 0;
            }
        }

    }
}