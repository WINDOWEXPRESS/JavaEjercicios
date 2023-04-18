package negocios.pizzeriayo;

public class Pedido {
	private Cliente cliente;
	private Pizza pizza;
	
	public Pedido(Cliente cliente, int tamanio,int tipo) {
		this.cliente = cliente;
		Pizza pizza = new Pizza(tamanio, tipo);
	}
	
}
