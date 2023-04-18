
public class Vehiculo {
	//Atributos
	String marca;
	String modelo;
	int numPasajeros;
	int capacidadCombustible;
	float consumo;	
	
	//Métodos
	//Cálculo Autonomía del Vehiculo y devolución del resultado
	public double calculoAutonomia() {
		double autonomia;
		autonomia=capacidadCombustible*consumo;
		return autonomia;
	}
	
	//Cálculo Autonomía del Vehiculo y mostrar por pantalla
	public void mostrarAutonomia() {
		double autonomia;
		autonomia=capacidadCombustible*consumo;
		System.out.printf("La autonomia del %s %s es de %5.1f km\n",marca,modelo,autonomia);
	}
	
	//Calculo de litros de combustible necesarios para recorrer x kms.
	public double combustibleNecesario(int k) {
		/*
		 * 100 km consumo km recorridos por litro combustible 20 km/l
		 */
		double litrosNecesarios;
		litrosNecesarios= k/consumo;
		return litrosNecesarios;
	}
	

}
