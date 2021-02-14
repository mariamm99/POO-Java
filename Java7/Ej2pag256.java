package Java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej2pag256 {
  
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("primos.txt"));
      
      String linea = "";
      while (linea != null) {
        System.out.print(linea + " ");
        linea = br.readLine();
      } 
      
      br.close();
      
    } catch (IOException e) {
      System.out.println("Error de lectura.");
    }
  }

}
