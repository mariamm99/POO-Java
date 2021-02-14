package Inicio;

import java.util.Scanner;

/**
 * Prueba funciones de Fecha.java.
 *
 * @author rafa
 *
 */

public class TestFecha {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    // Testeamos funciones fecha correcta
    String[] fechas = { "20191215", // correcto
        "20181111", // correcto
        "dfdfdw", // incorrecto
        "AAAAMMDD", // incorrecto
        "20181242", // incorrecto (diciembre no tiene 42 días)
        "20010229", // incorrecto (no es bisiesto)
        "20000229" // correcto (fue bisiesto)
    };
    for (String f : fechas) {
      System.out.print("La fecha " + f + " tiene un formato ");
      Fecha f1 = new Fecha(f);
      if (f1.fechaCorrecta()) {
        System.out.println("CORRECTO");
      } else {
        System.out.println("INCORRECTO");
      }
    }
    System.out.println();

    // Testeamos suma y resta de días
    Fecha fecha1 = new Fecha("20160228");
    Fecha fecha2 = new Fecha("20160301");
    Fecha fecha3 = new Fecha("20170228");
    Fecha fecha4 = new Fecha("20170301");
    System.out.println("Si sumamos un día a '" + fecha1.fechaFormateada() + "' obtenemos: " + fecha1.fechaMas1Dia());
    System.out.println("Si restamos un día a '" + fecha1.fechaFormateada() + "' obtenemos: " + fecha1.fechaMenos1Dia());
    System.out.println("Si sumamos un día a '" + fecha3.fechaFormateada() + "' obtenemos: " + fecha3.fechaMas1Dia());
    System.out.println("Si restamos un día a '" + fecha4.fechaFormateada() + "' obtenemos: " + fecha4.fechaMenos1Dia());
    System.out.println();

    System.out.print("¿Cuantos días quieres sumar a " + fecha1.fechaFormateada() + "? ");
    int suma = s.nextInt();
    System.out.println("La fecha resultante es " + fecha1.fechaMasNDias(suma));
    System.out.println();

    System.out.print("¿Cuantos días quieres restar a " + fecha1.fechaFormateada() + "? ");
    int resta = s.nextInt();
    System.out.println("La fecha resultante es " + fecha1.fechaMenosNDias(resta));
    System.out.println();

    // Testeamos comparaciones de fechas
    fecha2 = new Fecha("20160120");
    fecha3 = new Fecha("20190101");
    System.out.println("El resultado de comparar '" + fecha1.fechaFormateada() + "' con '" + fecha2.fechaFormateada()
        + "' es " + fecha1.comparaFechas(fecha2));
    System.out.println("El resultado de comparar '" + fecha1.fechaFormateada() + "' con '" + fecha3.fechaFormateada()
        + "' es " + fecha1.comparaFechas(fecha3));
    System.out.println("El resultado de comparar '" + fecha3.fechaFormateada() + "' con '" + fecha2.fechaFormateada()
        + "' es " + fecha3.comparaFechas(fecha2));
    System.out.println("El resultado de comparar '" + fecha3.fechaFormateada() + "' con '" + fecha3.fechaFormateada()
        + "' es " + fecha3.comparaFechas(fecha3));
  }

}
