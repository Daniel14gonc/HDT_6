import java.io.File;
import java.util.*;
import java.util.Map;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    // Scanner para leer las respuestas del usuario
    Scanner scan = new Scanner(System.in);
    Map<String, String> coleccion; //Todas las cartas que existen.
    Map<String, String> cartas; //Cartas del usuario.
    Map<String, String> cantidad;

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
          cantidad = mapFactory.getMap(opcion);
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
        String[] carta = c.split("\\|");
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

          scan.nextLine();

          while(true){

            String nombre = "";
            String tipo = "";

            System.out.print("\n\nIngrese el nombre de la carta que desea agregar a su coleccion -> ");
            nombre = scan.nextLine();


            if (coleccion.containsKey(nombre)) {

              cartas.put(nombre,coleccion.get(nombre));
              System.out.println("\n\t La carta ha sido agregada con exito !");

              if(cartas.containsKey(nombre)){
                int can = Integer.parseInt(cantidad.get(nombre))+1;
                cantidad.put(nombre, can+"");
              }
              break;

            }else{
              System.out.println("\n\t La carta que ha ingresado no existe!");
            }

          }

          System.out.println("\n\nPresiona [ ENTER ] para regresar al menu...");
          scan.nextLine();

        } else if (seleccion == 2) {

        } else if (seleccion == 3) {

          scan.nextLine();

          //muestra el nombre,el tipo y la cantidad de cartas.
          ArrayList<String> nombre = new ArrayList<String>();
          ArrayList<String> tipo = new ArrayList<String>();
          ArrayList<Integer> canti = new ArrayList<Integer>();

          for (String carta : cartas.keySet()) {

            nombre.add(carta);
            tipo.add(cartas.get(carta));
            canti.add(Integer.parseInt(cantidad.get(carta)));

          }

          for(int i = 0; i<nombre.size();i++){
            System.out.println("\n Nombre: "+nombre.get(i)+" |  Tipo: "+tipo.get(i)+" | Cantidad: "+cantidad.get(i));
          }

          System.out.println("\n\nPresiona [ ENTER ] para regresar al menu...");
          scan.nextLine();

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