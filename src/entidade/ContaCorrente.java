package entidade;

import java.io.Serializable;

public class ContaCorrente extends RegistroIdentificavel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String numero;
	private double saldo;
	private String correntista;
	
	public ContaCorrente() {
	}

	public ContaCorrente(String numero, double saldo, String correntista) {
		this.numero = numero;
		this.saldo = saldo;
		this.correntista = correntista;
	}

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getCorrentista() {
		return correntista;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCorrentista(String correntista) {
		this.correntista = correntista;
	}
	
	public void creditar (double valor) {
		saldo += valor;
	}
	
	public void debitar (double valor) {
		saldo -= valor;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Numero da conta: " + numero + "Saldo: " + saldo + "Correntista: " + correntista;
	}

	@Override
	public String obterChave() {		
		return getNumero();
	}
	
	
	

}
