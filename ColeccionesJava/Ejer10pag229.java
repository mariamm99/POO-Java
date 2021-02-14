package ColeccionesJava;

import java.util.HashMap;
import java.util.Scanner;

public class Ejer10pag229 {
  /**
   * Crea un mini-diccionario español-inglés que contenga, al menos, 20 palabras
   * (con su correspondiente traducción). Utiliza un objeto de la clase HashMap
   * para almacenar las parejas de palabras. El programa pedirá una palabra en
   * español y dará la correspondiente traducción en inglés.
   */

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    HashMap<String, String> diccionario = new HashMap<String, String>();

    diccionario.put("mantener", "kept");
    diccionario.put("surgir", "arise");
    diccionario.put("despertarse", "awake");
    diccionario.put("soportar", "bear");
    diccionario.put("doblar", "bend");
    diccionario.put("morder", "bite");
    diccionario.put("romper", "burst");
    diccionario.put("arrastrarse", "creep");
    diccionario.put("negociar", "deal");
    diccionario.put("caer", "fall");
    diccionario.put("luchar", "fight");
    diccionario.put("moler", "grind");
    diccionario.put("arrodillarse", "kneel");
    diccionario.put("lead", "dirigir");
    diccionario.put("subir", "rise");
    diccionario.put("solicitar", "seek");
    diccionario.put("sacudir", "shake");
    diccionario.put("coser", "sew");
    diccionario.put("difundir", "spread");
    diccionario.put("llorar", "weep");

    System.out.println("introduzca el verbo a traducir");
    String palabra = sc.next();
    
    palabra=palabra.toLowerCase();
    
    if (diccionario.containsKey(palabra)) {
      System.out.print( palabra + " significa:  ");
      System.out.println(diccionario.get(palabra));
      } else {
      System.out.print("Esa palabra no esta en el diccionario");
      }
  }
}
