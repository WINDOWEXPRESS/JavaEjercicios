public class Ej_230125_CuentaBancaria {
	public static void main(String[] args) {
		//CuentaBancaria cuentaNomina = new CuentaBancaria("12345678910987654321","Carlos",1500);
		//CuentaBancaria cuentaDeAhorro = new CuentaBancaria("10987654321234567890","Carlos",5000);
		//Crear obj cuentaNomina y guardar sus datos
		CuentaBancaria cuentaNomina = new CuentaBancaria();
		cuentaNomina.setNum_Cuenta("12345678910987654321");
		cuentaNomina.setTitular("Carlos");
		cuentaNomina.setSaldo(1500);
		//Crear obj CuentaBancaria y guardar sus datos
		CuentaBancaria cuentaDeAhorro = new CuentaBancaria();
		cuentaDeAhorro.setNum_Cuenta("10987654321234567890");
		cuentaDeAhorro.setTitular("Carlos");
		cuentaDeAhorro.setSaldo(5000);
		//Visualizar estado de la cuenta
		System.out.println(cuentaNomina.toString());
		System.out.println(cuentaDeAhorro.toString());
		//Movimiento de las cuentas
		cuentaNomina.retirada(500);
		cuentaNomina.transferencia(700, cuentaDeAhorro);
		cuentaNomina.retirada(500);
		cuentaNomina.depositar(300);
		cuentaNomina.retirada(500);
		//Visualizar estado de la cuenta
		System.out.println(cuentaNomina.toString());
		System.out.println(cuentaDeAhorro.toString());
	}
}
