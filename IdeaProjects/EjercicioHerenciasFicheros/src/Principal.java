import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    static Scanner sc = new Scanner(System.in);
    static String rutaProgramadores = "src/fichero/programadores.txt";
    static String rutaDisenadores = "src/fichero/diseñadores.txt";

    public static void main(String[] args) throws IOException {
        int op = 0;
        ArrayList<Empleado> empleados = new ArrayList<>();

        do {
            System.out.println("1- Alta de empleado (Programador/Diseñador)" +
                    "\n2- Listar empleados" +
                    "\n3- Listar empleados programadores" +
                    "\n4- Listar empleados diseñadores" +
                    "\n5- Salir");
            op = leerInt("Escoge una opción (1-5): ", 1, 5);

            switch (op) {
                case 1:
                    altaEmpleado(empleados);
                    break;
                case 2:
                    listarDisenadores(empleados);
                    listarProgramadores(empleados);
                    break;
                case 3:
                    listarProgramadores(empleados);
                    break;
                case 4:
                    listarDisenadores(empleados);
                    break;
                case 5:
                    guardarFichero(empleados);
                    break;
            }
        } while (op != 5);
    }

    public static void altaEmpleado(ArrayList<Empleado> empleados) {
        int tipoEmpleado = 0;
        System.out.println("1- Programador" +
                "\n2- Diseñador");
        tipoEmpleado = leerInt("Escoge el tipo de empleado (1-2): ", 1, 2);

        switch (tipoEmpleado) {
            case 1:
                altaProgramador(empleados);
                break;
            case 2:
                altaDisenador(empleados);
                break;
        }
    }

    public static void altaDisenador(ArrayList<Empleado> empleados) {
        int id = 0;
        String nombre = "";
        double salario = 0;
        String herrDiseno = "";

        System.out.println("Has elegido Diseñador.");
        id = leerInt("Introduce el ID (1-1000000): ", 1, 1000000);

        System.out.println("Introduce el nombre: ");
        nombre = sc.nextLine();
        salario = leerDouble("Introduce el salario (1-1000000): ", 1, 1000000);
        System.out.println("Introduce la herramienta de diseño: ");
        herrDiseno = sc.nextLine();

        empleados.add(new Disenador(id, nombre, salario, herrDiseno));
    }

    public static void altaProgramador(ArrayList<Empleado> empleados) {
        int id = 0;
        String nombre = "";
        double salario = 0;
        String lengPrincipal = "";

        System.out.println("Has elegido Programador.");
        id = leerInt("Introduce el ID (1-1000000): ", 1, 1000000);
        System.out.println("Introduce el nombre: ");
        nombre = sc.nextLine();
        salario = leerDouble("Introduce el salario (1-1000000): ", 1, 1000000);
        System.out.println("Introduce el lenguaje principal: ");
        lengPrincipal = sc.nextLine();

        empleados.add(new Programador(id, nombre, salario, lengPrincipal));
    }

    public static int leerInt(String mensaje, int min, int max) {
        int num = 0;

        while (true) {
            System.out.print(mensaje);

            try {
                num = sc.nextInt();
                sc.nextLine();

                if (num >= min && num <= max) {
                    return num;
                }
                System.out.println("Error: El número debe estar entre "
                        + min + " y " + max + ".");
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes escribir un número entero.");
                sc.nextLine();
            }
        }
    }

    public static double leerDouble(String mensaje, double min, double max) {
        double num = 0;

        while (true) {
            System.out.print(mensaje);

            try {
                num = sc.nextDouble();
                sc.nextLine();

                if (num >= min && num <= max) {
                    return num;
                }
                System.out.println("Error: El número debe estar entre "
                        + min + " y " + max + ".");
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes escribir un número decimal válido.");
                sc.nextLine();
            }
        }
    }

    public static void listarDisenadores(ArrayList<Empleado> empleados) throws FileNotFoundException {
        File fichero = new File(rutaDisenadores);

        if (!fichero.exists()) {
            System.out.println("No existe el fichero de diseñadores.");
            return;
        }

        try {
            FileReader fr = new FileReader(rutaDisenadores);
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

    public static void listarProgramadores(ArrayList<Empleado> empleados){
        File fichero = new File(rutaProgramadores);

        if (!fichero.exists()) {
            System.out.println("No existe el fichero de programadores.");
            return;
        }

        try {
            FileReader fr = new FileReader(rutaProgramadores);
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

    public static void guardarFichero(ArrayList<Empleado> empleados) throws IOException {
        FileWriter fwDisenadores = new FileWriter(rutaDisenadores, true);
        FileWriter fwProgramadores = new FileWriter(rutaProgramadores, true);
        BufferedWriter bwDisenadores = new BufferedWriter(fwDisenadores);
        BufferedWriter bwProgramadores = new BufferedWriter(fwProgramadores);

        for (Empleado empleado : empleados) {
            if(empleado instanceof Disenador){
                bwDisenadores.write(empleado.toString());
                bwDisenadores.newLine();
            }else if(empleado instanceof Programador){
                bwProgramadores.write(empleado.toString());
                bwProgramadores.newLine();
            }
        }

        bwDisenadores.close();
        bwProgramadores.close();
        fwDisenadores.close();
        fwProgramadores.close();
    }
}