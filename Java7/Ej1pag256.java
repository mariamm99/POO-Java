package Java7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ej1pag256 {

  public static void main(String[] args) {
    try {
    BufferedWriter escribir = new BufferedWriter(new FileWriter("primos.txt"));
    
    for (int i = 2; i < 501; i+=2) {
      escribir.write(i);
    }
    escribir.close();
    }catch (IOException e) {
      System.err.println("error");
    }
  }
}
