
public class Cliente {
  private String nombre;
  private String apellidos;
  private String direccion;
  private String telefono;

  public Cliente(String nombre, String apellidos, String direccion, String telefono) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.direccion = direccion;
    this.telefono = telefono;
  }

  public String toString(){
    return apellidos + ", " + nombre + "; direccion: " + direccion + "; telefono: " + telefono;
  }

}
