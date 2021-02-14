package Inicio;

public class TestRectangulo {
  public static void main(String[] args) {
  Rectangulo r1= new Rectangulo(4,8);
  Rectangulo r2= new Rectangulo(2,7);
  Rectangulo r3= new Rectangulo(3,0);

  System.out.println("Probamos clase Rectángulo con "+ r1.getBase() +","+ r1.getAltura() +" y"+ r2.getBase() +","+r2.getAltura());

  //Mostramos los rectángulos
  r1.Muestra();
  r2.Muestra();

  // Comparamos los rectángulos
  System.out.println("Resultado de comparar r1 con r2:"+ r1.Compara(r2));
  System.out.println("¿Son gemelos?"+ r1.EsGemelo(r2));

 // Magnitudes de los rectángulos
  System.out.println("Área r1:"+ r1.getArea()+ "Perímetro r1:"+ r1.getPerimetro());
  System.out.println("Área r2:"+ r2.getArea()+ "Perímetro r2:"+ r2.getPerimetro());
  r3.Muestra();
  }
}