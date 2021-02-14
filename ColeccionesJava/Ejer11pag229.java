package ColeccionesJava;

import java.util.HashMap;
import java.util.Scanner;

public class Ejer11pag229 {
  /**
   * Realiza un programa que escoja al azar 5 palabras en español del
   * minidiccionario del ejercicio anterior. El programa irá pidiendo que el
   * usuario teclee la traducción al inglés de cada una de las palabras y
   * comprobará si son correctas. Al final, el programa deberá mostrar cuántas
   * respuestas son válidas y cuántas erróneas.
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
    diccionario.put("dirigir", "lead");
    diccionario.put("subir", "rise");
    diccionario.put("solicitar", "seek");
    diccionario.put("sacudir", "shake");
    diccionario.put("coser", "sew");
    diccionario.put("difundir", "spread");
    diccionario.put("llorar", "weep");

    String[] array = diccionario.keySet().toArray(new String[0]);
    
  
    int puntos=0;
    int numero;

    for (int i = 0; i < 5; i++) {
      numero = (int) (Math.random() * 20);

      System.out.println(array[numero]);
      System.out.println("introduzca la palabra en ingles");
      String palabra = sc.next();
      palabra = palabra.toLowerCase();
      System.out.println(diccionario.get(array[numero]));

      if (palabra.equals(diccionario.get(array[numero]))) {
        System.out.println("¡Correcto!");
        puntos+=1;
      } else {
        System.out.println("Respuesta incorrecta ");
        System.out.println("La respuesta correcta es " + diccionario.get(array[numero]));
      }
    }
    System.out.println("puntos totales " + puntos + " de 5");
  }
}
