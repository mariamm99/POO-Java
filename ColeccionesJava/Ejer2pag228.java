package ColeccionesJava;

import java.util.ArrayList;
import java.util.HashMap;

public class Ejer2pag228 {

  /**
   * Realiza un programa que introduzca valores aleatorios (entre 0 y 100) en un
   * ArrayList y que luego calcule la suma, la media, el máximo y el mínimo de
   * esos números. El tamaño de la lista también será aleatorio y podrá oscilar
   * entre 10 y 20 elementos ambos inclusive.
   */

  public static void main(String[] args) {
    ArrayList<Integer> nAleatorios = new ArrayList<Integer>();
    
    int tamanoLista;
    tamanoLista = (int) (Math.random() * 10 + 10);
    System.out.println("longitud del array " + tamanoLista);
    
    for (int i = 0; i < tamanoLista; i++) {
      nAleatorios.add((int) (Math.random() * 100));
    }
    
    System.out.println(nAleatorios);

  }
}
