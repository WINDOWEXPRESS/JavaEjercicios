package juego.buscamina1;

public class MineSweeper {
    private final String signMine = "*";
    private final int mineSweeper;
    private static String[][] cellMineSweeper ;
    private int heigth;
    private int width;
    MineSweeper(int heigth,int width,int mineSweeper){
        this.heigth = heigth;
        this.width = width;
        this.mineSweeper = mineSweeper;
        cellMineSweeper = new String[heigth][width];
    }

    public void generateCellMineSweeper(int coordenadaX,int coordenadaY){
        //Primero generar bombas en la tabla
        int counterMineSweeper = 0;
        String firstMove = " ";
        cellMineSweeper[coordenadaX][coordenadaY] = firstMove;
        while (counterMineSweeper<mineSweeper){
            int randomPositionHeigth = (int) (Math.random()*heigth);
            int randomPositionWidth = (int) (Math.random()*width);
            if (cellMineSweeper[randomPositionHeigth][randomPositionWidth] == null){
                cellMineSweeper[randomPositionHeigth][randomPositionWidth] = signMine;
                counterMineSweeper++;
            }
        }
        //Segundo contar el numero de bombas que hay alrededor
        for (int i = 0; i < cellMineSweeper.length; i++) {
            for (int j = 0; j < cellMineSweeper[i].length; j++) {
                if (cellMineSweeper[i][j]!=(signMine) && cellMineSweeper[i][j]!=(" ")){
                    cellMineSweeper[i][j] = ""+countMinesAround(i,j);
                }
            }
        }
        System.out.println();
    }
    public int countMinesAround(int x, int y){
        int minesAround = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < cellMineSweeper.length-1 && j >= 0 && j < cellMineSweeper[heigth-1].length ) {
                    if (cellMineSweeper[i][j]==(signMine)) {
                        minesAround++;
                    }
                }
            }
        }
        return minesAround;
    }
/** Metodo para mostrar el tablero de la mina
    public void showCellMineSweeper(){
        //Numeros de columnas
        for (int i = 0; i < cellMineSweeper[heigth-1].length+1; i++){
            System.out.print((i)+" |\t");
        }
        System.out.println();
        for (int i = 0; i < cellMineSweeper[heigth-1].length+1; i++){
            System.out.print("——  ");
        }
        for (int i = 0; i < cellMineSweeper.length; i++) {
            //Numeros de filas
            System.out.print("\n"+(i+1)+" |\t");
            for (int j = 0; j < cellMineSweeper[i].length; j++) {
                System.out.print(cellMineSweeper[i][j]+"\t");
            }
        }
        System.out.println();
    }*/
    public String getElementCell(int coordenadaX, int coordenadaY){
        if (cellMineSweeper[coordenadaX][coordenadaY]==null){
            return Sign.CASILLA.getSign();
        }
        return cellMineSweeper[coordenadaX][coordenadaY];
    }
}
