public class Pizza {
  private String tamanio;
  private String tipo;
  private String estado;
  private static int numPizzas;
  private static int numPizzasServidas;

  public static int getNumPizzas(){
    return numPizzas;
  }

  public static int getNumPizzasServidas(){
    return numPizzasServidas;
  }

  public Pizza(String tamanio, String tipo) {
    this.tamanio = tamanio;
    this.tipo = tipo;
    this.estado = "pedida";
    Pizza.numPizzas++;
  }

  public boolean servida() {
    if(estado.equals("servida")){
      return true;
    }
    return false;
  }

  public boolean servir() {
    if(estado.equals("servida") == false){
      estado = "servida";
      Pizza.numPizzasServidas++;
      return true;
    }
    return false;
  }

  public String toString() {
    return tamanio + ", tipo " + tipo + ", " + estado;
  }
}
