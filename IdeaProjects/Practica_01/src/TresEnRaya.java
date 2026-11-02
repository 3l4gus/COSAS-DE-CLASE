import java.util.InputMismatchException;
import java.util.Scanner;

public class TresEnRaya {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Creamos la matriz de 3x3
        int[][] matriz = new int[3][3];

        // Variables
        int modo = 0, jugadorActual = 1, casillasMarcadas = 0;
        boolean finalizarPartida = false;

        // Preguntamos por el modo de juego
        do {
            try {
                System.out.println("---TRES EN RAYA---" +
                        "\nElige el modo de juego:" +
                        "\n1) Jugador vs Jugador." +
                        "\n2) Jugador vs IA");
                modo = sc.nextInt();

                if (modo < 1 || modo > 2) {
                    System.out.println("Debe de ser un número del 1 al 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe de ser un número entero.");
                sc.next();
            }
        } while (modo < 1 || modo > 2);

        // Mostramos la matriz vacía
        mostrarMatriz(matriz);

        // Dependiendo del modo se hará una cosa u otra
        switch (modo) {
            case 1:
                do {

                    // Ejecutamos el turno del jugador, sumamos el contador y mostramos la matriz resultada
                    System.out.println("\nTurno del jugador " + jugadorActual + ":");
                    turnoJugador(matriz, jugadorActual);
                    casillasMarcadas++;
                    mostrarMatriz(matriz);

                    // Si se cumple el método haGanado o está la matriz completa se acabará el juego,
                    // si no cambiará de jugador
                    if (haGanado(matriz, jugadorActual)) {
                        System.out.println("\n¡Ha ganado el jugador " + jugadorActual + "!");
                        finalizarPartida = true;
                    } else if (casillasMarcadas == 9) {
                        System.out.println("\nEs un empate.");
                        finalizarPartida = true;
                    } else {
                        if (jugadorActual == 1) {
                            jugadorActual = 2;
                        } else {
                            jugadorActual = 1;
                        }
                    }
                } while (!finalizarPartida);

                break;

            case 2:
                do {

                    // Ejecutamos el turno del jugador, sumamos el contador y mostramos la matriz resultada
                    System.out.println("\nTu turno: ");
                    turnoJugador(matriz, jugadorActual);
                    casillasMarcadas++;
                    mostrarMatriz(matriz);

                    // Si se cumple el método haGanado o está la matriz completa se acabará el juego
                    if (haGanado(matriz, jugadorActual)) {
                        System.out.println("\n¡Has ganado!");
                        finalizarPartida = true;
                    } else if (casillasMarcadas == 9) {
                        System.out.println("\nEs un empate.");
                        finalizarPartida = true;
                    }

                    // Si no se ha acabado la partida será el turno de la IA y se repetirá lo mismo que
                    // con el jugador
                    if (!finalizarPartida) {
                        System.out.println("\nTurno de la IA: ");
                        turnoIA(matriz);
                        casillasMarcadas++;
                        mostrarMatriz(matriz);

                        if (haGanado(matriz, 2)) {
                            System.out.println("¡\nHa ganado la IA!");
                            finalizarPartida = true;
                        } else if (casillasMarcadas == 9) {
                            System.out.println("\nEs un empate.");
                            finalizarPartida = true;
                        }
                    }
                } while (!finalizarPartida);

                break;
        }

        sc.close();
    }

    // Método para desarrollar el turno del jugador
    public static void turnoJugador(int[][] matriz, int jugadorActual) {
        boolean valido = false;
        do {

            // Comprobamos que las coordenadas que escribimos son válidas
            int x = 0;
            do {
                try {
                    System.out.println("Introduce la fila de la casilla que quieres comprobar:");
                    x = sc.nextInt();
                    if (x < 1 || x > 3) {
                        System.out.println("Debe de ser un número del 1 al 3");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debe de ser un número entero.");
                    sc.next();
                }
            } while (x < 1 || x > 3);

            int y = 0;
            do {
                try {
                    System.out.println("Introduce la columna de la casilla que quieres comprobar:");
                    y = sc.nextInt();
                    if (y < 1 || y > 3) {
                        System.out.println("Debe de ser un número del 1 al 3");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debe de ser un número entero.");
                    sc.next();
                }
            } while (y < 1 || y > 3);

            // Si la casilla no ha sido marcada anteriormente la marcamos según el jugador actual
            if (matriz[x - 1][y - 1] != 0) {
                System.out.println("La casilla ya ha sido marcada.");
            } else {
                matriz[x - 1][y - 1] = jugadorActual;
                valido = true;
            }
        } while (!valido);
    }

    // Método para desarrollar el turno de la IA
    public static void turnoIA(int[][] matriz) {
        int fila = 0, columna = 0;

        // Usando el random hacemos que la IA marque una casilla que esté vacía
        do {
            fila = (int) (Math.random() * 3);
            columna = (int) (Math.random() * 3);
        } while (matriz[fila][columna] != 0);

        matriz[fila][columna] = 2;
        System.out.println("La IA ha marcado la casilla [" + (fila + 1) + "][" + (columna + 1) + "].");
    }

    // Método para comprobar si el jugador ha ganado
    public static boolean haGanado(int[][] matriz, int jugadorActual) {

        // Recorremos la matriz
        for (int i = 0; i < matriz.length; i++) {

            // Comprobamos las filas, regresamos true si se cumple
            if (matriz[i][0] == jugadorActual
                    && matriz[i][1] == jugadorActual
                    && matriz[i][2] == jugadorActual) {
                return true;
            }

            // Comprobamos las columnas, regresamos true si se cumple
            if (matriz[0][i] == jugadorActual
                    && matriz[1][i] == jugadorActual
                    && matriz[2][i] == jugadorActual) {
                return true;
            }
        }

        // Comprobamos las diagonales, regresamos true si se cumple alguna de las dos
        return (matriz[0][0] == jugadorActual
                && matriz[1][1] == jugadorActual
                && matriz[2][2] == jugadorActual)
                || (matriz[0][2] == jugadorActual
                && matriz[1][1] == jugadorActual
                && matriz[2][0] == jugadorActual);
    }

    // Método para mostrar la matriz cuando se necesite
    public static void mostrarMatriz(int[][] matriz) {
        System.out.println();

        // For anidadas para mostrar la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
