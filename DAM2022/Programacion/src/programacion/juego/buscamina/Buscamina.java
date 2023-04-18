package juego.buscamina;

import java.util.Scanner;

public class Buscamina {

	public static void main(String[] args) {
		// Declarar variables
		short nivel ;
		boolean salirPrograma = false;
		//Crear instancia de la clase Scanner
		Scanner dato = new Scanner(System.in);
		do {
			//Menu
			Menu();
			//Capturar nivel
			do {
				System.out.print("Nivel:");
				nivel = dato.nextShort();		
			}while(nivel<1 || nivel>3 );
			
			//Crear instancia de la clase ValoresBuscamina
			ValoresBuscamina buscamina = new ValoresBuscamina(nivel);
			//Visualizar tabla
			buscamina.tableroPredeterminado();
			
			//Movimiento jugador
			buscamina.movimientoJugador();	
			
			System.out.println("Continuar? \r1.SI\r2.NO");
			if(dato.nextInt() == 2) {
				salirPrograma = true;
				System.out.println("Fin de juego.");
			}
			
		} while(!salirPrograma);
	}
	
	public static void Menu() {
		System.out.println("==============================================");
		System.out.println("||****************BUSCAMINA*****************||");
		System.out.println("==============================================");
		System.out.println("==============================================");
		System.out.println("||******************NIVEl*******************||");
		System.out.println("||1.PRINCIPIANTE: 8 X 8 casillas y 10 minas.||");
		System.out.println("||2.INTERMEDIO: 16 X 16 casillas y 40 minas.||");
		System.out.println("||3.EXPERTO: 16 X 30 casillas y 99 minas.   ||");
		System.out.println("==============================================");
	}	
}
