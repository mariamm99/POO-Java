package ColeccionesJava;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
  ArrayList<Carta2> arrayList = new ArrayList<Carta2>();

  public Baraja() {
    for (Palos palo : Palos.values()) {
      for (Figuras figura : Figuras.values()) {
        arrayList.add(new Carta2(palo, figura));
      }
    }

  }

  @Override
  public String toString() {
    return "Baraja [arrayList=" + arrayList + "]";
  }

  public void barajar() {
    Collections.shuffle(arrayList);
    
  }

  public void ordenar() {
    Collections.sort(arrayList);
    
  }

 

}
