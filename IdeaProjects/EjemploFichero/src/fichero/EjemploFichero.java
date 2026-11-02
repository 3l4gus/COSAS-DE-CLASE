package fichero;

import java.io.*;
import java.util.Scanner;

public class EjemploFichero {



    public static void main(String[] args) {

        String ruta = "src/fichero/datos.txt";

//        escribirFichero(ruta);
        leerFichero(ruta);


    }

    private static void leerFichero(String ruta) {

        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";

            do{

                linea = br.readLine();
                if(linea != null){
                    System.out.println(linea);
                }

            }while(linea != null);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void escribirFichero(String ruta) {

        Scanner teclado = new Scanner(System.in);
        String frase = "";

        try {
            FileWriter fw = new FileWriter(ruta, true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 1; i <= 3; i++) {

                System.out.println("Introduce frase " + i);
                frase = teclado.nextLine();

                bw.write(frase + "\n");
//                bw.newLine();
            }

            bw.close();
            fw.close();

            System.out.println("Fin fichero");


        } catch (IOException e) {
            System.out.println("No se encuentra la ruta");
        }
    }


}