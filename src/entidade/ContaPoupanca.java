package entidade;

public class ContaPoupanca extends ContaCorrente{	
	private static final long serialVersionUID = 1L;
	private double percentualBonus;

	public ContaPoupanca() {
	}

	public ContaPoupanca(String numero, double saldo, String correntista, double percentualBonus) {
		super(numero, saldo, correntista);
		this.percentualBonus = percentualBonus;
	}

	public double getPercentualBonus() {
		return percentualBonus;
	}

	public void setPercentualBonus(double percentualBonus) {
		this.percentualBonus = percentualBonus;
	}

	@Override
	public void creditar (double valor) {
		super.creditar(valor * ((1 + percentualBonus))/100);		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "Percentual bonus: " + percentualBonus;
	}
	
	
}
