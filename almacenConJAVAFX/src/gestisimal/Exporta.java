package gestisimal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exporta {
  int i;
  Scanner sc = new Scanner(System.in);

  public void exportaCsv(ArrayList<Articulo> almacen, String fichero) throws IOException {

    List<String[]> datos = new ArrayList<>();

    fichero += ".csv";
    datos.add(new String[] { "C�digo", "descripci�n", "precioCompra", "precioVenta", "stock" });

    for (Articulo articulo : almacen) {

      datos.add(new String[] { String.valueOf(articulo.getCodigo()), articulo.getDescripcion(),
          String.valueOf(articulo.getPrecioCompra()), String.valueOf(articulo.getPrecioVenta()),
          String.valueOf(articulo.getStock()) });

    }

    BufferedWriter escribir = new BufferedWriter(new FileWriter(fichero));

    for (String[] cadena : datos) {
      for (int i = 0; i < cadena.length; i++) {
        escribir.append(cadena[i] + ",");

      }
      escribir.append(System.lineSeparator());
    }
    escribir.close();

  }

  public void exportaXML(ArrayList<Articulo> almacen, String fichero) throws IOException {
    fichero += ".xml";

    List<String[]> datos = new ArrayList<>();

    BufferedWriter escribir = new BufferedWriter(new FileWriter(fichero));
    escribir.append("<xml> \n");

    for (Articulo articulo : almacen) {
      escribir.append("<Articulo> \n");
      escribir.append("<Codigo>" + String.valueOf(articulo.getCodigo()) + "</Codigo> \n");
      escribir.append("<Descripcion>" + articulo.getDescripcion() + "</Descripcion> \n");
      escribir.append("<PrecioCompra>" + String.valueOf(articulo.getPrecioCompra()) + "</PrecioCompra> \n");
      escribir.append("<PrecioVenta> " + String.valueOf(articulo.getPrecioVenta()) + "</PrecioVenta>\n");
      escribir.append("<Stock>" + String.valueOf(articulo.getStock()) + "</Stock>\n");

      escribir.append("</Articulo> \n");
    

      escribir.append(System.lineSeparator());
    }
    
    escribir.append("</xml> ");
    escribir.close();

  }

  public void exportaJson(ArrayList<Articulo> almacen, String fichero) throws IOException {
    List<String[]> datos = new ArrayList<>();
    fichero += ".json";

    for (Articulo articulo : almacen) {
      datos.add(new String[] { "Codigo", String.valueOf(articulo.getCodigo()), "Descripcion ",
          articulo.getDescripcion(), "PrecioCompra", String.valueOf(articulo.getPrecioCompra()), "PrecioVenta",
          String.valueOf(articulo.getPrecioVenta()), "Stock", String.valueOf(articulo.getStock()) });
    }

    BufferedWriter escribir = new BufferedWriter(new FileWriter(fichero));

    for (String[] cadena : datos) {
      escribir.append("{");
      for (int i = 0; i < cadena.length; i++) {
        escribir.append("'" + cadena[i] + "'");
        if (i % 2 == 0) {
          escribir.append(":");
        } else if (i % 2 != 0 && i < (cadena.length - 3)) {
          escribir.append(",");
        }
      }
      escribir.append("}");
    }
    escribir.close();

  }


}
