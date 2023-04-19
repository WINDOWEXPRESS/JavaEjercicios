package trabajogeneral.tema12.p2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        //1.
        ArrayList<Empleado> listadoEmpleado = new ArrayList<>();
        listadoEmpleado.ensureCapacity(5);
        System.out.println(listadoEmpleado);
        //2.
        listadoEmpleado.add(new Comercial("Juan"));
        listadoEmpleado.add(new Comercial("Pepe"));
        listadoEmpleado.add(new Consultor("Juan"));
        listadoEmpleado.add(new Consultor("Lola"));
        listadoEmpleado.add(new Comercial("Alex"));
        System.out.println(listadoEmpleado);
        verListado(listadoEmpleado);
        //3.
        int posicion = 0;
        do {
            try {
                System.out.println("Borrar elementos de una posición facilitada por el usuario.");
                posicion = dato.nextInt()-1;

            } catch (InputMismatchException e) {
                System.out.println("Tipo de dato incorrecto.");
            }
        } while (posicion < 0);
        listadoEmpleado.remove(posicion);
        verListado(listadoEmpleado);
        //4.
        String nombre = "";
        dato.nextLine();
        do {
            System.out.println("Comprueba si se encuentra en la lista un objeto determinado.");
            nombre = dato.nextLine();
        } while (nombre.isEmpty());
        buscarElemento(true,listadoEmpleado,nombre);
        //5.    7.
        buscarElemento(false,listadoEmpleado,nombre);
        verListado(listadoEmpleado);
        //6.
        System.out.println("Sustituye el cuarto elemento de la lista por otro contenido.");
        listadoEmpleado.set(3,new Empleado("Sisi"));
        /*listadoEmpleado.add(3,new Empleado("Sisi"));
        listadoEmpleado.remove(4);*/
        verListado(listadoEmpleado);
        //8.
        Vector<Empleado> vector = new Vector<>();
        vector.addAll(listadoEmpleado);
        System.out.println("Lista en un vector");
        verListado(vector);


    }
    public static void buscarElemento(boolean estado,ArrayList<Empleado> list,String nombre) {
        int count = 1;
        Iterator<Empleado> iter = list.iterator();
        while (iter.hasNext()) {
            Empleado empleado = iter.next();
            if (empleado.getNombre().equals(nombre)) {
                if (estado) {
                    System.out.println("Position: " + count);
                } else {
                    iter.remove();
                }
            }

            count++;
        }
    }

    public static <T> void verListado(List<T> list) {
        int count = 1;
        for (Object listado :
                list) {
            System.out.println(count + ") " + listado);
            count++;
        }
    }
}
