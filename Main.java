import java.io.File;
import java.util.*;

class Main {
  public static void main(String[] args) {
    
    String cartas = "";

    try{

      Scanner input = new Scanner(new File("cards_desc.txt"));
      while (input.hasNextLine()) {
          cartas = input.nextLine();
      }

    }catch(Exception ex){
      ex.printStackTrace();
    }

    input.close();
    
  }
}