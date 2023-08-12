package negocio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import DAO.DAOContaCorrente;
import entidade.ContaCorrente;
import entidade.ContaPoupanca;

public class MediatorContaCorrente {
	
	private DAOContaCorrente daoContaCorrente = new DAOContaCorrente();
	
	public String incluir (ContaCorrente conta) {		
		
		if (conta.getNumero().length() > 8 || conta.getNumero().length() < 5) {
			return "Numero de conta invalido, a conta tem entre 5 e 8 digitos! ";
		}
		else if (stringNulaOuVazio(conta.getNumero())) {
			return "Favor informar o numero de conta! ";
		}
		else if (conta.getSaldo() < 0) {
			return "Sua conta será bloqueada, saldo negativo identificado. Favor se dirigir a gerencia! ";
		}
		else if (conta.getCorrentista().length() > 60) {
			return "Numero de caracteres maximos exedidos! ";
		}
		else if (stringNulaOuVazio(conta.getCorrentista())) {
			return "Favor informar o nome! ";
		}
		else if (conta instanceof ContaPoupanca) {
			((ContaPoupanca) conta).getPercentualBonus();
		}
		
		boolean testar = daoContaCorrente.incluir(conta);
		
		if (testar == false) {
			return "Favor rever o cadastro, conta existente! ";
		}
		return null;			
	}
	
	public boolean stringNulaOuVazio(String teste) {
		return teste == null || teste.trim().equals("");
	}
	
	public String creditar(double valor, String numero) {
		if (valor < 0) {
			return "Valor a creditar tem que ser maior ou igual a zero! ";
		}
		else if (stringNulaOuVazio(numero)) {
			return "Conta não valida! ";
		}
		else {
			ContaCorrente verificaConta = daoContaCorrente.buscar(numero);
			if (verificaConta == null) {
				return "Conta não encontrada! ";
			}
			
			else {
				verificaConta.creditar(valor);
				daoContaCorrente.alterar(verificaConta);
				return null;
			}
		}
		
	}
	
	public String debitar(double valor, String numero) {
		if (valor > 0) {
			return "Valor a bebitar tem que ser menor ou igual a zero! ";
		}
		else if (stringNulaOuVazio(numero)) {
			return "Conta não valida! ";
		}
		else {
			ContaCorrente verificaConta = daoContaCorrente.buscar(numero);
			if (verificaConta == null) {
				return "Conta não encontrada! ";
			}
			
			else if (verificaConta.getSaldo() < valor) {
				return "Saldo insuficiente! ";
			}			
			else {
				verificaConta.debitar(valor);;
				daoContaCorrente.alterar(verificaConta);
				return null;
			}
		}
	}
	
	public ContaCorrente buscar(String numero) {
		if (stringNulaOuVazio(numero)) {
			return null;
		}
		ContaCorrente verificaConta = daoContaCorrente.buscar(numero);
		return verificaConta;
	}
	 public List<ContaCorrente> gerarRelatorioGeral() {
		 ContaCorrente[] contas = daoContaCorrente.buscarTodos();
		 List<ContaCorrente> listaContas = Arrays.asList(contas);
		 Collections.sort(listaContas, new ComparadorContaCorrenteSaldo()); 
		 return listaContas;
		 
	 }

}
