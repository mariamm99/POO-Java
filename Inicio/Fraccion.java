package Inicio;

public class Fraccion {
  private double numerador;
  private double denominador;

  public Fraccion(double numerador, double denominador) {
    this.numerador = numerador;
    setDenominador(denominador);
  }

  public double getNumerador() {
    return numerador;
  }

  public void setNumerador(double numerador) {
    this.numerador = numerador;
  }

  public double getDenominador(double value) {
    return denominador;
  }

  public void setDenominador(double denominator) {
    if (EsCorrecto(denominator)) {
      this.denominador = denominator;
    }else {
      System.out.println("denominador no puede ser 0");
    }
  }

  /**
   * Método para comprobar  que el donominador no sea 0
   **/
  public boolean EsCorrecto(double value) {
      return value!=0;
    }

  /**
   * Muestra el la fracción como cadena de caracteres
   **/
  public void cadenaCaracteres() {
    System.out.println(this.numerador + "/" + this.denominador);
  }

  /**
   * Muestra el resultado de la fracción
   * */
  double resultado() {

    return this.numerador / this.denominador;
  }

  /**
   *Método para multiplicar la fracción por un número
   **/
  double multiplicacion(int nMultiplicar) {
    return this.numerador * nMultiplicar / this.denominador;
  }
  
  /**
   * Método para multiplicar dos fracciones
   **/
  
  String multiplicarFraccion(Fraccion f2) {
    double resultadoNum = this.numerador * f2.numerador;
    double resultadoDen = this.denominador * f2.denominador;
    return resultadoNum + "/" + resultadoDen;
  }

  /**
   * Suma dos fracciones
   * */
  double sumaFraccion(Fraccion f2) {
    return this.numerador / this.denominador + f2.numerador / f2.denominador;
  }

  /**
   * Resta dos fracciones
   * */
  double restaFraccion(Fraccion f2) {
    return this.numerador / this.denominador - f2.numerador / f2.denominador;
  }

  /**
   * Simplifica la fración
   * */
  Fraccion simplificar() {
    double num = this.numerador;
    double den = this.denominador;
    for (int i = 11; i > 0; i--) {
      if (num % i == 0.0 && den % i == 0.0) {
        num = num / i;
        den = den / i;
      }
    }
    return new Fraccion(num, den);
  }

  /**
   * Muestra la fración
   **/
  String muestra() {
    return this.numerador + " / " + this.denominador;
  }

}
