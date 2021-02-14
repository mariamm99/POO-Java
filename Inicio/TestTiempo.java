package Inicio;

public class TestTiempo {

  public static void main(String[] args) {
    Tiempo t1= new Tiempo(1, 30, 33);
    Tiempo t2= new Tiempo(4, 1, 25);
    
    Tiempo t3 =t1.Suma(t2);
    System.out.println("la suma del tiempo " + t1.MuestraContenido()+ " mas "+ t2.MuestraContenido() +" es: "+ t3.MuestraContenido());
  
    t3 =t1.Resta(t2);
    System.out.println("la resta del tiempo " + t1.MuestraContenido()+ " mas "+ t2.MuestraContenido() +" es: "+ t3.MuestraContenido());
  
    int h =10;
    int m= 23;
    int s=44;

    t3 =t1.SumaHoras(h);
    System.out.println("la suma del tiempo " + t1.MuestraContenido()+ " mas "+ h +" horas es: "+ t3.MuestraContenido());
  
    t3 =t1.SumaMinutos(m);
    System.out.println("la suma del tiempo " + t1.MuestraContenido()+ " mas "+ m +" minutos es: "+ t3.MuestraContenido());
  
    t3 =t1.SumaSegundos(s);
    System.out.println("la suma del tiempo " + t1.MuestraContenido()+ " mas "+s +" segundos es: "+ t3.MuestraContenido());
  
    t3 =t1.RestaHoras(h);
    System.out.println("la resta del tiempo " + t1.MuestraContenido()+ " menos "+ h +" horas es: "+ t3.MuestraContenido());
  
    t3 =t1.RestaMinutos(m);
    System.out.println("la resta del tiempo " + t1.MuestraContenido()+ " menos "+ m +" minutos es: "+ t3.MuestraContenido());
  
    t3 =t1.RestaSegundos(s);
    System.out.println("la resta del tiempo " + t1.MuestraContenido()+ " menos "+s +" segundos es: "+ t3.MuestraContenido());
  
  
  }
}
