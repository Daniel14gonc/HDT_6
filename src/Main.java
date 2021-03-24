import java.io.File;
import java.util.*;
import java.util.Map;
import java.util.ArrayList;

/**
 * Autores: Juan Diego Avila
 *          Marco Pablo Orozco
 *          Daniel Gonzalez Carrillo 20293
 *
 * Modificacion: 2021/03/23
 *
 * Descripcion: Clase que permite elegir hacer todas las operaciones
 *              con las cartas asi como determinar la implementacion
 *              del Map que se desea usar.
*/

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
        scan.nextLine();
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
          while(true){
            scan.nextLine();
            String nombre = "";
            System.out.print("\n\nIngrese el nombre de la carta que desea agregar a su coleccion -> ");
            nombre = scan.nextLine();


            if (coleccion.containsKey(nombre)) {
              System.out.println("\n\t La carta ha sido agregada con exito !");

              if(cartas.containsKey(nombre)){
                int can = Integer.parseInt(cantidad.get(nombre))+1;
                cantidad.put(nombre, can+"");
              }else{
                cantidad.put(nombre, 1+"");
                cartas.put(nombre,coleccion.get(nombre));
              }
              break;

            }else{
              System.out.println("\n\t La carta que ha ingresado no existe!");
            }

          }

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
            System.out.println("\n Nombre: "+nombre.get(i)+" |  Tipo: "+tipo.get(i)+" | Cantidad: "+canti.get(i));
          }


        } else if (seleccion == 4) {

        } else if (seleccion == 5) {
          //Se imprimen todas las cartas con sus tipos de forma desordenada.
          String res = "";
          for(String keys: coleccion.keySet()){
            res +=   keys + " " +  coleccion.get(keys) + "\n";
          }
          System.out.println(res);

        } else if (seleccion == 6) {
          //Se obtienen los tipos de las cartas y luego se ordenan con un sort de collections.
          ArrayList<String> types= new ArrayList<String>();
          for(String key: coleccion.keySet()){
            types.add(coleccion.get(key) + " "+  key);
          }
          Collections.sort(types);

          //Se imprimen las cartas ordenadas por tipo.
          String res = "";
          for(String cards: types){
            res += cards + "\n";
          }
          System.out.println(res);
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