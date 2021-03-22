import java.io.File;
import java.util.*;
import java.util.Map;

class Main {
  public static void main(String[] args) {
    // Scanner para leer las respuestas del usuario
    Scanner scan = new Scanner(System.in);
    Map<String, String> coleccion;
    Map<String, String> cartas;

    System.out.println("\n Bienvenido al sistema de coleccion de cartas!");
    System.out.println("\n Elije la implementacion que deseas utilizar:");
    System.out.println("\t [ 1 ] HashMap.");
    System.out.println("\t [ 2 ] LinkedHashMap.");
    System.out.println("\t [ 3 ] TreeMap.");

    int opcion = 0;
    while (true) {
      try {

        Factory<String, String> mapFactory = new Factory<String, String>();

        System.out.print("\n\t Opcion -> ");
        opcion = scan.nextInt();

        if (opcion < 4 && opcion > 0) {

          // Instanciamos la clase factory para elegir la implementacion
          // Elegida por el usuario

          coleccion = mapFactory.getMap(opcion);
          cartas = mapFactory.getMap(opcion);
          break;
        } else {
          scan.nextLine();
          System.out.println("\nIngrese un numero dentro del rango de 1 a 3 !");
        }

      } catch (Exception e) {

        System.out.println("\n Ingrese valores numericos !");
      }
    }


    // Se comienza a leer el documento que contiene las cartas
    String c = "";

    try {

      Scanner input = new Scanner(new File("cards_desc.txt"));
      while (input.hasNextLine()) {
        c = input.nextLine();
        String[] carta = c.split("|");
        coleccion.put(carta[0],carta[1]);
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    // Comienza el menu para elegir una de las opciones disponibles
    int seleccion = 0;
    while (seleccion != 7) {
      try {

        System.out.println("\n Bienvenido al menu de opciones!");
        System.out.println("\t[ 1 ] Agregar una carta a mi coleccion.");
        System.out.println("\t[ 2 ] Mostrar el tipo de una de las cartas.");
        System.out.println("\t[ 3 ] Mostrar informacion de mi coleccion.");
        System.out.println("\t[ 4 ] Mostrar informacion de mi coleccion en orden.");
        System.out.println("\t[ 5 ] Mostrar informacion de todas las cartas.");
        System.out.println("\t[ 6 ] Mostrar informacion de todas las cartas en orden.");
        System.out.println("\t[ 7 ] Salir");

        System.out.print("\n\t Opcion -> ");
        seleccion = scan.nextInt();

        if (seleccion == 1) {
          
        } else if (seleccion == 2) {

        } else if (seleccion == 3) {

        } else if (seleccion == 4) {

        } else if (seleccion == 5) {

        } else if (seleccion == 6) {

        }else if(seleccion == 7) {
          System.out.println("Adios!");
        }else {
          System.out.println("Por favor ingresa una opcion valida!");
        }
      } catch (Exception e) {
        scan.nextLine();
        System.out.println("Por favor ingresa un numero!");
      }
    }
  }
}