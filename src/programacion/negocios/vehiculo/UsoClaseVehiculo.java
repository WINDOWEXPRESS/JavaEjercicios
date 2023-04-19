import java.util.Scanner;

public class UsoClaseVehiculo {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//Instanciación del objeto
		Vehiculo monovolumen = new Vehiculo();
		Vehiculo deportivo = new Vehiculo();
		
		//Dar valor a los atributos
		monovolumen.marca="Renault";
		monovolumen.modelo="Space";
		monovolumen.numPasajeros=7;
		monovolumen.capacidadCombustible=50;
		monovolumen.consumo=14;
		
		deportivo.marca="Lexus";
		deportivo.modelo="F Sport";
		deportivo.numPasajeros=2;
		deportivo.capacidadCombustible=66;
		deportivo.consumo=18.8f;
		
		//Ejecutar método autonomia
		System.out.printf("La autonomia del %s %s es de %5.1f km\n",monovolumen.marca,monovolumen.modelo,monovolumen.calculoAutonomia());
		deportivo.mostrarAutonomia();
		
		int distancia; 
		double litros;
		System.out.print("Para que distancia quiere hacer el cálculo");
		distancia=in.nextInt();
		
				
		litros=monovolumen.combustibleNecesario(distancia);
		System.out.printf("Los litros necesarios para recorrer %4d kms. con el %s %s son %4.1f litros\n",distancia,monovolumen.marca,monovolumen.modelo,litros);
		litros=deportivo.combustibleNecesario(distancia);
		System.out.printf("Los litros necesarios para recorrer %4d kms. con el %s %s  son %4.1f litros\n",distancia,deportivo.marca,deportivo.modelo,litros);
	}
}