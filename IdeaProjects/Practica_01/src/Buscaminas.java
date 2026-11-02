import java.util.InputMismatchException;
import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        // Creamos las matrices 10x10
        int[][] mMinas = new int[10][10];
        int[][] mUsuario = new int[10][10];

        // Variables para la dificultad, coordenadas y booleano para acabar la partida
        int dif = 0, x = 0, y = 0, cont1 = 0, cont2 = 0;
        boolean finalizarPartida = false;

        // Preguntamos la dificultad
        do {
            try {
                System.out.println("---BUSCAMINAS---" +
                        "\n¿En qué dificultad te gustaría jugar?" +
                        "\n1) Fácil (15% de que una casilla sea una mina) - necesitas encontrar 15 minas." +
                        "\n2) Medio (25% de que una casilla sea una mina) - necesitas encontrar 10 minas." +
                        "\n3) Difícil (50% de que una casilla sea una mina) - necesitas encontrar 5 minas.");
                dif = sc.nextInt();
                if(dif < 1 || dif > 3){
                    System.out.println("Debe de ser un número del 1 al 3");
                }
            }catch (InputMismatchException e){
                System.out.println("Debe de ser un número entero.");
                sc.next();
            }
        }while(dif < 1 || dif > 3);

        // For anidadas para rellenar la matriz de minas dependiendo de la dificultad elegida
        // y la mostramos durante 3 segundos
        System.out.println("Mostrando la matriz durante 3 segundos...");
        for (int i = 0; i < mMinas.length; i++) {
            for (int j = 0; j < mMinas.length; j++) {
                switch (dif) {
                    case 1:
                        cont1 = 15;
                        if (Math.random() < 0.15) {
                            mMinas[i][j] = 1;
                        } else {
                            mMinas[i][j] = 0;
                        }
                        break;
                    case 2:
                        cont1 = 10;
                        if (Math.random() < 0.25) {
                            mMinas[i][j] = 1;
                        } else {
                            mMinas[i][j] = 0;
                        }
                        break;
                    case 3:
                        cont1 = 5;
                        if (Math.random() < 0.5) {
                            mMinas[i][j] = 1;
                        } else {
                            mMinas[i][j] = 0;
                        }
                        break;
                }
                System.out.print(mMinas[i][j] + "  ");
            }
            System.out.println();
        }
        Thread.sleep(3000);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        // Mientras no se encuentre una bomba se seguirá jugando
        do {
            System.out.println();

            // Comprobamos que las coordenadas que escribimos son válidas
            x = 0;
            do {
                try {
                    System.out.println("Introduce la fila de la casilla que quieres comprobar:");
                    x = sc.nextInt();

                    if(x < 1 || x > 10){
                        System.out.println("Debe de ser un número del 1 al 10");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debe de ser un número entero.");
                    sc.next();
                }
            }while(x < 1 || x > 10);

            y = 0;
            do {
                try {
                    System.out.println("Introduce la columna de la casilla que quieres comprobar:");
                    y = sc.nextInt();

                    if(y < 1 || y > 10){
                        System.out.println("Debe de ser un número del 1 al 10");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debe de ser un número entero.");
                    sc.next();
                }
            }while(y < 1 || y > 10);

            // Si la casilla que elegimos ya la habíamos elegido antes nos hará escoger otra
            if(mUsuario[x - 1][y - 1] == 2){
                System.out.println("Esta casilla ya la habías descubierto.");
                continue;
            }

            // Si la casilla que escogemos tiene una bomba en la primera matriz,
            // se acabará la partida. Si no, se seguirá hasta que se alcance la meta de
            // casillas descubiertas.
            if (mMinas[x - 1][y - 1] != 1) {
                mUsuario[x - 1][y - 1] = 2;
                System.out.println("No hay bomba.\n");
                cont2++;

                if(cont1 == cont2){
                    System.out.println("¡Enhorabuena, has ganado!");
                    finalizarPartida = true;
                }
            } else {
                mUsuario[x - 1][y - 1] = 3;
                System.out.println("Hay una bomba. Has perdido.\n");
                finalizarPartida = true;
            }

            // Mostramos la matriz del usuario
            for (int i = 0; i < mUsuario.length; i++) {
                for (int j = 0; j < mUsuario.length; j++) {
                    System.out.print(mUsuario[i][j] + "  ");
                }
                System.out.println();
            }
        }while(!finalizarPartida);

        sc.close();
    }
}
