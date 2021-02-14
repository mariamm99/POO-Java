package gestisimal;

public class Articulo {

  private static int autoCodigo = 1;
  private int codigo;
  private String descripcion;
  private float precioCompra;
  private float precioVenta;
  private int stock;

  /**
   * Constructor de artículo
   * 
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @throws ExistenciasNegativasException 
   * @throws PrecioNegativoException 
   */
  public Articulo( String descripcion,  float precioCompra,  float precioVenta,  int stock) throws ExistenciasNegativasException, PrecioNegativoException {
    
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setStock(stock);
    setCodigo();
  
  }


  public String getDescripcion() {
    return descripcion;
  }


  private void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }


  public float getPrecioCompra() {
    return precioCompra;
  }


  private void setPrecioCompra(float precioCompra) throws PrecioNegativoException {
    if (precioCompra<=0) {
      throw new PrecioNegativoException("El precio no puede ser 0 o menor de 0");
    }
    this.precioCompra = precioCompra;
  }


  public float getPrecioVenta() {
    return precioVenta;
  }


  private void setPrecioVenta(float precioVenta) throws PrecioNegativoException{
    if (precioVenta<=0) {
      throw new PrecioNegativoException("El precio no puede ser 0 o menor de 0");      
    }
    this.precioVenta = precioVenta;
  }


  /**
   * Incremento del código del articulo cada vez que se crea uno nuevo
   */
  private void setCodigo() {
    this.codigo = Articulo.autoCodigo++;

  }

  public Articulo( int codigo) {
    this.codigo = codigo;
  }


  public int getStock() {
    return stock;
  }


  public void setStock(int stock) throws ExistenciasNegativasException{
    if (stock < 0) //cláusula guarda
      throw new ExistenciasNegativasException("Las existencias no pueden ser negativas");
      this.stock = stock;
}


  public String toString() {
    String cadena;
    cadena = " \n Codigo: " + this.codigo + "\nDescripción: " + this.descripcion + "\nPrecio de compra: "
        + this.precioCompra + "\nPrecio de Venta: " + this.precioVenta + "\nStock: " + this.stock;

    return cadena;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
    return result;
  }

  /**
   * Para comparar árticulos si son iguales.
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }

  public void set(Articulo articulo) throws PrecioNegativoException, ExistenciasNegativasException {
    setDescripcion(articulo.getDescripcion());
    setPrecioCompra(articulo.getPrecioCompra());
    setPrecioVenta(articulo.getPrecioVenta());
    setStock(articulo.getStock());
  }

  
  public void incrementaStock(int mas) throws ExistenciasNegativasException {   
    setStock(getStock()+mas);
  }
  
  public void decrementaStock(int menos) throws ExistenciasNegativasException {   
    setStock(getStock()-menos);
  }


  public int getCodigo() {

    return this.codigo;
  }
  
}
