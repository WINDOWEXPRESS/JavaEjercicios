package juego.buscamina1;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainBuscamina {
    static int height;
    static int width;
    static int mineSweeper;
    static Scanner dato = new Scanner(System.in);

    public static void main(String[] args) {
        Cell cell = null;
        int opcion = 0;
        if (args.length > 2) {
            try {
                height = Integer.parseInt(args[0]);
                width = Integer.parseInt(args[1]);
                mineSweeper = Integer.parseInt(args[2]);
                if (mineSweeper <= height * width / 2) {
                    cell = new Cell(height, width, mineSweeper);
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR!!! \nBombas:1 a 1/3 de cuadrados.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Argumento introducido no numerico.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            if (args.length != 0) {
                JOptionPane.showMessageDialog(null, "Datos introducido insuficiente.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            Menu();
            do {
                try {
                    System.out.print("Opcion:");
                    opcion = dato.nextInt();
                } catch (InputMismatchException e) {
                    JOptionPane.showMessageDialog(null, "Dato introducido no es numerico.");
                    dato.nextLine();
                }
            } while (opcion < 1 || opcion > 4);
            //dato.close();            //No se porque si lo cierro deja de funcionar restos de Scanner de otras clases
            switch (opcion) {
                case 1 -> cell = new Cell(8, 8, 10);
                case 2 -> cell = new Cell(16, 16, 40);
                case 3 -> cell = new Cell(16, 30, 99);
                case 4 -> {
                    personalizado();
                    cell = new Cell(height, width, mineSweeper);
                }
                default ->
                        JOptionPane.showMessageDialog(null, "Opcion invalido.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        do {
            cell.showCell();
            cell.movePlayer();
        } while (!cell.isGameOver());
        cell.showCell();
    }

     public static void Menu() {
        System.out.println("==============================================");
        System.out.println("||****************BUSCAMINA*****************||");
        System.out.println("==============================================");
        System.out.println("||******************NIVEl*******************||");
        System.out.println("||1.PRINCIPIANTE: 8 X 8 casillas y 10 minas.||");
        System.out.println("||2.INTERMEDIO: 16 X 16 casillas y 40 minas.||");
        System.out.println("||3.EXPERTO: 16 X 30 casillas y 99 minas.   ||");
        System.out.println("||4.Personalizado.                          ||");
        System.out.println("==============================================");
    }

    public static void personalizado() {
        do {
            System.out.print("Introducir alto:");
            height = dato.nextInt();
            System.out.print("Introducir ancho:");
            width = dato.nextInt();
            System.out.print("Introducir numero de mina:");
            mineSweeper = dato.nextInt();
            if (mineSweeper >= height * width / 2 || (height < 4 && width < 4)) {
                JOptionPane.showMessageDialog(null, ("""
                                Dimensiones invalidas:
                                ->Altura del juego: de 8 a 24
                                ->Ancho del juego: de 8 a 32
                                ->Bombas:1 a 1/3 de cuadrados."""),
                        "Buscamina", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (mineSweeper >= height * width / 2 || (height < 8 && width < 8));
    }
}
