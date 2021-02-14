package Inicio;
import java.lang.Class;

public class Rectangulo {
  public int numRectangulo;   
  private int base=1;
  private int altura=1;

  public Rectangulo(int base, int altura) {
    setBase(base);
    setAltura(altura);
  }
  public int getBase() {
    return base;
  }

  public void setBase(int base) {
    if (EsLadoCorrecto(base)) {
      this.base = base;
    }else {
      System.out.println("dato erroneo en la base " + this.base );
    }
  }

  public int getAltura() {
    return this.altura;
  }

  public void setAltura(int altura) {
    if (EsLadoCorrecto(altura)) {
      this.altura = altura;
    }else {
      System.out.println("dato erroneo en la altura " + this.altura);
    }
  }

  public int getPerimetro(){
    return 2*(this.base + this.altura);
  }
  
  public int getArea(){
    return this.base*this.altura;  
  }
  
  public int Compara(Rectangulo r1) {
    return this.getArea() - r1.getArea();
  }
  
  public boolean EsGemelo(Rectangulo r1) {
    return this.base == r1.base && this.altura == r1.altura;
    
  }
  
  public void Muestra() {
    String str ="";
    for (int i = 0; i < this.altura; i++) {
      for (int j = 0; j < this.base; j++) {
        str +="* ";
      }
     str += "\n";
    }
      System.out.println(str);
  }
  
  public boolean EsLadoCorrecto(int value) {
    return 0<value && value<=10;
    // value.getClass() == Integer 
  }

}


