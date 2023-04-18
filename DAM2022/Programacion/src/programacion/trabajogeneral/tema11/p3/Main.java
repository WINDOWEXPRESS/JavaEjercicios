package trabajogeneral.tema11.p3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vecino vecino = new Vecino("Pepe", 16, "V0001", "00001", "Bar 1ª");
        System.out.println(vecino);

        Scanner dato = new Scanner(System.in);
        String dni;
        do {
            System.out.print("Introducir Dni:");
            dni = dato.nextLine();
            if (!vecino.dniValido(dni)) {
                System.out.println("Formato Incorrecto!!!   EJEMPLO -> 12345678X");
            }
        } while (!vecino.dniValido(dni));
        vecino.setDni(dni);

        if (!vecino.esMayorDeEdad(vecino.getEdad())){
            vecino.setEdad(18);
        }
        System.out.println(vecino);


        Administrador administrador = new Administrador("Lola", 16, "87654321X", "A1234",
                "Tem 1ª",1,3000);
        if (!administrador.esMayorDeEdad(vecino.getEdad())){
            vecino.setEdad(18);
        }
        vecino.modifCuota(10);
        if (administrador.salarioMaximo((float) Vecino.getCuota()) < administrador.getSalario()) {
            administrador.setSalario((float) administrador.salarioMaximo((float) Vecino.getCuota()));
        }
        System.out.println(administrador);
    }
}
