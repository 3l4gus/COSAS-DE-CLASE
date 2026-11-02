import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Spok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random aleatorio = new Random();

        //Variables
        int nPartidas = 0, opJugador = 0, opIA = 0, resultado = 0;
        String nombre = "";
        boolean otraPartida = false;

        //Título que aparece solo al principio del juego
        System.out.println("---PIEDRA, PAPEL, TIJERAS, LAGARTO O SPOCK---");

        //Todo el proceso de la partida que se repetirá hasta que no queramos seguir jugando
        do{
            int puntosJugador = 0, puntosIA = 0;

            //Preguntamos el número de partidas que queremos jugar comprobando que sea un número y sea mínimo una
            do {
                System.out.println("¿Cuántas partidas quieres jugar?");

                try {
                    nPartidas = sc.nextInt();

                    if (nPartidas <= 0) {
                        System.out.println("Debes jugar al menos una partida.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Introduce un número entero válido.");
                    sc.nextLine();
                    nPartidas = 0;
                }
            } while (nPartidas <= 0);

            //Se recorrerá tantas veces como partidas hayas escogido jugar
            for(int partida = 1; partida <= nPartidas; partida++){
                System.out.println("---PARTIDA " + partida + "---\n" +
                        "¿Que opción quieres escoger?\n" +
                        "1- Piedra\n" +
                        "2- Papel\n" +
                        "3- Tijeras\n" +
                        "4- Lagarto\n" +
                        "5- Spock");

                //Coprobamos que la elección que escojamos esté entre las 5 válidas que hay
                do {
                    try {
                        opJugador = sc.nextInt();

                        if (opJugador < 1 || opJugador > 5) {
                            System.out.println("Escoge una opción entre 1 y 5.");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Introduce un número entero entre 1 y 5.");
                        sc.nextLine();
                        opJugador = 0;
                    }
                } while (opJugador < 1 || opJugador > 5);

                //Llamamos al método para poder imprimir el nombre de la opción que escogimos nosotros y la IA
                nombre = nombreOpcion(opJugador);
                System.out.println("Has escogido " + nombre + "!");
                opIA = aleatorio.nextInt(5) + 1;
                sc.nextLine();
                nombre = nombreOpcion(opIA);
                System.out.println("La IA ha escogido " + nombre + "!");

                //Dependiendo de lo que hayamos escogido nosotros y la IA podremos ganar, empatar o perder la ronda
                if (opJugador == opIA){
                    resultado = 0;
                }else{
                    switch (opJugador){
                        case 1:
                            if (opIA == 3 || opIA == 4){
                                resultado = 1;
                            }else{
                                resultado = 2;
                            }
                            break;
                        case 2:
                            if (opIA == 1 || opIA == 5){
                                resultado = 1;
                            }else{
                                resultado = 2;
                            }
                            break;
                        case 3:
                            if (opIA == 2 || opIA == 4){
                                resultado = 1;
                            }else{
                                resultado = 2;
                            }
                            break;
                        case 4:
                            if (opIA == 2 || opIA == 5){
                                resultado = 1;
                            }else{
                                resultado = 2;
                            }
                            break;
                        default:
                            if (opIA == 1 || opIA == 3){
                                resultado = 1;
                            }else{
                                resultado = 2;
                            }
                            break;
                    }
                }

                //Se imprimirá por consola el ganador y se sumarán los puntos dependiendo del resultado
                if (resultado == 0){
                    System.out.println("-HABEIS EMPATADO LA RONDA-\n");
                } else if (resultado == 1){
                    System.out.println("-HAS GANADO LA RONDA-\n");
                    puntosJugador++;
                } else{
                    System.out.println("-HAS PERDIDO LA RONDA-\n");
                    puntosIA++;
                }

                //Mostramos la suma de puntos que llevamos hasta ahora
                System.out.println("---PUNTUACIONES ACTUALES---\n" +
                        "Jugador: " + puntosJugador + "\n" +
                        "IA: " + puntosIA + "\n");
            }

            //Cuando se acaba el número de partidas que indicamos, nos dice quién ha ganado dependiendo del número de puntos que llevemos
            if(puntosJugador > puntosIA){
                System.out.println("---FELICIDADES, HAS GANADO LA PARTIDA---\n");
            }else if(puntosIA > puntosJugador){
                System.out.println("---HA GANADO LA IA---\n");
            }else{
                System.out.println("---HA ACABADO EN EMPATE---\n");
            }

            //Preguntamos si queremos seguir jugando y comprobamos que lo que escribamos corresponda con alguna de las dos opciones válidas
            String respuesta = "";

            do {
                System.out.print("¿Quieres seguir jugando? (SI/NO): ");
                respuesta = sc.nextLine().toLowerCase();
            } while (!respuesta.equals("si") && !respuesta.equals("no"));

            //Dependiendo de lo que escojamos, se repetirá el do while o se acabará el juego
            if(respuesta.equals("si")){
                otraPartida = true;
            }else{
                otraPartida = false;
            }
        }while(otraPartida);

        sc.close();
    }

    //Método para que, dependiendo de la opción que escojas, se guarde el nombre para imprimirlo luego por consola
    private static String nombreOpcion(int opcion){
        switch (opcion){
            case 1:
                return "Piedra";
            case 2:
                return "Papel";
            case 3:
                return "Tijeras";
            case 4:
                return "Lagarto";
            default:
                return "Spock";
        }
    }
}