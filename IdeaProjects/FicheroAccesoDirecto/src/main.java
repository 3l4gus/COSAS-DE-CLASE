import java.io.*;
import java.util.Scanner;

public class main {

    static Scanner teclado = new Scanner(System.in);
    static String ruta = "src/fichero/personas.dat";
    public static void main(String[] args) throws IOException {

        var op = 0;

        do{
            System.out.println("Elige una opcion");
            System.out.println("1-Alta persona");
            System.out.println("2-Listado persona");
            System.out.println("3-Consulta persona");
            System.out.println("4-Salir");
            op = teclado.nextInt();

            switch (op){
                case 1:
                    altaPersona();
                    break;
                case 2:
                    listadoPersona();
                    break;
                case 3:
                    consultaPersona();
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;

            }

        }while(op != 4);

    }

    private static void consultaPersona() throws IOException {

        String nombre = "";
        boolean existe = false;

        System.out.println("Introduce nombre");
        nombre = teclado.next();

        FileInputStream fis = new FileInputStream(ruta);
        DataInputStream dis = new DataInputStream(fis);

        //debemos leer en el mismo orden que escribimos
        while(true){

            String n = "";
            int ed = 0;
            char s = ' ';

            try {
                n = dis.readUTF();
                ed = dis.readInt();
                s = dis.readChar();

                if(n.equalsIgnoreCase(nombre)){
                    System.out.print(n + " " + ed + " " + s);
                    existe = true;
                }
            } catch (IOException e) {
                break;
            }

            dis.close();
            fis.close();
        }

        if(!existe){
            System.out.println("No existe la persona");
        }
    }

    private static void listadoPersona() throws IOException {

        FileInputStream fis = new FileInputStream(ruta);
        DataInputStream dis = new DataInputStream(fis);

        //debemos leer en el mismo orden que escribimos
        while(true){
            try {
                System.out.print(dis.readUTF() + " ");
                System.out.print(dis.readInt()+ " ");
                System.out.print(dis.readChar());
                System.out.println();
            } catch (IOException e) {
                System.out.println("\nFin fichero\n");
                break;
            }
        }
        dis.close();
        fis.close();


    }

    private static void altaPersona() throws IOException {

        int edad = 0;
        String nombre = "";
        char sexo = ' ';

        FileOutputStream fos = new FileOutputStream(ruta, true);
        DataOutputStream dos = new DataOutputStream(fos);

        System.out.println("Introduce nombre");
        nombre = teclado.next();

        System.out.println("Introduce edad");
        edad = teclado.nextInt();

        System.out.println("Introduce sexo");
        sexo = teclado.next().charAt(0);

        dos.writeUTF(nombre);
        dos.writeInt(edad);
        dos.writeChar(sexo);

        dos.close();
        fos.close();

        System.out.println("\nAltaPersona\n");
    }
}