package fichero;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    //Creamos scanner y ruta globales
    static Scanner sc = new Scanner(System.in);
    static String ruta = "src/fichero/productos.dat";

    public static void main(String[] args) throws IOException {

        //Hacemos un do while para que el usuario escoja opciones del menú hasta que elija el 7
        var opcion = 0;
        do {
            System.out.println("\n1. Alta de producto" +
                    "\n2. Ver todos los productos" +
                    "\n3. Buscar producto por nombre" +
                    "\n4. Listar productos por categoría" +
                    "\n5. Mostrar productos económicos (precio < 30€)" +
                    "\n6. Mostrar productos premium (precio >= 50€)" +
                    "\n7. Salir ");

            //Comprobamos que la opción que elija sea válida con un try catch y si no lo
            //es lo indicamos con un syso
            do {
                try {
                    opcion = sc.nextInt();
                    sc.nextLine();

                    if (opcion < 1 || opcion > 7) {
                        System.out.println("El límite debe de estar entre 1 y 7.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes escribir un número.");
                    sc.nextLine();
                }
            } while (opcion < 1 || opcion > 7);

            //Hacemos un switch que ejecutará un método u otro dependiendo de
            //la opción que elija el usuario
            switch (opcion) {
                case 1:
                    altaProducto();
                    break;
                case 2:
                    verProductos();
                    break;
                case 3:
                    buscarProductoNombre();
                    break;
                case 4:
                    listarProductosCategoria();
                    break;
                case 5:
                    mostrarEconomicos();
                    break;
                case 6:
                    mostrarPremium();
                    break;
                case 7:
                    System.out.println("Fin del programa.");
                    break;
            }
        } while (opcion != 7);
    }

    //Método para mostrar los productos que tengan el precio >= 50
    private static void mostrarPremium() throws IOException {

        //Creamos un booleano que indicará si hay productos que coincidan con lo que se busca
        boolean existe = false;

        //Abrimos un fichero binario indicando la ruta con FileInputStream y convertimos de bytes
        //a caracteres legibles con DataInputStream
        FileInputStream fis = new FileInputStream(ruta);
        DataInputStream dis = new DataInputStream(fis);

        //Usamos un while (true) para que lea el fichero hasta que este llegue a su fin
        while (true) {

            //Creamos variables para guardar los datos de cada producto
            String nom = "";
            String cat = "";
            int sto = 0;
            double pre = 0;

            try {

                //Guardamos los datos de cada producto en las variables creadas anteriormente
                nom = dis.readUTF();
                cat = dis.readUTF();
                sto = dis.readInt();
                pre = dis.readDouble();

                //Imprimiremos por consola los productos que tengan un precio >= 50€
                if (pre >= 50) {
                    System.out.print(nom + " - "
                            + cat + " - "
                            + sto + " - "
                            + pre + "\n");
                    existe = true;
                }
            } catch (IOException e) {
                break;
            }
        }

        //Cerramos el fichero
        dis.close();
        fis.close();

        //Si el booleano es false indicaremos que no hay productos con un precio >= 50€
        if (!existe) {
            System.out.println("No hay productos con un precio >= 50€.");
        }
    }

    //Método para mostrar los productos que tengan el precio < 30€
    private static void mostrarEconomicos() throws IOException {

        //Creamos un booleano que indicará si hay productos que coincidan con lo que se busca
        boolean existe = false;

        //Abrimos un fichero binario indicando la ruta con FileInputStream y convertimos de bytes
        //a caracteres legibles con DataInputStream
        FileInputStream fis = new FileInputStream(ruta);
        DataInputStream dis = new DataInputStream(fis);

        //Usamos un while (true) para que lea el fichero hasta que este llegue a su fin
        while (true) {

            //Creamos variables para guardar los datos de cada producto
            String nom = "";
            String cat = "";
            int sto = 0;
            double pre = 0;

            try {

                //Guardamos los datos de cada producto en las variables creadas anteriormente
                nom = dis.readUTF();
                cat = dis.readUTF();
                sto = dis.readInt();
                pre = dis.readDouble();

                //Imprimiremos por consola los productos que tengan un precio < 30€
                if (pre < 30) {
                    System.out.print(nom + " - "
                            + cat + " - "
                            + sto + " - "
                            + pre + "\n");
                    existe = true;
                }
            } catch (IOException e) {
                break;
            }
        }

        //Cerramos el fichero
        dis.close();
        fis.close();

        //Si el booleano es false indicaremos que no hay productos con un precio < 30€
        if (!existe) {
            System.out.println("No hay productos con un precio < 30€.");
        }
    }

    //Método para mostrar los productos que coincidan con la categoría que elija el usuario
    private static void listarProductosCategoria() throws IOException {

        //Creamos un booleano que indicará si hay productos que coincidan con lo que se busca,
        //un int para que el usuario escoja una opción y un String para guardar el nombre de la
        //categoría que escoja el usuario
        int opcion = 0;
        boolean existe = false;
        String categoria = "";

        //Abrimos un fichero binario indicando la ruta con FileInputStream y convertimos de bytes
        //a caracteres legibles con DataInputStream
        FileInputStream fis = new FileInputStream(ruta);
        DataInputStream dis = new DataInputStream(fis);

        //Mostramos las opciones
        System.out.println("Selección categoría:" +
                "\n1. Alimentación" +
                "\n2. Bebidas" +
                "\n3. Droguería" +
                "\n4. Electrónica");

        //Comprobamos que la opción que elija sea válida con un try catch y si no lo
        //es lo indicamos con un syso
        do {
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                if (opcion < 1 || opcion > 4) {
                    System.out.println("El límite debe de estar entre 1 y 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes escribir un número.");
                sc.nextLine();
            }
        } while (opcion < 1 || opcion > 4);

        //Hacemos un switch que guardará un nombre de la categoría en el String categoria
        //dependiendo de la opción que elija el usuario
        switch (opcion) {
            case 1:
                categoria = "Alimentación";
                break;
            case 2:
                categoria = "Bebidas";
                break;
            case 3:
                categoria = "Droguería";
                break;
            case 4:
                categoria = "Electrónica";
                break;
        }

        //Usamos un while (true) para que lea el fichero hasta que este llegue a su fin
        while (true) {

            //Creamos variables para guardar los datos de cada producto
            String nom = "";
            String cat = "";
            int sto = 0;
            double pre = 0;

            try {

                //Guardamos los datos de cada producto en las variables creadas anteriormente
                nom = dis.readUTF();
                cat = dis.readUTF();
                sto = dis.readInt();
                pre = dis.readDouble();

                //Imprimiremos por consola los productos que coincidan con la categoría escogida
                if (cat.equalsIgnoreCase(categoria)) {
                    System.out.print(nom + " - "
                            + cat + " - "
                            + sto + " - "
                            + pre + "\n");
                    existe = true;
                }
            } catch (IOException e) {
                break;
            }
        }

        //Cerramos el fichero
        dis.close();
        fis.close();

        //Si el booleano es false indicaremos que no hay productos que coincidan con esa categoría
        if (!existe) {
            System.out.println("No hay productos con esa categoría.");
        }
    }

    //Método para mostrar los productos que coincidan con el nombre que escriba el usuario
    private static void buscarProductoNombre() throws IOException {

        //Creamos un booleano que indicará si hay productos que coincidan con lo que se busca
        //y un String para guardar el nombre que escriba el usuario
        String nombre = "";
        boolean existe = false;

        //Introducimos y guardamos el nombre
        System.out.println("Introduce nombre:");
        nombre = sc.next();

        //Abrimos un fichero binario indicando la ruta con FileInputStream y convertimos de bytes
        //a caracteres legibles con DataInputStream
        FileInputStream fis = new FileInputStream(ruta);
        DataInputStream dis = new DataInputStream(fis);

        //Usamos un while (true) para que lea el fichero hasta que este llegue a su fin
        while (true) {

            //Creamos variables para guardar los datos de cada producto
            String nom = "";
            String cat = "";
            int sto = 0;
            double pre = 0;

            try {

                //Guardamos los datos de cada producto en las variables creadas anteriormente
                nom = dis.readUTF();
                cat = dis.readUTF();
                sto = dis.readInt();
                pre = dis.readDouble();

                //Imprimiremos por consola los productos que coincidan con el nombre escrito
                if (nom.equalsIgnoreCase(nombre)) {
                    System.out.print(nom + " - "
                            + cat + " - "
                            + sto + " - "
                            + pre + "\n");
                    existe = true;
                }
            } catch (IOException e) {
                break;
            }
        }

        //Cerramos el fichero
        dis.close();
        fis.close();

        //Si el booleano es false indicaremos que no hay productos que coincidan con ese nombre
        if (!existe) {
            System.out.println("No hay productos con ese nombre.");
        }
    }

    //Método para mostrar todos los productos
    private static void verProductos() throws IOException {

        //Abrimos un fichero binario indicando la ruta con FileInputStream y convertimos de bytes
        //a caracteres legibles con DataInputStream
        FileInputStream fis = new FileInputStream(ruta);
        DataInputStream dis = new DataInputStream(fis);

        //Usamos un while (true) para que lea el fichero hasta que este llegue a su fin
        while (true) {
            try {

                //Imprimimos cada producto por consola
                System.out.print(dis.readUTF() + " - " +
                        dis.readUTF() + " - " +
                        dis.readInt() + " - " +
                        dis.readDouble());
            } catch (IOException e) {
                System.out.println("\nFin fichero\n");
                break;
            }
        }

        //Cerramos el fichero
        dis.close();
        fis.close();
    }

    //Método para agregar un nuevo producto
    private static void altaProducto() throws IOException {

        //Creamos las variables para cada dato del producto que queremos agregar y un int
        //para guardar la opción de la categoría escogida por el usuario
        String nombre = "";
        String categoria = "";
        int stock = 0;
        double precio = 0;
        int opcion = 0;

        //Abrimos un fichero binario indicando la ruta con FileInputStream y convertimos de bytes
        //a caracteres legibles con DataInputStream
        FileOutputStream fos = new FileOutputStream(ruta, true);
        DataOutputStream dos = new DataOutputStream(fos);

        //Pedimos el nombre
        System.out.println("Introduce nombre:");
        nombre = sc.next();

        //Mostramos las opciones para la categoría
        System.out.println("Selección categoría:" +
                "\n1. Alimentación" +
                "\n2. Bebidas" +
                "\n3. Droguería" +
                "\n4. Electrónica");

        //Comprobamos que la opción que elija sea válida con un try catch y si no lo
        //es lo indicamos con un syso
        do {
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                if (opcion < 1 || opcion > 4) {
                    System.out.println("El límite debe de estar entre 1 y 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes escribir un número.");
                sc.nextLine();
            }
        } while (opcion < 1 || opcion > 4);

        //Hacemos un switch que guardará un nombre de la categoría en el String categoria
        //dependiendo de la opción que elija el usuario
        switch (opcion) {
            case 1:
                categoria = "Alimentación";
                break;
            case 2:
                categoria = "Bebidas";
                break;
            case 3:
                categoria = "Droguería";
                break;
            case 4:
                categoria = "Electrónica";
                break;
        }

        //Pedimos el stock
        System.out.println("Introduce stock:");
        stock = sc.nextInt();

        //Pedimos el precio
        System.out.println("Introduce precio:");
        precio = sc.nextDouble();

        //Guardamos los datos en el fichero
        dos.writeUTF(nombre);
        dos.writeUTF(categoria);
        dos.writeInt(stock);
        dos.writeDouble(precio);

        //Cerramos el fichero
        dos.close();
        fos.close();

        //Indicamos que se ha agregado el producto
        System.out.println("\nAlta Producto\n");
    }
}
