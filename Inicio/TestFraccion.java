package Inicio;

import java.util.Scanner;

public class TestFraccion {


  public static void main(String[] args) {
   
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    int nMultiplicar;
    
    Fraccion f1 =new Fraccion(6.0, 2.0);
    Fraccion f2 = new Fraccion(60.0, 40.0);
    
    
    System.out.println("mostramos las frraciones" + f1.muestra() + " y " + f2.muestra());
    
    f1.cadenaCaracteres();
    f2.cadenaCaracteres();
    
    System.out.println("resultado de las fracciones");
    
    System.out.println("fraccion f1 " + f1.resultado());
    System.out.println("fraccion f2 " + f2.resultado());

     System.out.println("indique el número a multiplicar");
     nMultiplicar = sc.nextInt();
     System.out.println("el resultado de multiplicarlo es: " + f1.multiplicacion(nMultiplicar));
     
     System.out.println("fracciones multiplicadas" +f1.muestra() + " y " +f2.muestra() + "es: " + f1.multiplicarFraccion(f2));
     
     System.out.println("suma fracciones " +f1.muestra() + " y " +f2.muestra() + "es: " + f1.sumaFraccion(f2));
     
     System.out.println("resta fraccion " +f1.muestra() + " y " +f2.muestra() + "es: " + f1.restaFraccion(f2));

     Fraccion f3= f2.simplificar();
     
     System.out.println(f2.muestra() + "fraccion simplificada" +f3.muestra());
     
  }
  
}
