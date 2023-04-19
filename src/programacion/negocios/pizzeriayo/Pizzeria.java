package negocios.pizzeriayo;

public class Pizzeria {

	// Atributos:
	private String nombre;
	private Cliente[] clientes;
	private int maxClientes;
	private int numClientes;
	private Pedido[] pedidos;
	private int maxPedidos;
	private int numPedidos;

	// M�todos:
	public Pizzeria(String nombre, int maxClientes, int maxPedidos) {
		this.nombre = nombre;
		this.clientes = new Cliente[maxClientes];
		this.pedidos = new Pedido[maxPedidos];
		this.maxClientes = maxClientes;
		this.maxPedidos = maxPedidos;
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
	public boolean addCliente() {
		if(getNumClientes()>=getMaxClientes()) {
			return false;
		}else {
			return true;
		}
		
	}

	public void addCliente(String nombre, String apellidos, String direccion, String telefono) {
		Cliente cliente = new Cliente(nombre, apellidos, direccion, telefono);
		clientes[numClientes] = cliente;
		numClientes++;
	}

	public boolean addPedido(int posicionCliente, int tamanio, int tipo) {
		
			Pedido pedido = new Pedido(clientes[posicionCliente],tamanio,tipo);
			pedidos[posicionCliente] = pedido;

		return true;
	}

	public boolean pedidoServido(int posicionPedido) {
		return true;
	}

	public boolean servirPedido(int posicionPedido) {
		return true;
	}

	public String pedidoToString(int posicionPedido) {
		return "";
	}

	public String pedidosToString() {
		String regPedido = "Pedidos realizados="+getNumPedidos()+"(max="+getMaxPedidos()+")"+"\n";
		return "";
	}

	public String clienteToString(int posicionCliente) {
		return clientes[posicionCliente].toString();
	}

	public String clientesToString() {
		String cadena = "Clientes registrados="+getNumClientes()+"(max="+getMaxClientes()+")"+"\n";;
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i]==null) {
				break;
			}else {
				cadena += (i + 1) + ") " + clientes[i];
			}
		}
		return cadena;
	}

	public String toString() {
		String cadena = "Pizzer�a " + nombre + ". Total pizzas: pedidas="+Pizza.totalPizzaPedido+", servidas="+Pizza.totalPizzaServido+"\n";
		cadena+= clientesToString();
		
		return cadena;
	}
		
}
