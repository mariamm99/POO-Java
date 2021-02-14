package ColeccionesJava;
import java.util.ArrayList;

public class Ejer8pag228 {
  
  /**
   * Realiza un programa que escoja al azar 10 cartas de la baraja española
   * (10 objetos de la clase Carta). Emplea un objeto de la clase ArrayList para
   * almacenarlas y asegúrate de que no se repite ninguna.
   * */
  
  public static void main(String[] args) {
    
    
    ArrayList<Carta> cartas = new ArrayList<Carta>();
    Carta carta;
    
    for (int i = 0; i < 10; i++) {
      do {
        carta = new Carta();
        System.out.println(carta);
      } while (cartas.contains(carta));
      cartas.add(carta);
      
    }
    
    System.out.println(cartas);

    
    
  }

}
