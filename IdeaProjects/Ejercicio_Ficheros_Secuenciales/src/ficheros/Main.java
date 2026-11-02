package ficheros;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Scanner global
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        String ruta = "src/ficheros/diario.txt";

        // Hacemos el menú asegurándonos que escojamos una opción existente y un switch
        // para escoger una de las opciones, se repetirá hasta que elijamos la opción "salir".
        do {
            System.out.println("---MENÚ DIARIO PERSONAL---" +
                    "\n1. Añadir notas al diario" +
                    "\n2. Leer el diario completo" +
                    "\n3. Leer hasta que líneas se quiere leer" +
                    "\n4. Leer desde que líneas se quiere leer" +
                    "\n5. Leer rango de líneas (desde / hasta)" +
                    "\n6. Salir" +
                    "\nElige una opción:");

            do {
                try {
                    opcion = sc.nextInt();
                    sc.nextLine();

                    if(opcion < 1 || opcion > 6) {
                        System.out.println("El límite debe de estar entre 1 y 6.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes escribir un número.");
                    sc.nextLine();
                }
            }while(opcion < 1 || opcion > 6);

            switch (opcion) {
                case 1:
                    escribirFichero(ruta);
                    break;
                case 2:
                    leerFicheroCompleto(ruta);
                    break;
                case 3:
                    leerFicheroHasta(ruta);
                    break;
                case 4:
                    leerFicheroDesde(ruta);
                    break;
                case 5:
                    leerFicheroDesdeHasta(ruta);
                    break;
                case 6:
                    System.out.println("Fin del programa.");
                    break;
            }
        } while (opcion != 6);
    }

    // Método para contar el número de líneas que hay escritas en el fichero, se detendrá
    // cuando haya una línea == null. Se utilizará dentro de otros métodos.
    private static int contadorLineas(String ruta) {
        int cont = 0;

        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";

            do {
                linea = br.readLine();

                if (linea != null) {
                    cont++;
                }
            } while (linea != null);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return cont;
    }

    // Método para imprimir por consola las líneas del fichero, se detendrá cuando haya una línea == null.
    private static void leerFicheroCompleto(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";

            do {
                linea = br.readLine();

                if (linea != null) {
                    System.out.println(linea);
                }
            } while (linea != null);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para imprimir por consola las líneas del fichero hasta un límite superior que
    // determine el usuario, asegurándonos de que el límite escrito sea válido.
    private static void leerFicheroHasta(String ruta) {
        int numLineas = contadorLineas(ruta), limiteSup = 0;
        System.out.println("Escribe hasta qué línea quieres leer (1 - " + numLineas + ").");

        do{
            try {
                limiteSup = sc.nextInt();

                if(limiteSup < 1 || limiteSup > numLineas){
                    System.out.println("El límite debe de estar entre 1 y " + numLineas + ".");
                }
            }catch (InputMismatchException e){
                System.out.println("Debes escribir un número.");
                sc.nextLine();
            }
        }while(limiteSup < 1 || limiteSup > numLineas);

        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";

            for (int i = 1; i <= limiteSup; i++) {
                linea = br.readLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para imprimir por consola las líneas del fichero desde un límite inferior que
    // determine el usuario, asegurándonos de que el límite escrito sea válido.
    private static void leerFicheroDesde(String ruta) {
        int numLineas = contadorLineas(ruta), limiteInf = 0;
        System.out.println("Escribe desde qué línea quieres leer (1 - " + numLineas + ").");

        do{
            try {
                limiteInf = sc.nextInt();

                if(limiteInf < 1 || limiteInf > numLineas){
                    System.out.println("El límite debe de estar entre 1 y " + numLineas + ".");
                }
            }catch (InputMismatchException e){
                System.out.println("Debes escribir un número.");
                sc.nextLine();
            }
        }while(limiteInf < 1 || limiteInf > numLineas);

        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";

            for (int i = 1; i <= numLineas; i++) {
                if(limiteInf > 1){
                    limiteInf--;
                    br.readLine();
                }else {
                    linea = br.readLine();
                    System.out.println(linea);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para imprimir por consola las líneas del fichero desde un límite inferior y hasta
    // un límite superior que determine el usuario, asegurándonos de que los límites escritos sean válidos.
    private static void leerFicheroDesdeHasta(String ruta) {
        int numLineas = contadorLineas(ruta), limiteInf = 0, limiteSup = 0;
        System.out.println("Escribe desde qué línea quieres leer (1 - " + numLineas + ").");

        do{
            try {
                limiteInf = sc.nextInt();

                if(limiteInf < 1 || limiteInf > numLineas){
                    System.out.println("El límite debe de estar entre 1 y " + numLineas + ".");
                }
            }catch (InputMismatchException e){
                System.out.println("Debes escribir un número.");
                sc.nextLine();
            }
        }while(limiteInf < 1 || limiteInf > numLineas);

        System.out.println("Escribe hasta qué línea quieres leer (1 - " + numLineas + ").");

        do{
            try {
                limiteSup = sc.nextInt();

                if(limiteSup < limiteInf || limiteSup > numLineas){
                    System.out.println("El límite debe de estar entre " + limiteInf + " y " + numLineas + ".");
                }
            }catch (InputMismatchException e){
                System.out.println("Debes escribir un número.");
                sc.nextLine();
            }
        }while(limiteSup < limiteInf || limiteSup > numLineas);

        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";

            for (int i = 1; i <= limiteSup; i++) {
                if(limiteInf > 1){
                    limiteInf--;
                    br.readLine();
                }else {
                    linea = br.readLine();
                    System.out.println(linea);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para escribir líneas en el fichero hasta escribir la palabra "fin".
    private static void escribirFichero(String ruta) {
        String frase = "";

        try {
            FileWriter fw = new FileWriter(ruta, true);
            BufferedWriter bw = new BufferedWriter(fw);

            do {
                System.out.println("Introduce una frase:");
                frase = sc.nextLine();

                if (!frase.equalsIgnoreCase("fin")) {
                    bw.write(frase + "\n");
                }
            } while (!frase.equalsIgnoreCase("fin"));
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("No se encuentra la ruta.");
        }
    }
}