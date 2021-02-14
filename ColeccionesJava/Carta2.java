package ColeccionesJava;

import java.util.Collections;

public class Carta2 implements Comparable<Carta2> {

 

  private Palos palo;
  private Figuras figura;

  public Carta2(Palos palo, Figuras figura) {
    this.palo = palo;
    this.figura = figura;
  }

  public Carta2() {
    this.figura = Figuras.values()[(int) (Math.random() * 10)];
    this.palo = Palos.values()[(int) (Math.random() * 4)];
  }

  @Override
  public String toString() {
    return figura + " de " + palo;
  }

  @Override
  public int compareTo(Carta2 carta) {//    Collections.sort(cartasObtenidas);

    if (palo == carta.palo) {
      return figura.compareTo(carta.figura);
    }
    // else {
    return palo.compareTo(carta.palo);
    // }

  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((figura == null) ? 0 : figura.hashCode());
    result = prime * result + ((palo == null) ? 0 : palo.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {//   } while (cartasObtenidas.contains(carta));
    
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Carta2 other = (Carta2) obj;
    if (figura != other.figura)
      return false;
    if (palo != other.palo)
      return false;
    return true;
  }

}
