public class Pedido {
  private Cliente cliente;
  private Pizza pizza;

  public Pedido(Cliente cliente, String tamanio, String tipo){
    Pizza pizza = new Pizza(tamanio, tipo);
    this.cliente = cliente;
    this.pizza = pizza;
  }

  public boolean servido() {
    if(pizza == null){
      System.out.println("Error: La pizza es null!! Pedido: " + toString());
      return false;
    }
    if (pizza.servida()){
      return true;
    }
    return false;
  }


  public boolean servir(){
    if(pizza == null){
      System.out.println("Error: La pizza es null!! Pedido: " + toString());
      return false;
    }
    return pizza.servir();
  }

  public String toString(){
    return "cliente=[" + cliente + "], pizza=[" + pizza + "]";
  }
  
  
}
