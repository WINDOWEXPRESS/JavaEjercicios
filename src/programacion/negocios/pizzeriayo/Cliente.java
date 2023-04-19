package negocios.pizzeriayo;

public class Cliente {
	static int numCliente ;
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
	public String toString() {
		return String.format("Nombre:%-15s;Apellido:%-15s;Direccion:%-15s;Telefono:%-15s\n",nombre,apellidos,direccion,telefono);
	}
}
