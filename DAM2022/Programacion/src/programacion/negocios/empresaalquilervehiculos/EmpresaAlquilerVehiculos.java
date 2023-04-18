package negocios.empresaalquilervehiculos;

public class EmpresaAlquilerVehiculos extends AbstractEmpresaAlquilerVehiculos
    implements InterfazEmpresaAlquilerVehiculos {

  public EmpresaAlquilerVehiculos(String nombre, String nif) {
    super(nombre, nif);
  }
  @Override
  public boolean registrarCliente(AbstractCliente cliente) {
      //Recorrer la lista con un for each para ver si hay cliente ya guardado
      for (AbstractCliente client : clientes) {
          //Tener NIF como PK entonces compara NIF de los dos Objetos
          if(client.nif.equals(cliente.nif) ){
              return false;
          }
      }
    //  super.clientes.add(cliente);      no hace falta super por que clientes aqui es unico  y como add devuelve un boolean  lo puede hace directo con return 
    //return true;
    return clientes.add(cliente);
  }
  @Override
  public boolean registrarVehiculo(AbstractVehiculoAlquiler vehiculo) {
      //Recorrer la lista con un for each para ver si hay mismo vehiculo
      for (AbstractVehiculoAlquiler vehicul : vehiculos) {
          //Tener matricula como PK entonces compara matricula de los dos Objetos
          if(vehicul.matricula.equals(vehiculo.matricula) ){
              return false;
          }
      }
      //super.vehiculos.add(vehiculo);
      return vehiculos.add(vehiculo);
  }
  @Override
  public boolean alquilarVehiculo(AbstractCliente cliente, AbstractVehiculoAlquiler vehiculo) {
      AbstractAlquiler alquiler = new Alquiler(cliente, vehiculo);
      //Comproba si puede alquila el mismo coche cuando ya esta en alquiler.
      for (AbstractAlquiler alqui : alquileres) {
          //Tener matricula como PK entonces compara matricula de los dos Objetos
          //y si no esta disponible no se alquila.
          if(alqui.vehiculo.matricula.equals(vehiculo.matricula ) && !alqui.disponibilidad ){
              System.out.println("Vehiculo Indisponible.");
              return false;
          }
      }
      //Guardar en una ArrayList
      //super.alquileres.add(alquiler);
      alquiler.comenzarAlquiler();
      return alquileres.add(alquiler);
  }

  @Override
  public boolean devolverVehiculo(AbstractVehiculoAlquiler vehiculo) {
      for (AbstractAlquiler alquiler : alquileres) {
          if(alquiler.vehiculo == vehiculo){
              alquiler.terminarAlquiler();
              alquiler.disponibilidad = true;
          }
      }
    return false;
  }


  @Override
  public String listadoAlquileres() {
    String cadena = "";
    int i = 1;
    for (AbstractAlquiler alquiler : alquileres) {
      cadena += "\n" + i + ") " + alquiler;
      i++;
    }
    return cadena;
  }

  @Override
  public String listadoClientes() {
    String cadena = "";
    int i = 1;
    for (AbstractCliente cliente : clientes) {
      cadena += "\n" + i + ") " + cliente;
      i++;
    }
    return cadena;
  }

  @Override
  public String listadoVehiculos() {
    String cadena = "";
    int i = 1;
    for (AbstractVehiculoAlquiler vehiculoAlquiler : vehiculos) {
      cadena += "\n" + i + ") " + vehiculoAlquiler;
      i++;
    }
    return cadena;
  }

  @Override
  public String toString() {
    //siendo final mayuscula todo
    final int NUMBER_SPECIAL_CHARS = 5;
    String cadena = "#".repeat(2 * NUMBER_SPECIAL_CHARS) + " Empresa Alquiler de Vehículos '"
            + nombre + "' (" + nif + ") " + "#".repeat(2 * NUMBER_SPECIAL_CHARS);

    cadena += "\n" + "=".repeat(NUMBER_SPECIAL_CHARS) + "> Vehiculos (" + vehiculos.size() + "):";
    cadena += listadoVehiculos();

    cadena += "\n" + "=".repeat(NUMBER_SPECIAL_CHARS) + "> Clientes (" + clientes.size() + "):";
    cadena += listadoClientes();

    cadena += "\n" + "=".repeat(NUMBER_SPECIAL_CHARS) + "> Alquileres (" + alquileres.size() + "):";
    cadena += listadoAlquileres();

    return cadena;
  }
}
