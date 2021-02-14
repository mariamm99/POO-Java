package Inicio;

import java.lang.Math.*;

public class Circulo {

  float radio;

  public Circulo(float radio) {
    this.radio = radio;
  }

  public float getRadio() {
    return radio;
  }

  public void setRadio(float radio) {
    this.radio = radio;
  }

  public double getArea() {
    return Math.PI * (radio * radio);
  }

  public String toString() {
    return "soy un circulo de radio " + radio + " metros. Ocupo un area de " + getArea() + " metros cuadrados";
  }

  public float aumentar(int nVeces) {
    this.radio = this.radio * nVeces;
    return this.radio;
  }
  
  public float decrecer(int nVeces) {
    this.radio = this.radio / nVeces;
    return this.radio;
  }
  
  

  

}
