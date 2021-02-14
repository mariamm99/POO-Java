package ColeccionesJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Ejer3pag228 {

  /**
   * Escribe un programa que ordene 10 números enteros introducidos por teclado y
   * almacenados en un objeto de la clase ArrayList.
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    ArrayList<Integer> numeros = new ArrayList<Integer>();

    for (int i = 0; i < 10; i++) {
      System.out.println("Indique el número a añadir");
      numeros.add(sc.nextInt());
    }
    
    Collections.sort(numeros);
    System.out.println(numeros);
    
  }
}
