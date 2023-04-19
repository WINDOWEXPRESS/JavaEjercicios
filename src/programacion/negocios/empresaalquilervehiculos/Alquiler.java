package negocios.empresaalquilervehiculos;


import java.time.LocalDate;

public class Alquiler extends AbstractAlquiler {

  public Alquiler(AbstractCliente cliente, AbstractVehiculoAlquiler vehiculo) {
    super(cliente, vehiculo);
  }

  @Override
  void comenzarAlquiler() {
    LocalDate date = LocalDate.now();
    super.inicioAlquiler = date;
    super.disponibilidad = false;
  }

  @Override
  void terminarAlquiler() {
    LocalDate date = LocalDate.now();
    super.finAlquiler = date;
  }

  @Override
  public Float getCosteTotal() {
    float total;
    final float DIA_0 = 1;//+1 Por que no incluye dia de alquiler
    total = (DIA_0+finAlquiler.compareTo(inicioAlquiler))* vehiculo.tarifaDiaria;
    return total;
  }

  @Override
  public String toString() {
    return this.vehiculo.matricula + "/" + this.vehiculo.fabricante + "-"
        + this.vehiculo.modelo + " -> " + this.cliente.nif + "/" + this.cliente.nombre
        + " (" + (finAlquiler == null ? "EN CURSO" : "FINALIZADO") + ") "+
            (finAlquiler != null ? "Coste total es : " +getCosteTotal() +" e": "");
  }

}
