package com.petcare.main;

import com.petcare.entity.Mascota;
import com.petcare.entity.Veterinario;
import com.petcare.services.MascotaService;
import com.petcare.services.VeterinarioService;

import java.util.Scanner;

public class App {

    // Creamos los servicios para la lógica de las mascotas y veterinarios
    static MascotaService ms;
    static VeterinarioService vs;
    static Scanner sc = new Scanner(System.in);

    // Método principal en el que ejecutamos el menú principal hasta que el usuario salga
    public static void main(String[] args) {
        int opModulos = 0, opMenu = 0;

        // Se repetirá el menú mientras el usuario no escriba un 3
        do {

            // Menú principal para elegir módulo
            System.out.println("\n========================================" +
                    "\nSISTEMA VETERINARIO PETCARE (BDOO)" +
                    "\n========================================" +
                    "\n1. Módulo de Mascotas" +
                    "\n2. Módulo de Veterinarios" +
                    "\n3. Salir" +
                    "\n========================================" +
                    "\nEscoge una opción (1-3): ");
            opModulos = sc.nextInt();
            sc.nextLine();

            // Según la elección se mostrará un menú u otro
            switch(opModulos){

                // Módulo de mascotas
                case 1:
                    System.out.println("\n========================================" +
                            "\nMÓDULO DE MASCOTAS" +
                            "\n========================================" +
                            "\n1. Registrar mascota" +
                            "\n2. Buscar por microchip" +
                            "\n3. Listar mascotas" +
                            "\n4. Modificar datos" +
                            "\n5. Eliminar mascota" +
                            "\n========================================" +
                            "\nEscoge una opción (1-5): ");
                    opMenu = sc.nextInt();
                    sc.nextLine();
                    ms = new MascotaService();

                    // Según la elección se ejecutará un método u otro
                    switch(opMenu){
                        case 1:
                            registrarMascota();
                            break;
                        case 2:
                            buscarMascotaPorChip();
                            break;
                        case 3:
                            listarMascotas();
                            break;
                        case 4:
                            modificarDatosMascota();
                            break;
                        case 5:
                            eliminarMascota();
                            break;
                    }
                    break;

                // Módulo de veterinarios
                case 2:
                    System.out.println("\n========================================" +
                            "\nMÓDULO DE VETERINARIOS" +
                            "\n========================================" +
                            "\n1. Registrar veterinario" +
                            "\n2. Buscar por colegiado" +
                            "\n3. Listar veterinarios" +
                            "\n4. Modificar especialidad" +
                            "\n5. Eliminar veterinario" +
                            "\n========================================" +
                            "\nEscoge una opción (1-5): ");
                    opMenu = sc.nextInt();
                    sc.nextLine();
                    vs = new VeterinarioService();

                    // Según la elección se ejecutará un método u otro
                    switch(opMenu){
                        case 1:
                            registrarVeterinario();
                            break;
                        case 2:
                            buscarVeterinarioPorColegiado();
                            break;
                        case 3:
                            listarVeterinarios();
                            break;
                        case 4:
                            modificarEspecialidadVeterinario();
                            break;
                        case 5:
                            eliminarVeterinario();
                            break;
                    }
                    break;
                case 3:
                    break;
            }
        } while (opModulos != 3);
    }

    // Método que pide el id del veterinario para buscarlo y borrarlo si existe
    private static void eliminarVeterinario() {
        Veterinario v = new Veterinario();

        System.out.println("Introduce el ID del veterinario que quieras eliminar: ");
        v.setId(sc.nextInt());

        vs.eliminarVeterinario(v);
    }

    // Método que pide el id del veterinario y la especialidad que se le quiere modificar
    private static void modificarEspecialidadVeterinario() {
        Veterinario v = new Veterinario();

        System.out.println("Introduce el ID del veterinario que quieras modificar: ");
        v.setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Introduce la especialidad: ");
        v.setEspecialidad(sc.nextLine());

        vs.modificarEspecialidadVeterinario(v);
    }

    // Llamamos al método del servicio para listar los veterinarios
    private static void listarVeterinarios() {
        vs.listarVeterinarios();
    }

    // Método que pide el id de la mascota para buscarla y borrarla si existe
    private static void eliminarMascota() {
        Mascota m = new Mascota();

        System.out.println("Introduce el ID de la mascota que quieras eliminar: ");
        m.setId(sc.nextInt());

        ms.eliminarMascota(m);
    }

    // Método que pide el id del veterinario y preguntará que dato se quiere modificar
    private static void modificarDatosMascota() {
        int op = 0;

        Mascota m = new Mascota();

        System.out.println("Introduce el ID de la mascota que quieras modificar: ");
        m.setId(sc.nextInt());
        sc.nextLine();
        System.out.println("¿Qué quieres modificar?" +
                "\n1. Nombre" +
                "\n2. Edad");
        op = sc.nextInt();
        sc.nextLine();

        // Dependiendo de la opción que escoja el usuario se modificará un dato u otro
        if(op == 1){
            System.out.println("Introduce el nombre: ");
            m.setNombre(sc.nextLine());
        }else if(op == 2){
            System.out.println("Introduce la edad: ");
            m.setEdad(sc.nextInt());
            sc.nextLine();
        }
        ms.modificarDatosMascota(m, op);
    }

    // Llamamos al método del servicio para listar las mascotas
    private static void listarMascotas() {
        ms.listarMascotas();
    }

    // Método en el que introducimos los datos de la mascota que queremos registrar
    public static void registrarMascota(){
        String chip = "";
        String nombre = "";
        String especie = "";
        int edad = 0;

        System.out.println("Introduce el chip: ");
        chip = sc.nextLine();
        System.out.println("Introduce el nombre: ");
        nombre = sc.nextLine();
        System.out.println("Introduce la especie: ");
        especie = sc.nextLine();
        System.out.println("Introduce la edad: ");
        edad = sc.nextInt();
        Mascota m = new Mascota(chip, nombre, especie, edad);

        ms.registrarMascota(m);
    }

    // Método en el que introducimos los datos del veterinario que queremos registrar
    public static void registrarVeterinario(){
        String numColegiado = "";
        String nombre = "";
        String especialidad = "";

        System.out.println("Introduce el número de colegiado: ");
        numColegiado = sc.nextLine();
        System.out.println("Introduce el nombre: ");
        nombre = sc.nextLine();
        System.out.println("Introduce la especialidad: ");
        especialidad = sc.nextLine();
        Veterinario v = new Veterinario(numColegiado, nombre, especialidad);

        vs.registrarVeterinario(v);
    }

    // Método en el que introducimos el chip de la mascota que queremos mostrar
    public static void buscarMascotaPorChip(){
        Mascota m = new Mascota();

        System.out.println("Introduce el chip buscado: ");
        m.setChip(sc.nextLine());
        ms.buscarMascotaPorChip(m);
    }

    // Método en el que introducimos el chip del veterinario que queremos mostrar
    public static void buscarVeterinarioPorColegiado(){
        Veterinario v = new Veterinario();

        System.out.println("Introduce el número de colegiado: ");
        v.setNumColegiado(sc.nextLine());
        vs.buscarVeterinarioPorColegiado(v);
    }
}
