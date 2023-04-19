
import java.util.Scanner;

public class MainPizzeria {
  public static void main(String[] args) {
    Scanner scan_in = new Scanner(System.in);
    System.out.println("\n===> MainPizzeria\n");
    String nombrePizzeria;
    int numeroAuxiliar1, numeroAuxiliar2;

    do {
      System.out.print("Introduce el nombre de la pizzería (no puede estar vacío): ");
      nombrePizzeria = scan_in.nextLine();
    } while (nombrePizzeria.isEmpty());

    do {
      System.out.print("Introduce el número de clientes permitidos (mínimo 2, máximo 10): ");
      numeroAuxiliar1 = scan_in.nextInt();
      scan_in.nextLine();
    } while (numeroAuxiliar1 < 2 || numeroAuxiliar1 > 10);

    do {
      System.out.print("Introduce el número de pedidos permitidos (mínimo 2, máximo 20): ");
      numeroAuxiliar2 = scan_in.nextInt();
      scan_in.nextLine();
    } while (numeroAuxiliar2 < 2 || numeroAuxiliar2 > 20);

    Pizzeria telePizza = new Pizzeria(nombrePizzeria, numeroAuxiliar1, numeroAuxiliar2);

    int opcionMenu = 0;
    do {
      System.out.print("==> Menú pizzería:\n\t1->Imprimir detalles pizzería\n\t2->Añadir cliente\n"
          + "\t3->Crear pedido\n\t4->Servir pedido\n\t5->Salir\n"
          + "Elige la opción deseada:");
      opcionMenu = scan_in.nextInt();
      scan_in.nextLine();
      switch (opcionMenu) {
        case 1:
          System.out.println("Opción 1: Imprimir Detalles Pizzería:");
          System.out.println(telePizza);
          System.out.println();
          break;

        case 2:
          System.out.println("Opción 2: Añadir cliente:");
          if (telePizza.getNumClientes() >= telePizza.getMaxClientes()) {
            System.out.println("Error: Ya se ha alcanzado el máximo número de clientes (" + telePizza.getMaxClientes() + "), no se pueden añadir más.");
            System.out.println();
            break;
          }

          String nombreCliente;
          String apellidosCliente;
          String direccionCliente;
          String telefonoCliente;
          System.out.print("Introduce el nombre del cliente: ");
          nombreCliente = scan_in.nextLine();
          System.out.print("Introduce los apellidos del cliente: ");
          apellidosCliente = scan_in.nextLine();
          System.out.print("Introduce la dirección del cliente: ");
          direccionCliente = scan_in.nextLine();
          System.out.print("Introduce el teléfono del cliente: ");
          telefonoCliente = scan_in.nextLine();

          if (telePizza.addCliente(nombreCliente, apellidosCliente, direccionCliente, telefonoCliente)) {
            System.out.println("\tOK: Cliente añadido correctamente");
          } else {
            System.out.println("\tERROR: No se pudo añadir el cliente");
          }
          System.out.println();
          break;

        case 3:
          System.out.println("Opción 3: Añadir pedido:");
          if (telePizza.getNumClientes() < 1) {
            System.out.println(
                "Error: No hay ningún cliente registrado. Necesitas añadir un cliente antes de poder crear un pedido.");
            System.out.println();
            break;
          }

          if (telePizza.getNumPedidos() >= telePizza.getMaxPedidos()) {
            System.out.println("Error: Ya se ha alcanzado el máximo número de pedidos (" + telePizza.getMaxPedidos() + "), no se pueden añadir más.");
            System.out.println();
            break;
          }

          System.out.println(telePizza.clientesToString());
          int numeroCliente = 0;
          do {
            System.out
                .print("Introduce el número de cliente que hace el pedido (1-" + telePizza.getNumClientes() + "): ");
            numeroCliente = scan_in.nextInt();
            scan_in.nextLine();
          } while (numeroCliente < 1 || numeroCliente > telePizza.getNumClientes());

          int posicionCliente = numeroCliente - 1;
          System.out
              .println("Seleccionado el cliente " + numeroCliente + ": " + telePizza.clienteToString(posicionCliente));

          int numeroTamanioPizza;
          int numeroTipoPizza;
          do {
            System.out.print("Introduce el tamaño de la pizza usando el número (1=grande, 2=mediana): ");
            numeroTamanioPizza = scan_in.nextInt();
            scan_in.nextLine();
          } while (numeroTamanioPizza < 1 || numeroTamanioPizza > 2);
          System.out.println("Seleccionado el número " + numeroTamanioPizza + " para el tamaño de la pizza");

          do {
            System.out.print("Introduce el tipo de pizza usando el número (1=margarita, 2=cuatro quesos o 3=funghi): ");
            numeroTipoPizza = scan_in.nextInt();
            scan_in.nextLine();
          } while (numeroTipoPizza < 1 || numeroTipoPizza > 3);
          System.out.println("Seleccionado el número " + numeroTipoPizza + " para el tipo de pizza");

          // Se podrían hacer 2 métodos, uno para convertir el número a tamaño y otro para
          // convertir el número a tipo
          String tamanioPizza = null;
          switch (numeroTamanioPizza) {
            case 1:
              tamanioPizza = "grande";
              break;
            case 2:
              tamanioPizza = "mediana";
              break;
          }

          String tipoPizza = null;
          switch (numeroTipoPizza) {
            case 1:
              tipoPizza = "margarita";
              break;
            case 2:
              tipoPizza = "cuatro quesos";
              break;
            case 3:
              tipoPizza = "funghi";
              break;
          }

          if (telePizza.addPedido(posicionCliente, tamanioPizza, tipoPizza)) {
            System.out.println("\tOK: Pedido añadido correctamente");
          } else {
            System.out.println("\tERROR: No se pudo añadir el pedido");
          }
          System.out.println();
          break;

        case 4:
          System.out.println("Opción 4: Servir pedido:");
          if (telePizza.getNumPedidos() < 1) {
            System.out.println("Error: No se ha añadido ningún pedido. Para servir un pedido"
                + " se debe haber creado previamente.");
            System.out.println();
            break;

          }
          System.out.println(telePizza.pedidosToString());
          int numeroPedido = 0;
          do {
            System.out.print("Introduce el número de pedido que quieres servir (1-"
                + telePizza.getNumPedidos() + "): ");
            numeroPedido = scan_in.nextInt();
            scan_in.nextLine();
          } while (numeroPedido < 1 || numeroPedido > telePizza.getNumPedidos());

          int posicionPedido = numeroPedido - 1;
          System.out
              .println("Seleccionado el pedido " + numeroPedido + ": " + telePizza.pedidoToString(posicionPedido));

          if (telePizza.pedidoServido(posicionPedido)) {
            System.out.println("Error: El pedido seleccionado ya se ha servido.");
            System.out.println();
            break;
          } else {
            if (telePizza.servirPedido(posicionPedido)) {
              System.out.println("OK: Se ha servido el pedido: " + telePizza.pedidoToString(posicionPedido));
            } else {
              System.out
                  .println("ERROR: No se ha podido servir el pedido: " + telePizza.pedidoToString(posicionPedido));
            }

          }
          System.out.println();
          break;

        case 5:
          System.out.println("Opción 5: Salir");
          System.out.println("ESTADO FINAL DE LA PIZZERIA:\n" + telePizza);
          System.out.println();
          break;

        default:
          System.out.println("Error: opción " + opcionMenu + " inválida");
          System.out.println();
          break;
      }
    } while (opcionMenu != 5);

    scan_in.close();
    System.out.println("\n===> Bye, bye\n");
  }
}