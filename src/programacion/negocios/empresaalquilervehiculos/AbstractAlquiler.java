package negocios.empresaalquilervehiculos;

import java.time.LocalDate;
import java.util.Date;

abstract class AbstractAlquiler {
  AbstractCliente cliente;
  AbstractVehiculoAlquiler vehiculo;
  //He cambiado el tipo Date por LocalDate ya que Date esta obsoleto
  LocalDate inicioAlquiler;
  LocalDate finAlquiler;
  Float costeTotal;
  boolean disponibilidad;

  public AbstractAlquiler(AbstractCliente cliente, AbstractVehiculoAlquiler vehiculo) {
    this.cliente = cliente;
    this.vehiculo = vehiculo;
  }

  abstract void comenzarAlquiler();
  abstract void terminarAlquiler();
  //public abstract boolean calcularCosteTotal();
  public abstract Float getCosteTotal();


  @Override
  public abstract String toString();
}