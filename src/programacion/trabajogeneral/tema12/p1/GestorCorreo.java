package trabajogeneral.tema12.p1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorCorreo {
    static ArrayList<Correo> listadoCorreo = new ArrayList<>();

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        int opcion;

        do {
            menu();

            opcion = dato.nextInt();
            switch (opcion) {
                case 1:
                    for (int i = 0; i < listadoCorreo.size(); i++) {
                        System.out.println((i + 1) + ") " + listadoCorreo.get(i));
                    }
                    System.out.println();
                    if (listadoCorreo.size() == 0) {
                        System.out.println("No hay correo.");
                    }
                    break;
                case 2:
                    dato.nextLine();
                    String origen;
                    String destino;
                    String asunto;
                    String cuerpo;
                    do {
                        System.out.print("Origen:");
                        origen = dato.nextLine();
                    } while (origen.isEmpty());

                    do {
                        System.out.print("destino:");
                        destino = dato.nextLine();
                    } while (destino.isEmpty());

                    do {
                        System.out.print("asunto:");
                        asunto = dato.nextLine();
                    } while (asunto.isEmpty());

                    do {
                        System.out.print("cuerpo:");
                        cuerpo = dato.nextLine();
                    } while (cuerpo.isEmpty());

                    LocalDate fechaLlegada = LocalDate.now();
                    LocalTime horaLlegada = LocalTime.now();
                    horaLlegada = horaLlegada.truncatedTo(ChronoUnit.SECONDS);
                    Correo correo = new Correo(origen, destino, asunto, cuerpo, fechaLlegada, horaLlegada);
                    listadoCorreo.add(correo);
                    break;
                case 3:
                    listadoCorreo.remove(obtenerPosicionCorreo());
                    System.out.println("Correo eliminado correctamente.");
                    break;
                case 4:
                    Correo corre = listadoCorreo.get(obtenerPosicionCorreo());
                    System.out.println(corre.getCuerpo());
                    break;
                case 5:
                    int count = 1;
                    for (Correo contenidoCorreo : listadoCorreo
                    ) {
                        System.out.println(count + ") " + contenidoCorreo.getFechaLlegada() + " " + contenidoCorreo.getHoraLlegada()
                                + "---->" + contenidoCorreo.getCuerpo());
                        count++;
                    }
                    break;
                case 6:
                    String origenDeterminado;
                    do {
                        System.out.print("Introducir el origen:");
                        origenDeterminado = dato.nextLine();
                    } while (origenDeterminado.isEmpty());
                    count = 1;
                    for (Correo correoBuscaOrigen : listadoCorreo
                    ) {
                        if (correoBuscaOrigen.getOrigen().equals(origenDeterminado)) {
                            System.out.println(count + ") " + correoBuscaOrigen);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opcion invalido.");
                    break;

                case 99:
                    count = 1;
                    for (Correo correoBuscaOrigen : listadoCorreo
                    ) {
                            System.out.println(count + ") " + correoBuscaOrigen.todoContenido());

                    }
            }
        } while (opcion != 7);
    }

    static int obtenerPosicionCorreo() {
        Scanner dato = new Scanner(System.in);
        int posicionCorreo = 0;
        do {
            try {
                System.out.print("Introducir la posicion de correo:");
                posicionCorreo = dato.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("Tipo de dato incorrecto.");
            }
        } while (posicionCorreo < 0 || posicionCorreo >= listadoCorreo.size());
        return posicionCorreo;
    }

    static void menu() {
        System.out.println("""
                1. Bandeja de entrada.
                2. Añadir Correo.
                3. Eliminar un correo.
                4. Mostrar un correo.
                5. Mostrar todos los correos.
                6. Mostrar correos a partir de su origen .
                7. Salir.""");
    }
}
