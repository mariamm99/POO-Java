package Inicio;

public class Fecha {

  String fecha;
  private int dia;
  private int mes;
  private int anyo;

  /**
   * Creamos el constructr Fecha
   */

  public Fecha(String fecha) {
    this.fecha = fecha;
    if (fecha.matches("[0-9]{8}")) {

      int fechaInt = Integer.parseInt(fecha);
      this.dia = fechaInt % 100;
      this.mes = fechaInt / 100 % 100;
      this.anyo = fechaInt / 10000;
    } else {
      this.dia = 0;
      this.mes = 0;
      this.anyo = 0;

    }

  }

  /**
   * Get y setter de Fecha
   */

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  /**
   * Método que permite pasar la fecha a cadena String
   */

  public String fecha(int d, int m, int a) {
    String dia = Integer.toString(d).trim();
    String mes = Integer.toString(m).trim();
    String anyo = Integer.toString(a).trim();

    if (dia.length() < 2) {
      dia = "0" + dia;
    }

    if (mes.length() < 2) {
      mes = "0" + mes;
    }

    for (int i = anyo.length(); i < 4; i++) {
      anyo = "0" + anyo;
    }
    return anyo + mes + dia;
  }

  /**
   * Método para pasar la Fecha a Cadena de texto adecuada para mostrarlo por
   * pantalla.
   */

  public String fechaFormateada() {

    String mess = nombreMes();

    String fechaLetra = "";
    fechaLetra += dia + " de " + mess + " de " + anyo;

    return fechaLetra;
  }

  /**
   * Pasamos el mes a nombre con un switch.
   */
  public String nombreMes() {

    String mesLetra = "";

    switch (mes) {
    case 1:
      mesLetra = "enero";
      break;
    case 2:
      mesLetra = "febrero";
      break;
    case 3:
      mesLetra = "marzo";
      break;
    case 4:
      mesLetra = "abril";
      break;
    case 5:
      mesLetra = "mayo";
      break;
    case 6:
      mesLetra = "Junio";
      break;
    case 7:
      mesLetra = "Julio";
      break;
    case 8:
      mesLetra = "Agosto";
      break;
    case 9:
      mesLetra = "Septiembre";
      break;
    case 10:
      mesLetra = "octubre";
      break;
    case 11:
      mesLetra = "noviembre";
      break;
    case 12:
      mesLetra = "diciembre";
      break;
    default:
      mesLetra = "mes erroneo";
      break;
    }
    return mesLetra;
  }

  /**
   * Método para ver si el año es bisiesto
   */
  boolean esBisiesto() {
    boolean bisiesto = false;

    if ((anyo % 100 != 0 || anyo % 400 == 0) && anyo % 4 == 0) {
      bisiesto = true;
    }
    return bisiesto;
  }

  /**
   * Método para ver si la fecha es correcta Return boolean
   */
  boolean fechaCorrecta() {

    boolean fechaCorrecta = true;

    if (!fecha.matches("[0-9]{8}")) {
      return false;
    }

    if (mes < 0 && mes > 12) {
      return false;
    }

    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
      if (dia < 0 || dia > 31) {
        fechaCorrecta = false;
      }
    } else if (mes == 2) {
      if (esBisiesto()) {
        if (dia < 0 || dia > 29) {
          fechaCorrecta = false;
        }
      } else {
        if (dia < 0 || dia > 28) {
          fechaCorrecta = false;
        }
      }

    } else {
      if (dia < 0 || dia > 30) {
        fechaCorrecta = false;
      }
    }

    return fechaCorrecta;

  }

  /**
   * Método para restar 1 día
   **/
  public String fechaMas1Dia() {

    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10) {
      if (dia == 31) {
        mes++;
        dia = 1;
      } else {

        dia++;
      }
    } else if (mes == 2) {
      if (esBisiesto()) {
        if (dia == 29) {
          mes++;
          dia = 1;
        } else {
          dia++;
        }
      } else {
        if (dia == 28) {
          mes++;
          dia = 1;
        } else {
          dia++;
        }
      }

    } else if (mes == 12) {
      if (dia == 31) {
        anyo++;
        mes = 1;
        dia = 1;
      } else {

        dia++;
      }

    } else {
      if (dia == 30) {
        dia++;
      } else {
        mes++;
        dia = 1;
      }
    }

    Fecha fechaLetra = new Fecha(fecha(dia, mes, anyo));

    return fechaLetra.fechaFormateada();
  }

  /**
   * Método para sumar los días pasados como variable
   **/
  public String fechaMasNDias(int dias) {
    for (int i = 0; i < dias; i++) {
      if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10) {
        if (dia == 31) {
          mes++;
          dia = 1;
        } else {

          dia++;
        }
      } else if (mes == 2) {
        if (esBisiesto()) {
          if (dia == 29) {
            mes++;
            dia = 1;
          } else {
            dia++;
          }
        } else {
          if (dia == 28) {
            mes++;
            dia = 1;
          } else {
            dia++;
          }
        }

      } else if (mes == 12) {
        if (dia == 31) {
          anyo++;
          mes = 1;
          dia = 1;
        } else {

          dia++;
        }

      } else {
        if (dia == 30) {
          mes++;
          dia = 1;
        } else {
          dia++;
        }
      }
    }
    Fecha fechaLetra = new Fecha(fecha(dia, mes, anyo));

    return fechaLetra.fechaFormateada();

  }

  public String fechaMenos1Dia() {

    if (dia == 1) {
      mes--;
      if (mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
        dia = 31;

      } else if (mes == 2) {
        if (esBisiesto()) {
          dia = 29;
        } else {
          dia = 28;
        }
      } else if (mes == 1) {
        if (dia == 1) {
          anyo--;
          mes = 12;
          dia = 31;
        } else {
          dia--;
        }
      } else {
        dia = 30;
      }
    } else {
      dia--;
    }

    Fecha fechaLetra = new Fecha(fecha(dia, mes, anyo));

    return fechaLetra.fechaFormateada();
  }

  public String fechaMenosNDias(int dias) {

    for (int i = 0; i < dias; i++) {
      if (dia == 1) {
        mes--;
        if (mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
          dia = 31;

        } else if (mes == 2) {
          if (esBisiesto()) {
            dia = 29;
          } else {
            dia = 28;
          }
        } else if (mes == 1) {
          if (dia == 1) {
            anyo--;
            mes = 12;
            dia = 31;
          } else {

            dia--;
          }
        } else {
          dia = 30;
        }
      } else {
        dia--;
      }
    }

    Fecha fechaLetra = new Fecha(fecha(dia, mes, anyo));

    return fechaLetra.fechaFormateada();
  }

  /**
   * Método para comparar dos fechas
   **/

  public int comparaFechas(Fecha fecha2) {
    if (this.anyo < fecha2.anyo) {
      return -1;
    } else if (this.anyo > fecha2.anyo) {
      return 1;
    } else {
      if (this.mes < fecha2.mes) {
        return -1;
      } else if (this.mes > fecha2.mes) {
        return 1;
      } else {
        if (this.dia < fecha2.dia) {
          return -1;
        } else if (this.dia > fecha2.dia) {
          return 1;
        } else {
          return 0;

        }
      }
    }
  }
}
