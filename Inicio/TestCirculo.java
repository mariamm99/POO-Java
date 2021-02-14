package Inicio;
import javax.swing.JOptionPane;

public class TestCirculo {
  
  public static void main(String[] args) {
    
    Circulo c1 =new Circulo(6);
    Circulo c2 = new Circulo(0);
    
    System.out.println(c1.toString());
    
    c1.aumentar(27);
    
    System.out.println("aumentamos 27 veces");
    System.out.println(c1.toString());
    
    c1.decrecer(10);
    
    System.out.println("drecrementamos 10 veces");
    System.out.println(c1.toString());
    
    if (c2.getRadio()==0) {
      JOptionPane.showMessageDialog(null, "Soy un misero punto sin radio");
    }
    
  }

}
