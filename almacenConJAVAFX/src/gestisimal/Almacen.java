package gestisimal;

/**
 * @author María Moreno
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Almacen implements Iterable<Articulo>{

  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();

  /**
   * añado datos al inicio del programa.
   * 
   * @throws ExistenciasNegativasException
   * @throws PrecioNegativoException
   */
  public void anadir() throws ExistenciasNegativasException, PrecioNegativoException {
    almacen.add(new Articulo("camiseta", 3, 4, 5));
    almacen.add(new Articulo("pantalón", 4, 7, 2));
  }
  
  

  /**
   * 
   * @param descripción del producto
   * @param pCompra     -- precio de Compra del producto
   * @param pVenta      -- precio de venta del producto
   * @param stock       -- cantidad de producto que hay
   * @throws ExistenciasNegativasException
   * @throws PrecioNegativoException
   */
  public void alta(String descripcion, float pCompra, float pVenta, int stock)
      throws ExistenciasNegativasException, PrecioNegativoException {

    almacen.add(new Articulo(descripcion, pCompra, pVenta, stock));

  }

  /**
   * 
   * @param cod
   * @return true o false
   */
  public boolean baja(int cod) {

    return almacen.remove(new Articulo(cod));
  }

  /**
   * Incrementa el stock del artículo del almacén
   * 
   * @param cod código del artículo
   * @param mas cantidad que aumenta el stock
   * @throws Exception Codigo no existe y excepción existencias negativas
   */
  public void masMercancia(int cod, int mas) throws ExistenciasNegativasException {
    get(cod).incrementaStock(mas);
  }

  /**
   * 
   * @param cod   código del producto
   * @param menos cantidad que disminuye el stock
   * @throws ExistenciasNegativasException
   */

  public void menosMercancia(int cod, int menos) throws ExistenciasNegativasException {
    get(cod).decrementaStock(menos);

  }

  /**
   * 
   * @param cod
   * @return
   * @throws CodigoNoExisteException
   */
  public Articulo get(int cod) {
    if(almacen.indexOf(new Articulo(cod)) != 0){
      throw new CodigoNoExisteException("El codigo indicado no existe");
    }
    return almacen.get(almacen.indexOf(new Articulo(cod)));

  }


  /**
   * muestra todos los articulos del almacen
   */
  @Override
  public String toString() {
    return "Almacen: \n  " + almacen;
  }



  @Override
  public Iterator<Articulo> iterator() {
    // TODO Auto-generated method stub
    return almacen.iterator();
  }


}
