package trabajogeneral.tema11.p1;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        //Instnciar la clase Trabajador con parametros introducido
        Trabajador trabajador2 = new Trabajador("Pedro", "66666666", 29, 'A', 8);
        System.out.println(trabajador2.toString());

        //Instnciar la clase Trabajador introduciendo datos con setter
        Trabajador trabajador1 = new Trabajador();
        System.out.print("Nombre:");
        String name = dato.nextLine();
        trabajador1.setName(name);
        System.out.print("Telefono:");
        String telefono = dato.nextLine();
        trabajador1.setTelefono(telefono);
        System.out.print("Categoria Profesional:");
        char categoria;
        try {
            categoria = dato.next().charAt(0);
            trabajador1.setCategoriaProfesional(categoria);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Longitud incoincidente.");
        }

        System.out.print("Antigúedad:");
        try {
            int antiguedad = dato.nextInt();
            trabajador1.setAntiguedad(antiguedad);

        } catch (InputMismatchException e) {
            System.out.println("Introducir numero");
        } catch (NoSuchElementException e) {
            System.out.println("Elemento no encontrado");
        } catch (IllegalStateException e) {
            System.out.println("Scanner cerrado");
        }
        System.out.print("Edad:");
        try {
            int edad = dato.nextInt();
            trabajador1.setEdad(edad);
        } catch (InputMismatchException e) {
            System.out.println("Introducir numero");
        } catch (NoSuchElementException e) {
            System.out.println("Elemento no encontrado");
        } catch (IllegalStateException e) {
            System.out.println("Scanner cerrado");
        }
        System.out.println(trabajador1.toString());
    }
}
