package ColeccionesJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejer9pag229 {
  /**
   * Modifica el programa anterior de tal forma que las cartas se muestren
   * ordenadas. Primero se ordenarán por palo: bastos, copas, espadas, oros.
   * Cuando coincida el palo, se ordenará por número: as, 2, 3, 4, 5, 6, 7, sota,
   * caballo, rey.
   * 
   */

  public static void main(String[] args) {

    ArrayList<Carta2> cartasObtenidas = new ArrayList<Carta2>();
    Carta2 carta;

    for (int i = 0; i < 10; i++) {
      do {
        carta = new Carta2();
      } while (cartasObtenidas.contains(carta));
      cartasObtenidas.add(carta);

    }

    // cartasObtenidas.sort(c);
    Collections.sort(cartasObtenidas);
    System.out.println(cartasObtenidas);

  }
}
