package apresentacao;

import java.util.List;
import java.util.Scanner;

import entidade.ContaCorrente;
import entidade.ContaPoupanca;
import negocio.MediatorContaCorrente;

public class TelaContaCorrente {
	private MediatorContaCorrente mediatorContaCorrente = new MediatorContaCorrente();
	public static final Scanner SCAN = new Scanner(System.in);
	
	public TelaContaCorrente() {		
	}

	public void iniciarTela() {
		boolean loop = true;
		
		while(loop) {
			System.out.println("************* Tela ************");
			System.out.println("1 - Incluir");
			System.out.println("2 - Creditar");
			System.out.println("3 - Debitar");
			System.out.println("4 - Buscar");
			System.out.println("5 - Listar");
			System.out.println("6 - Sair");
			System.out.println("************* Tela ************");
			
			int opcao = SCAN.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.println("************* Incluir ************");
				incluir();
				break;
			case 2:
				System.out.println("************* Creditar ************");
				creditar();
				break;
			case 3:
				System.out.println("************* Debitar ************");
				debitar();
				break;
			case 4:
				System.out.println("************* Buscar ************");
				buscar();
				break;
			case 5:
				System.out.println("************* Gerar relatorio ************");
				gerarRelatorioGeral();
				break;
			case 6:
				System.out.println("************* Sair ************");
				loop = false;
				break;
			default:
				iniciarTela();
				
			}
		}
	}
	
	private void incluir() {
		ContaCorrente conta = null;
		
		System.out.println("Digite o numero da conta: ");
		String numero = SCAN.next();		
		System.out.println("Digite o nome do correntista: ");
		String correntista = SCAN.next();
		System.out.println("Conta poupanca (S/N)? ");
		String perguntaPoup = SCAN.next();
		
		if (perguntaPoup.toLowerCase().equals("s")) {
			System.out.println("Qual o valor bonus? ");
			double bonus = SCAN.nextDouble();
			conta = new ContaPoupanca(numero, 0, correntista, bonus);			
		}
		else {
			conta = new ContaCorrente(numero, 0, correntista);			
		}
		String incluir = mediatorContaCorrente.incluir(conta);
		
		if (incluir == null) {
			System.out.println("Conta incluida com sucesso! ");
		}
		else {
			System.out.println(incluir);
		}
		
	}
	
	private void creditar() {
		
		System.out.println("Qual o numero da conta? ");
		String numero = SCAN.next();
		System.out.println("Qual o valro a ser creditado? ");
		double valor = SCAN.nextDouble();
		String creditar = mediatorContaCorrente.creditar(valor, numero);
		
		if (creditar == null) {
			System.out.println("valor adicionado com sucesso! ");
		}
		else {
			System.out.println(creditar);
		}		
	}
	private void debitar() {
		System.out.println("Qual o numero da conta? ");
		String numero = SCAN.next();
		System.out.println("Qual o valro a ser debitado? ");
		double valor = SCAN.nextDouble();
		String debitar = mediatorContaCorrente.debitar(valor, numero);
		
		if (debitar == null) {
			System.out.println("Valor debitado com sucesso! ");
		}
		else {
			System.out.println(debitar);
		}		
	}
	// no UML não informa que a funcao buscar é "void", ajustei para ficar igual resposta.
	private void buscar() {
		System.out.println("Qual o numero da conta? ");
		String numero = SCAN.next();
		
		ContaCorrente conta = mediatorContaCorrente.buscar(numero);
		
		if (conta == null) {
			System.out.println("Conta não existente! ");
		}
		else {
			System.out.println(conta);
		}
		//return conta;
	}
	
	// no UML não informa que a funcao buscar é "void", ajustei para ficar igual resposta.
	private void gerarRelatorioGeral() {
		List<ContaCorrente> contas = mediatorContaCorrente.gerarRelatorioGeral();
		for (int i = 0; i < contas.size(); i++) {
			System.out.println(contas.get(i));
		}		
	}	 

}
