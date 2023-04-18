package trabajogeneral.tema11.p2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ProductoAlimentariaMain {
    // Definir Variables estaticos e instancia de las clases
    static ArrayList<Fresco> listadoProductoFresco = new ArrayList<>();
    static ArrayList<Refrigerado> listadoProductoRefrigelado = new ArrayList<>();
    static ArrayList<CongeladoAire> listadoProductoCongeladoAire = new ArrayList<>();
    static ArrayList<CongeladoAgua> listadoProductoCongeladoAgua = new ArrayList<>();
    static ArrayList<CongeladoNitro> listadoProductoCongeladoNitro = new ArrayList<>();
    //Pensando con numero de lote de cada producto es unico entonces se guarda en un set
    static Set<Integer> listadoNumeroLote = new HashSet<>();
    static String nombreEmpresa;
    static String nombre;
    static int numeroDeLote;
    static String fecha;
    static LocalDate fechaDeCaducidad;
    static LocalDate fechaEnvasado;
    static String paisDeOrigen;
    //Instanciar la clase Scanner
    static Scanner dato = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nombre de la empresa:");
        nombreEmpresa = dato.nextLine();
        int opcion;
        do {
            Menu();
            opcion = dato.nextInt();
            dato.nextLine();
            switch (opcion) {
                case 1 -> {
                    // Definir instancia de las clases
                    Fresco fresco;
                    System.out.println("Has seleccionado introducir un producto fresco.");
                    capturarDatosComunes();
                    fresco = new Fresco(nombre, numeroDeLote, fechaEnvasado, LocalDate.now(), paisDeOrigen);
                    listadoProductoFresco.add(fresco);
                    System.out.println(fresco);
                }
                case 2 -> {
                    System.out.println("Listado de productos frescos.");
                    System.out.println("---".repeat(10));
                    listadoDeProductos(listadoProductoFresco);
                }
                case 3 -> {
                    //Declarar variables locales e instancia de la clase
                    int temperaturaRecomendada = 0;
                    int codigoOrganismo = 0;
                    Refrigerado refrigerado;
                    System.out.println("Has seleccionado introducir un producto refrigerado.");
                    capturarDatosComunes();
                    do {
                        try {
                            System.out.print("El código del organismo de supervisión alimentaria: ");
                            codigoOrganismo = dato.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Tipo de dato introducido erroneo.");
                            dato.nextLine();
                        }
                    } while (codigoOrganismo < 0);
                    try {
                        System.out.print("la temperatura de mantenimiento recomendada: ");
                        temperaturaRecomendada = dato.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Tipo de dato introducido erroneo.");
                        dato.nextLine();
                    }
                    refrigerado = new Refrigerado(nombre, numeroDeLote, fechaDeCaducidad, fechaEnvasado, paisDeOrigen,
                            codigoOrganismo, temperaturaRecomendada);
                    listadoProductoRefrigelado.add(refrigerado);
                    System.out.println(refrigerado);
                }
                case 4 -> {
                    System.out.println("Listado de productos refrigerado.");
                    System.out.println("---".repeat(10));
                    listadoDeProductos(listadoProductoRefrigelado);
                }
                case 5 -> {
                    // Definir instancia de las clases
                    CongeladoAire congeladoAire;
                    //Listado de información
                    final String[] AIRE_CONGELADO = {"Nitrogeno", "Oxigeno", "Dioxido de carbono", "Vapor de ague"};
                    float[] porcentajeCongeladoAire = new float[4];
                    System.out.println("Has seleccionado introducir un producto congerado por aire.");
                    capturarDatosComunes();
                    for (int i = 0; i < AIRE_CONGELADO.length; i++) {
                        float porCentaje;
                        do {
                            try {
                                System.out.print("introducir % de " + AIRE_CONGELADO[i] + ": ");
                                porCentaje = dato.nextFloat();
                            } catch (InputMismatchException e) {
                                System.out.println("Dato incorrecto.");
                                dato.nextLine();
                                porCentaje = -99;
                            }
                        } while (porCentaje == -99);

                        porcentajeCongeladoAire[i] = porCentaje;
                    }
                    congeladoAire = new CongeladoAire(nombre, numeroDeLote, fechaDeCaducidad, fechaEnvasado, paisDeOrigen,
                            porcentajeCongeladoAire);
                    listadoProductoCongeladoAire.add(congeladoAire);
                }
                case 6 -> {
                    System.out.println("Listado de productos congerados por aire.");
                    System.out.println("---".repeat(10));
                    listadoDeProductos(listadoProductoCongeladoAire);
                }
                case 7 -> {
                    // Definir instancia de las clases
                    CongeladoAgua congeladoAgua;
                    //Variable local
                    int salinidad = 0;
                    System.out.println("Has seleccionado introducir un producto congerado por agua.");
                    capturarDatosComunes();
                    try {
                        System.out.print("la salinidad del agua(en gramos de sal por litro de agua):");
                        salinidad = dato.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Dato incorrecto.");
                        dato.nextLine();
                    }
                    congeladoAgua = new CongeladoAgua(nombre, numeroDeLote, fechaDeCaducidad, fechaEnvasado, paisDeOrigen,
                            salinidad);
                    listadoProductoCongeladoAgua.add(congeladoAgua);
                }
                case 8 -> {
                    System.out.println("Listado de productos congerados por agua.");
                    System.out.println("---".repeat(10));
                    listadoDeProductos(listadoProductoCongeladoAgua);
                }
                case 9 -> {
                    // Definir instancia de las clases
                    CongeladoNitro congeladoNitro;
                    //Variable local
                    String metodoCongelacionEmpleado;
                    int tiempoExposicion = 0;
                    System.out.println("Has seleccionado introducir un producto congerado por nitro.");
                    capturarDatosComunes();
                    System.out.print("Metodo de congelación empleado: ");
                    metodoCongelacionEmpleado = dato.nextLine();
                    do {
                        try {
                            System.out.print("Tiempo de exposición al nitrógeno expresada en segundos: ");
                            tiempoExposicion = dato.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Dato incorrecto.");
                            dato.nextLine();
                        }
                    } while (tiempoExposicion < 0);
                    congeladoNitro = new CongeladoNitro(nombre, numeroDeLote, fechaDeCaducidad, fechaEnvasado, paisDeOrigen,
                            metodoCongelacionEmpleado, tiempoExposicion);
                    listadoProductoCongeladoNitro.add(congeladoNitro);
                }
                case 10 -> {
                    System.out.println("Listado de productos congerados por nitro.");
                    System.out.println("---".repeat(10));
                    listadoDeProductos(listadoProductoCongeladoNitro);
                }
                case 11 -> System.out.println("Fin del programa.");
                default -> System.out.println("Opcion invalido.");
            }
        } while (opcion != 11);
    }


    private static void Menu() {

        int longitudCadena = (42 - nombreEmpresa.length()) / 2;
        System.out.println("==============================================");
        System.out.print("||" + "*".repeat(longitudCadena) + nombreEmpresa);
        System.out.println((nombreEmpresa.length() % 2 != 0 ? "*".repeat(longitudCadena + 1) : "*".repeat(longitudCadena)) + "||");
        System.out.println("==============================================");
        System.out.println("||*******************Menu*******************||");
        System.out.println("||1.Ingresar productos frescos.             ||");
        System.out.println("||2.Mostrar productos frescos.              ||");
        System.out.println("||3.Ingresar productos refrigerados.        ||");
        System.out.println("||4.Mostrar productos refrigerados.         ||");
        System.out.println("|| ----------productos congerados---------- ||");
        System.out.println("||5.Ingresar productos congerados por aire. ||");
        System.out.println("||6.Mostrar productos congerados por aire.  ||");
        System.out.println("||7.Ingresar productos congerados por agua. ||");
        System.out.println("||8.Mostrar productos congerados por agua.  ||");
        System.out.println("||9.Ingresar productos congerados por nitro.||");
        System.out.println("||10.Mostrar productos congerados por nitro.||");
        System.out.println("||11.Salir.                                 ||");
        System.out.println("==============================================");
    }

    //Metodo para visualizar diferente tipo de ArrayList usando generic
    private static <T> void listadoDeProductos(ArrayList<T> producto) {
        int i = 1;
        for (T productoFresco : producto) {
            System.out.println(i + ") " + productoFresco);
            i++;
        }
    }

    private static void capturarDatosComunes() {
        // Pedir introducir los datos del producto
        do {
            System.out.print("Introduce el nombre del producto:");
            nombre = dato.nextLine();
        } while (nombre.isEmpty());
        do {
            System.out.print("Introduce su numero de lote: ");
            try {
                numeroDeLote = dato.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Dato erroneo!");
                dato.nextLine();
            }
        } while (!listadoNumeroLote.add(numeroDeLote));
        dato.nextLine();

        // Definimos el formato de la fecha a ingresar
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            System.out.print("Introduce su fecha de caducidad(formato dd/MM/yyyy):");
            fecha = dato.nextLine();
            try {
                fechaDeCaducidad = LocalDate.parse(fecha, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto.");
            }
        } while (fecha.isEmpty());

        do {
            System.out.print("Introduce su fecha de envasado(formato dd/MM/yyyy):");
            try {
                fecha = dato.nextLine();
                fechaEnvasado = LocalDate.parse(fecha, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto.");
            }
        } while (fecha.isEmpty());

        do {
            System.out.print("Introduce su pais de origen:");
            paisDeOrigen = dato.nextLine();
        } while (paisDeOrigen.isEmpty());

    }
}
