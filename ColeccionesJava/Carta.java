package ColeccionesJava;

import java.util.Collections;

public class Carta  {
  private static String[] n = { "as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo", "rey" };
  private static String[] p = { "bastos", "copas", "espadas", "oros" };
  private String numero;
  private String palo;

  public Carta() {
    this.numero = n[(int) (Math.random() * 10)];
    this.palo = p[(int) (Math.random() * 4)];
  }

  public String getNumero() {
    return numero;
  }

  public String getPalo() {
    return palo;
  }

  @Override
  public String toString() {
    return this.numero + " de " + this.palo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((numero == null) ? 0 : numero.hashCode());
    result = prime * result + ((palo == null) ? 0 : palo.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Carta other = (Carta) obj;
    if (numero == null) {
      if (other.numero != null)
        return false;
    } else if (!numero.equals(other.numero))
      return false;
    if (palo == null) {
      if (other.palo != null)
        return false;
    } else if (!palo.equals(other.palo))
      return false;
    return true;
  }

}
