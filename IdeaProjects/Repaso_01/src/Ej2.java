import java.util.Scanner;
public class Ej2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int ano = 0, altura = 0, peso = 0, velocidad = 0, cont = 0, ultimo = 0, resultado = 0;

        //Pedimos y recogemos datos
        System.out.println("Introduce tu año de nacimiento:");
        ano = sc.nextInt();
        ultimo = ano % 10;

        System.out.println("Introduce tu altura (cm):");
        altura = sc.nextInt();

        System.out.println("Introduce tu peso (kg):");
        peso = sc.nextInt();
        resultado = altura/peso;

        System.out.println("Introduce la velocidad de tu escoba (km/h):");
        velocidad = sc.nextInt();

        //Comprobamos cada condicion
        if (ultimo == 4 || ultimo == 5 || ultimo == 7) {
            cont++;
            System.out.println("Tu año de nacimiento acaba en 4, 5 o 7.");
        }

        if (resultado > 1 && resultado < 6) {
            cont++;
            System.out.println("Tu relación de altura/peso está entre 2 y 5.");
        }

        if (velocidad > 100 && velocidad % 11 == 0) {
            cont++;
            System.out.println("La velocidad de tu escoba supera los 100 km/h y es múltiplo de 11.");
        }

        //Mostramos el numero de condiciones que cumple
        System.out.println("Se cumple/n un total de " + cont + " condicion/es.");

        sc.close();

    }
}
