package Inicio;

public class Tiempo {
  int horas;
  int minutos;
  int segundos;
  
  public int getHoras() {
    return horas;
  }
  public void setHoras(int horas) {
    this.horas = horas;
  }
  public int getMinutos() {
    return minutos;
  }
  public void setMinutos(int minutos) {
    this.minutos = minutos;
  }
  public int getSegundos() {
    return segundos;
  }
  public void setSegundos(int segundos) {
    this.segundos = segundos;
  }
  public Tiempo(int horas, int minutos, int segundos) {
      setHoras(horas);
      setMinutos(minutos);
      setSegundos(segundos);
     
   }
  
  int ToSegundos(){
    return this.horas*3600+this.minutos*60+this.segundos;
  }
  
  Tiempo ToHoras(int segundos) {
    return new Tiempo(segundos/3600, (segundos/60)%60, segundos%60);
  }
  
  Tiempo Suma(Tiempo t2) {
    int totalSegundos=this.ToSegundos()+t2.ToSegundos();
    Tiempo resultado= this.ToHoras(totalSegundos);
    return resultado;
  }
  
  Tiempo Resta(Tiempo t2) {
    int totalSegundos=this.ToSegundos()-t2.ToSegundos();
    Tiempo resultado= this.ToHoras(totalSegundos);
    return resultado;
  }
  
  Tiempo SumaHoras(int h) {
    return new Tiempo(this.horas+h, this.minutos, this.segundos);
  }
  
  Tiempo SumaMinutos(int m){
    int totalSegundos=this.ToSegundos()+m*60;
    Tiempo resultado= this.ToHoras(totalSegundos);
    return resultado;
  } 
 
  Tiempo SumaSegundos(int s){
    int totalSegundos=this.ToSegundos()+s;
    Tiempo resultado= this.ToHoras(totalSegundos);
    return resultado;
  } 
  
  Tiempo RestaHoras(int h) {
    return new Tiempo(this.horas-h, this.minutos, this.segundos);
  }
  
  Tiempo RestaMinutos(int m){
    int totalSegundos=this.ToSegundos()-m*60;
    Tiempo resultado= this.ToHoras(totalSegundos);
    return resultado;
  } 
 
  Tiempo RestaSegundos(int s){
    int totalSegundos=this.ToSegundos()-s;
    Tiempo resultado= this.ToHoras(totalSegundos);
    return resultado;
  } 
  
  String MuestraContenido() {
 
    return this.horas + "h " + this.minutos + "m " + this.segundos + "s";
  }
  
}
