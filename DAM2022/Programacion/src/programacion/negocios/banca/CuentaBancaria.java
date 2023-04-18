import javax.swing.JOptionPane;

public class CuentaBancaria {
	private String num_Cuenta ;
	private String titular ;
	private float saldo ;
	private float moneda ;
/*
	public CuentaBancaria(String num_Cuenta,String titular,int saldo){
		this.num_Cuenta = num_Cuenta;
		this.titular = titular;
		this.saldo = saldo;
	}
*/
	public void setNum_Cuenta(String num_Cuenta) {
		this.num_Cuenta = num_Cuenta;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public float getSaldo() {
		return saldo;
	}
	public String toString() {
		return "Número de cuenta :"+num_Cuenta +"\rTitular :"+titular+"\rSaldo :"+saldo;
	}
	public void retirada(float moneda) {
		if(moneda<=saldo)
			saldo -= moneda; 
		else
			JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
	}
	public void depositar(float moneda) {
			saldo += moneda; 

	}
	public void transferencia(float moneda,CuentaBancaria cuentaDestino) {
		if(moneda<=saldo) {
			saldo -= moneda; 
			cuentaDestino.setSaldo(cuentaDestino.getSaldo()+moneda);
		}else
			JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
	}
}
