package juego.buscamina;

import java.util.Scanner;

public class ValoresBuscamina {
	private int ejeX;
	private int ejeY;
	private int ejeXJugadorDado;
	private int ejeYJugadorDado;
	private int minas;
	private boolean verifivarBomba = false;
	String[][] posicionMina;
	String[][] tablero;

	// Constructor para definir nivel del juego
	public ValoresBuscamina(short nivel) {
		if (nivel == 1) {
			this.ejeX = 8;
			this.ejeY = 8;
			this.minas = 10;
		} else if (nivel == 2) {
			this.ejeX = 16;
			this.ejeY = 16;
			this.minas = 40;

		} else {
			this.ejeX = 30;
			this.ejeY = 16;
			this.minas = 99;
		}
		this.posicionMina = new String[this.ejeX][this.ejeY];
		this.tablero = new String[this.ejeX][this.ejeY];
	}

	public void tableroPredeterminado() {
		// INICIAR TABLA CON "*"
		for (int i = 0; i < this.ejeX; i++) {
			for (int j = 0; j < this.ejeY; j++) {
				tablero[i][j] = "*";
			}
		}
		visualizarTablero(tablero);
		posicionMina();
	}

	public void posicionMina() {
		int posicionMinaEjeX;
		int posicionMinaEjeY;
		int minasPlantadas = 0;
		// INICIAR TABLA CON "*"
		for (int i = 0; i < this.ejeX; i++) {
			for (int j = 0; j < this.ejeY; j++) {
				posicionMina[i][j] = "*";
			}
		}
		//MARCAR BOMBA CON "X"
		while(minasPlantadas<minas) {
			posicionMinaEjeX = (int) (Math.random() * (this.ejeX ));
			posicionMinaEjeY = (int) (Math.random() * (this.ejeY ));
			if(posicionMina[posicionMinaEjeX][posicionMinaEjeY] == "*") {
				posicionMina[posicionMinaEjeX][posicionMinaEjeY] = "X";
				minasPlantadas++;
			}
		}

		// Visualizar tabla de bomba
		/*
		 * for (String[] arr : posicionMina) { for (String n : arr) {
		 * System.out.print(n); System.out.print('-'); } System.out.println(); }
		 */

		movimientoJugador();
	}

	// captar ejex y ejey del jugador dado
	public void movimientoJugador() {
		// variable local
		int ejeXJugadorDado;
		int ejeYJugadorDado;
		// Crear obejeto de la clase Scanner
		Scanner dato = new Scanner(System.in);
		while (!verifivarBomba){
			do {
				System.out.print("Posicion Eje X : ");
				ejeXJugadorDado = dato.nextInt();
				System.out.print("Posicion Eje Y : ");
				ejeYJugadorDado = dato.nextInt();
			} while ((ejeXJugadorDado < 1 || ejeXJugadorDado > this.ejeX)
					|| (ejeYJugadorDado < 1 || ejeYJugadorDado > this.ejeY));
			this.ejeXJugadorDado = ejeXJugadorDado - 1;
			this.ejeYJugadorDado = ejeYJugadorDado - 1;
			// Metodo de verificar si hay mina en el posiscion dado.
			verificarPosicionBomba();
		} 
	}

	// Metodo de verificar si hay mina en el posiscion dado.
	public void verificarPosicionBomba() {
		if (posicionMina[this.ejeXJugadorDado][this.ejeYJugadorDado] == "X") {
			verifivarBomba = true;
			System.out.println("Hay Bomba fin del juego.");
			posicionMina[this.ejeXJugadorDado][this.ejeYJugadorDado] ="@";
			visualizarTablero(posicionMina);
		} else {
			System.out.println("No hay bomba seguir jugando.");
			tablero[this.ejeXJugadorDado][this.ejeYJugadorDado] = "O";
			posicionMina[this.ejeXJugadorDado][this.ejeYJugadorDado] ="O";
			//Visualizar Tablero Jugado
			visualizarTablero(tablero);
		}
	}

	public void visualizarTablero(String[][] tabla) {
		//Visualizar las coordenadas del ejeY
		for (int i = 0; i <= this.ejeX; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		//Visualizar tablero 
		for (int i = 0; i < this.ejeX; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < this.ejeY; j++) {
				System.out.print("\t" + tabla[i][j]);
			}
			System.out.println();
		}
	}
}
