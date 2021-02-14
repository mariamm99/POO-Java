package Java7;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class Encriptar {
  //char[] original = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R','S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  //char[] cifrado = {'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q','R', 'S', 'T', 'U', 'V', 'W', 'X'};

  static String leer(String archivo) {
    String texto;
    try {
      FileReader documento = new FileReader(archivo);
      BufferedReader lectura = new BufferedReader(documento);
      texto = lectura.readLine();
      return texto;

    } catch (IOException ex) {

      System.out.println(ex);
      return "error";

    }
  }

  public static void main(String[] args) {

    String texto;
    texto = leer(args[2]);
    System.out.println(texto);
  }

}
