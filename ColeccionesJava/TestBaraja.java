package ColeccionesJava;

import java.util.Collections;

public class TestBaraja {
  public static void main(String[] args) {
   Baraja baraja= new Baraja();
   
   System.out.println(baraja);
   baraja.barajar();
   System.out.println(baraja);
   baraja.ordenar();
   System.out.println(baraja);
  }

}
