package juego.buscamina1;

import javax.swing.*;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Cell {
    private int heigth;
    private int witdh;

    private boolean firstMove = true;
    private String[][] cell;
    private MineSweeper mine;
    private int coordenadaX;
    private int coordenadaY;
    private int numbFlagWithMine;

    public Cell(int heigth, int width, int mineSweeper) {
        this.heigth = heigth;
        this.witdh = width;
        cell = new String[heigth][width];
        mine = new MineSweeper(heigth, width, mineSweeper);
        numbFlagWithMine = mineSweeper;
        initialCell();
    }

    public void initialCell() {
        for (String[] strings : cell) {
            Arrays.fill(strings, Sign.CASILLA.getSign());
        }
    }

    public void showCell() {
        //Numeros de columnas
        for (int i = 0; i < cell[heigth - 1].length + 1; i++) {
            System.out.printf(" %2d |", (i));
        }
        System.out.println();
        //Líneas de separacion
        for (int i = 0; i < cell[heigth - 1].length + 1; i++) {
            System.out.print(" ——  ");
        }
        for (int i = 0; i < cell.length; i++) {
            //Numeros de filas
            System.out.printf("\n %2d |", (i + 1));
            for (int j = 0; j < cell[i].length; j++) {
                System.out.printf(" %2s |", cell[i][j]);
            }
            System.out.println();
            for (int k = 0; k < cell[heigth - 1].length + 1; k++) {
                System.out.print(" ——  ");
            }
        }
        System.out.println();
    }

    //Poner las minas en la tabla de visual cuando termina la partida
    public void setCellWithMine() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[i].length; j++) {
                if (mine.getElementCell(i, j).equals(Sign.MINA.getSign())
                        && !Objects.equals(mine.getElementCell(i, j), Sign.BANDERA.getSign())) {
                    cell[i][j] = Sign.MINA.getSign();
                }
            }
        }
    }

    public void movePlayer() {
        final Object[] OPTIONS = {"Descubrir", "Bandera", "Interrogacion"};
        int optionSelected = JOptionPane.showOptionDialog(null, "Seleccionar un opcion.",
                "Movimientos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, OPTIONS, OPTIONS[0]);
        if (optionSelected == JOptionPane.CLOSED_OPTION) {
            System.out.println("No has seleccionado movimieto");
        } else {
            System.out.println("Opcion seleccionado: " + OPTIONS[optionSelected]);
        }
        //optionSelected -> OPTIONS
        pedirCoordenada();
        switch (optionSelected) {
            case 0 -> {
                //Para que el primer paso nunca pise una mina
                if (firstMove) {
                    mine.generateCellMineSweeper(coordenadaX, coordenadaY);
                    cell[coordenadaX][coordenadaY] = mine.getElementCell(coordenadaX, coordenadaY);
                    firstMove = false;
                } else if (mine.getElementCell(coordenadaX, coordenadaY).equals(Sign.MINA.getSign())) {
                    //cell[coordenadaX][coordenadaY] = mine.showElementCell(coordenadaX, coordenadaY);
                    JOptionPane.showMessageDialog(null, "Has pisado mina!!!\nFin de juego.");
                    setCellWithMine();
                } else {
                    cell[coordenadaX][coordenadaY] = mine.getElementCell(coordenadaX, coordenadaY);
                }
            }
            case 1 -> {
                if (cell[coordenadaX][coordenadaY].equals(Sign.CASILLA.getSign())) {
                    cell[coordenadaX][coordenadaY] = Sign.BANDERA.getSign();
                } else if (cell[coordenadaX][coordenadaY].equals(Sign.BANDERA.getSign())) {                              //Aqui para quitar bandera
                    cell[coordenadaX][coordenadaY] = Sign.CASILLA.getSign();
                } else if (!cell[coordenadaX][coordenadaY].equals(Sign.CASILLA.getSign()) &&
                        !cell[coordenadaX][coordenadaY].equals(Sign.BANDERA.getSign())) {
                    JOptionPane.showMessageDialog(null, "Casilla invalida.");
                }
                numbFlagWithMine = isFlagOnMine(coordenadaX, coordenadaY) ? numbFlagWithMine-- : numbFlagWithMine++;
            }
            case 2 -> {
                if (cell[coordenadaX][coordenadaY].equals(Sign.CASILLA.getSign())
                        || cell[coordenadaX][coordenadaY].equals(Sign.BANDERA.getSign())) {
                    cell[coordenadaX][coordenadaY] = Sign.INTERROGACION.getSign();
                } else {
                    JOptionPane.showMessageDialog(null, "Casilla invalida.");
                }
            }
            default -> {
                JOptionPane.showMessageDialog(null, "HOli");
            }
        }
    }

    public void pedirCoordenada() {
        Scanner dato = new Scanner(System.in);
        do {
            try {
                System.out.println("Introducir coordenada X e Y (Con un espacio): ");
                coordenadaX = dato.nextInt() - 1;
                coordenadaY = dato.nextInt() - 1;
            } catch (NoSuchElementException e) {
                JOptionPane.showMessageDialog(null, "Dato introducido no es numerico.");
                coordenadaY = -1;
                dato.nextLine();
            }
        } while ((coordenadaX < 0 || coordenadaX >= heigth) || (coordenadaY < 0 || coordenadaY >= witdh));
    }

    public boolean isFlagOnMine(int coordenadaX, int coordenadaY) {
        if (mine.getElementCell(coordenadaX, coordenadaY).equals(Sign.MINA.getSign())) {
            return true;
        } else return !mine.getElementCell(coordenadaX, coordenadaY).equals(Sign.MINA.getSign()) &&
                cell[coordenadaX][coordenadaY].equals(Sign.CASILLA.getSign());
    }

    public boolean isGameOver() {
        if (numbFlagWithMine == 0) {
            JOptionPane.showMessageDialog(null, "Has ganado!!!\nFin de juego.");
            return true;
        } else return mine.getElementCell(coordenadaX, coordenadaY).equals(Sign.MINA.getSign())
                && !cell[coordenadaX][coordenadaY].equals(Sign.BANDERA.getSign());
    }

}
