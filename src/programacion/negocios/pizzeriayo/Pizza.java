package negocios.pizzeriayo;

public class Pizza {
	static int totalPizzaPedido ;
	static int totalPizzaServido ;
	private static final String[] TAMANIO = {"Mediana","Familiar"};
	private static final String[] TIPO = {"Margarita","Cuatro quesos","Funghi"};
	private static final String[] ESTADO = {"Pedida ","Servida"};
	private String tamanioPizza ;
	private String tipoPizza ;
	private String estadoPizza ;
	
	public static int getTotalPizzaPedido() {
		return totalPizzaPedido;
	}

	public static int getTotalPizzaServido() {
		return totalPizzaServido;
	}

	public Pizza(int tamanioPizza, int tipoPizza) {
		this.tamanioPizza = TAMANIO[tamanioPizza];
		this.tipoPizza = TIPO[tipoPizza];
		//this.estadoPizza = ESTADO[estadoPizza];
	}
	
	
}
