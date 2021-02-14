package ColeccionesJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ejer12pag229 {
  /**
   * Escribe un programa que genere una secuencia de 5 cartas de la baraja
   * española y que sume los puntos según el juego de la brisca. El valor de las
   * cartas se debe guardar en una estructura HashMap que debe contener parejas
   * (figura, valor), por ejemplo (“caballo”, 3). La secuencia de cartas debe ser
   * una estructura de la clase ArrayList que contiene objetos de la clase Carta.
   * El valor de las cartas es el siguiente: as → 11, tres → 10, sota → 2, caballo
   * → 3, rey → 4; el resto de cartas no vale nada.
   */
  public static void main(String[] args) {
    HashMap<String, Integer> valor = new HashMap<String, Integer>();
    valor.put("as", 11);
     valor.put("dos", 0);
    valor.put("tres", 10);
    valor.put("cuatro", 0);
    valor.put("cinco", 0);
    valor.put("seis", 0);
    valor.put("siete", 0);
    valor.put("sota", 2);
    valor.put("caballo", 3);
    valor.put("rey", 4);
    
    ArrayList<Carta> cartasObtenidas = new ArrayList<Carta>();

    int puntos=0;

    for (int i = 0; i < 5; i++) {
       Carta carta = new Carta();
       cartasObtenidas.add(carta);
             
    }
    System.out.println(cartasObtenidas);
    
    for (Carta miCarta: cartasObtenidas) {
      System.out.println(miCarta);
      puntos += valor.get(miCarta.getNumero());
    }
    
    System.out.println("Tienes " + puntos + " puntos.");
    }
    
    
    
  }


