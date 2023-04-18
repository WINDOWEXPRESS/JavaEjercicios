package negocios.pizzeriayo;
import java.util.Scanner;

public class MainPizzeria {

	public static void main(String[] args) {
		// Declarar variables locales
		String nombre;
		int maxClientes = 0;
		int maxPedidos = 0;
		short opc = 0;
		// Crear instancia de la clase Scanner
		Scanner dato = new Scanner(System.in);
		//Capturar datos para crear instancia de la clase Pizzeria
		do {
			System.out.println("Introduce el nombre de la pizzeria (no puede estar vacio):");
			nombre = dato.nextLine();
		}while(nombre.isEmpty());
		
		while(maxClientes>10 || maxClientes<2) {
			System.out.println("Introduce el numero de clientes permitidos (minimo 2, maximo 10):");
			maxClientes = dato.nextInt();
		}
		while(maxPedidos>20 || maxPedidos<2) {
			System.out.println("Introduce el numero de pedidos permitidos (minimo 2, maximo 20): ");
			maxPedidos = dato.nextInt();
		}
		//Crear instancia de la clase Pizzeria
		Pizzeria pizzeria = new Pizzeria(nombre,maxClientes,maxPedidos);
		while (opc != 5) {
			opc = 0;
			menu();
			while(opc <1 || opc >5) {
				System.out.println("Elige la opcion deseada:");
				opc = dato.nextShort();
				if (opc <1 || opc >5) {
					System.out.println("Opcion invalido vuelve introducirlo.");
				}
			}
			System.out.println("Opcion:"+opc);
			switch (opc) {
			case 1:
				System.out.println("Imprimir Detalles Pizzeria:");
				System.out.println(pizzeria);
				break;
			case 2:
				System.out.println("Añadir Cliente:");
				if (/*pizzeria.addCliente()*/1+1>2) {
					String nombreCliente; 
					String apellidosCliente;
					String direccionCliente;
					String telefonoCliente;
					//Limpiar buffer de Scanner
					dato.nextLine();
					//Capturar datos
					System.out.println("Introduce el nombre del cliente: ");
					nombreCliente = dato.nextLine();
					System.out.println("Introduce los apellidos del cliente: ");
					apellidosCliente = dato.nextLine();
					System.out.println("Introduce la direccion del cliente: ");
					direccionCliente = dato.nextLine();
					System.out.println("Introduce el tel�fono del cliente: ");
					telefonoCliente = dato.nextLine();
					//A�adir cliente 
					pizzeria.addCliente(nombreCliente, apellidosCliente, direccionCliente, telefonoCliente);
					System.out.println("        OK: Cliente añadido correctamente.");
				}else {
					System.out.println("Error: Ya se ha alcanzado el maximo numero de clientes (" + pizzeria.getMaxClientes() + "), no se pueden añadir mas.");
				}
				break;
			case 3:
				//Crear variables locales
				int nCliente = 0 ;
				int tamanioPizza = 0;
				int tipoPizza = 0;
				System.out.println("A�adir pedido:");
				if(pizzeria.getNumClientes()<1) {
					System.out.println(     "Error: No hay ningun cliente registrado. Necesitas añadir un cliente antes de poder crear un pedido.");
					break;
				}
				//Visualizar datos de los clientes
				System.out.println(pizzeria.clientesToString());
				//Seleccionar cliente
				while(nCliente<1 || nCliente>pizzeria.getNumClientes()){
					System.out.print("Introduce el numero de cliente que hace el pedido (1-"+pizzeria.getNumClientes()+"):");
					nCliente = dato.nextShort();
				}
				System.out.println("Seleccionado el cliente "+nCliente+": "+pizzeria.clienteToString(nCliente-1));
				while(tamanioPizza<1 || tamanioPizza>2){
					System.out.print("Introduce el tamaño de la pizza usando el numero (1=Mediana, 2=Familiar): ");
					tamanioPizza= dato.nextInt();
				}
				System.out.println("Seleccionado el n�mero "+tamanioPizza+" para el tamaño de la pizza");
				while(tipoPizza<1|| tipoPizza>3) {
					System.out.println("Introduce el tipo de pizza usando el numero (1=margarita, 2=cuatro quesos o 3=funghi):");
					tipoPizza = dato.nextInt();
				}
				System.out.println("Seleccionado el numero "+tipoPizza+" para el tipo de pizza");
				
				System.out.println("Pedido guardado en posicion "+pizzeria.getNumPedidos()+". Pedido:cliente="+pizzeria.clienteToString(nCliente));
				break;
			default:
				break;
			}
		}

	}

	private static void menu() {
		System.out.println("==> Men� pizzer�a:");
		System.out.println("1->Imprimir detalles pizzer�a" );
		System.out.println("2->A�adir cliente");
		System.out.println("3->Crear pedido" );
		System.out.println("4->Servir pedido");
		System.out.println("5->Salir");
	}

}