package DAO;

import java.io.Serializable;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import entidade.ContaCorrente;
import entidade.RegistroIdentificavel;

public class DAOContaCorrente {
	
	private DAOGenerico daoGenerico = new DAOGenerico(ContaCorrente.class); 

	public boolean incluir(ContaCorrente conta) {
		return daoGenerico.incluir(conta);		
	}

	public boolean alterar(ContaCorrente conta) {
		return daoGenerico.alterar(conta);
	}

	public ContaCorrente buscar(String numero) {
		return (ContaCorrente)daoGenerico.buscar(numero);		
	}
	
	public ContaCorrente[] buscarTodos() {
		return (ContaCorrente[]) daoGenerico.buscarTodos();
	}

}
