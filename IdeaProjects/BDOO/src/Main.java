import Entity.PersonaEntity;
import services.PersonaService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static PersonaService ps;
    static Scanner teclado = new Scanner(System.in);

    public static int sumar(){
        int num = 1;

        return ++num;
    }

    public static void main(String[] args) {

        System.out.println(sumar());

        int op = 0;
        ps = new PersonaService();

        do{
            System.out.println("1- Alta persona");
            System.out.println("2- Baja persona");
            System.out.println("3- Modificar persona");
            System.out.println("4- Consulta persona");
            System.out.println("5- Listado persona");
            System.out.println("6- Salir");
            op = teclado.nextInt();

            switch (op){
                case 1:
                    altaPersona();
                    break;
                case 2:
                    eliminarPersona();
                    break;

                case 3:
                    modificarPersona();
                    break;
                case 4:
                    consultaPersona();
                    break;

                case 5:
                    listadoPersona();
                    break;
                case 6:

                    break;

            }

        }while(op != 6);


    }

    private static void modificarPersona() {

        int id = 0;
        String nombre = "";
        String apellido = "";
        int edad = 0;

        PersonaEntity p = new PersonaEntity();

        System.out.println("Introduce id");

        p.setId(teclado.nextInt());

        System.out.println("Introduce nombre");
        p.setNombre(teclado.next());

        System.out.println("Introduce apellido");
        p.setApellido(teclado.next());

        System.out.println("Introduce edad");
        p.setEdad(teclado.nextInt());

         ps.modificarPersona(p);

    }

    private static void eliminarPersona() {

        PersonaEntity p = new PersonaEntity();

        System.out.println("Introduce id");

        p.setId(teclado.nextInt());

        ps.eliminarPersona(p);

    }

    private static void listadoPersona() {
        ps.listadoPersona();
    }

    private static void consultaPersona() {

        PersonaEntity p = new PersonaEntity();

        System.out.println("Introduce id");

        p.setId(teclado.nextInt());

        ps.consultaPersona(p);

    }

    private static void altaPersona() {

        String nombre = "";
        String apellido = "";
        int edad = 0;

        System.out.println("Introduce nombre");
        nombre = teclado.next();

        System.out.println("Introduce apellido");
        apellido = teclado.next();

        System.out.println("Introduce edad");
        edad = teclado.nextInt();

      PersonaEntity p = new PersonaEntity(nombre,apellido, edad);


      ps.altaPersona(p);
        System.out.println("\nAlta persona\n");
    }
}