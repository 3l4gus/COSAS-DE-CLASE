package com.petcare.main;

import com.petcare.entity.Mascota;
import com.petcare.entity.Veterinario;
import com.petcare.services.MascotaService;
import com.petcare.services.VeterinarioService;

import java.util.Scanner;

public class App {
    static MascotaService ms;
    static VeterinarioService vs;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opModulos = 0, opMenu = 0;
        do {
            System.out.println("\n========================================" +
                    "\nSISTEMA VETERINARIO PETCARE (BDOO)" +
                    "\n========================================" +
                    "\n1. Módulo de Mascotas" +
                    "\n2. Módulo de Veterinarios" +
                    "\n3. Salir" +
                    "\n========================================" +
                    "\nEscoge una opción (1-3): ");
            opModulos = sc.nextInt();

            switch(opModulos){
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
                    ms = new MascotaService();

                    switch(opMenu){
                        case 1:
                            registrarMascota();
                            break;
                        case 2:
                            buscarMascotaPorChip();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                    }
                    break;
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
                    vs = new VeterinarioService();

                    switch(opMenu){
                        case 1:
                            registrarVeterinario();
                            break;
                        case 2:
                            buscarVeterinarioPorColegiado();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 3:
                    break;
            }
        } while (opModulos != 3);
    }

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

    public static void buscarMascotaPorChip(){
        Mascota m = new Mascota();

        System.out.println("Introduce el chip buscado: ");
        m.setChip(sc.nextLine());
        ms.buscarMascotaPorChip(m);
    }

    public static void buscarVeterinarioPorColegiado(){
        Veterinario v = new Veterinario();

        System.out.println("Introduce el número de colegiado: ");
        v.setNumColegiado(sc.nextLine());
        vs.buscarVeterinarioPorColegiado(v);
    }
}
