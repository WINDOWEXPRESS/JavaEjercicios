package negocios.empresaalquilervehiculos;

import java.time.LocalDate;

public abstract class AbstractCliente {
  String nombre;
  String nif;
  LocalDate inicioAlquiler;
  
  public AbstractCliente(String nombre, String nif) {
    this.nombre = nombre;
    this.nif = nif;
  }
  //de momento no lo necesito
}
