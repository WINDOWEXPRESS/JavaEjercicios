
public class Pizzeria {
  private String nombre;
  private Cliente[] clientes;
  private int maxClientes;
  private int numClientes;
  private Pedido[] pedidos;
  private int maxPedidos;
  private int numPedidos;

  public Pizzeria(String nombre, int maxClientes, int maxPedidos) {
    this.nombre = nombre;
    this.clientes = new Cliente[maxClientes];
    this.pedidos = new Pedido[maxPedidos];
    this.maxClientes = maxClientes;
    this.maxPedidos = maxPedidos;

    // Estas inicializaciones no hacen falta, se hacen por defecto:
    this.numClientes = 0;
    this.numPedidos = 0;
  }

  public int getNumClientes() {
    return numClientes;
  }

  public int getMaxClientes() {
    return maxClientes;
  }

  public int getNumPedidos() {
    return numPedidos;
  }

  public int getMaxPedidos() {
    return maxPedidos;
  }
  
/*
   // Al final estos métodos no hacen falta:
  
   public Cliente getCliente(int posicionCliente){
    if(posicionCliente<0 || posicionCliente>= numClientes) {
      return null;
    }
    return clientes[posicionCliente];
  }

  public Pedido getPedido(int posicionPedido){
    if(posicionPedido<0 || posicionPedido>= numPedidos) {
      return null;
    }
    return pedidos[posicionPedido];
  } 
*/

  public boolean addCliente(String nombre, String apellidos, String direccion, String telefono) {
    if (numClientes < maxClientes) {
      Cliente cliente = new Cliente(nombre, apellidos, direccion, telefono);
      clientes[numClientes] = cliente;
      numClientes++;
      return true;
    } else {
      return false;
    }
  }

  public boolean addPedido(int posicionCliente, String tamanio, String tipo) {
    if (numPedidos >= maxPedidos) {
      System.out.println("Error: Número máximo de pedidos (" + numPedidos + ") alcanzado");
      return false;
    }

    if (posicionCliente >= numClientes) {
      System.out.println("Error: El cliente con posición " + posicionCliente
          + " no es válido, tenemos " + numClientes + " clientes registrados");
      return false;
    }

    Cliente cliente = clientes[posicionCliente];
    Pedido pedido = new Pedido(cliente, tamanio, tipo);
    pedidos[numPedidos] = pedido;
    System.out.println("Pedido guardado en posición " + numPedidos + ". Pedido: " + pedido);
    numPedidos++;

    return true;
  }

  public boolean pedidoServido(int posicionPedido) {
    if (posicionPedido >= numPedidos) {
      System.out.println("Error: El pedido con posición " + posicionPedido
          + " no es válido, tenemos " + numPedidos + " pedidos en total");
      return false;
    }
    return pedidos[posicionPedido].servido();
  }

  public boolean servirPedido(int posicionPedido) {
    if (posicionPedido >= numPedidos) {
      System.out.println("Error: El pedido con posición " + posicionPedido
          + " no es válido, tenemos " + numPedidos + " pedidos en total");
      return false;
    }
    Pedido referenciaPedido = pedidos[posicionPedido];
    return referenciaPedido.servir();
  }

  public String pedidoToString(int posicionPedido) {
    if(posicionPedido < 0 || posicionPedido >= numPedidos) {
      return "Pedido " + posicionPedido + " no encontrado";
    }
    return pedidos[posicionPedido].toString();
  }

  public String pedidosToString() {
    String cadena;
    cadena = "\nPedidos realizados=" + numPedidos + "(max=" + maxPedidos + ")";
    for (int i = 0; i < numPedidos; i++) {
      cadena += "\n" + (i + 1) + ") " + pedidos[i];
    }
    return cadena;
  }

  public String clienteToString(int posicionCliente) {
    if(posicionCliente < 0 || posicionCliente >= numClientes) {
      return "Cliente " + posicionCliente + " no encontrado";
    }
    return clientes[posicionCliente].toString();
  }

  public String clientesToString() {
    String cadena;
    cadena = "\nClientes registrados=" + numClientes + "(max=" + maxClientes + ")";
    for (int i = 0; i < numClientes; i++) {
      cadena += "\n" + (i + 1) + ") " + clientes[i];
    }
    return cadena;
  }

  public String toString() {
    String cadena = "Pizzería '" + nombre + "'. Total pizzas: pedidas=" + Pizza.getNumPizzas()
        + ", servidas=" + Pizza.getNumPizzasServidas();
    cadena += clientesToString();
    cadena += pedidosToString();
    return cadena;
  }
}
