package DAO;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import entidade.ContaCorrente;
import entidade.RegistroIdentificavel;

public class DAOGenerico {
	
	private CadastroObjetos cadastro;
	private Class tipoEntidade;

	public DAOGenerico(Class tipoEntidade) {

        this.tipoEntidade = tipoEntidade;
        cadastro = new CadastroObjetos(tipoEntidade);

    }
	
	public boolean incluir(RegistroIdentificavel reg) {
        RegistroIdentificavel regBusca = buscar(reg.obterChave());
        if (regBusca != null) {
            return false;
        } else {
            cadastro.incluir(reg, reg.obterChave());;
            return true;
        }
    }

	protected RegistroIdentificavel buscar(String obterChave) {
		return (RegistroIdentificavel) cadastro.buscar(obterChave);
	}
	
	public boolean alterar(RegistroIdentificavel reg) {
        RegistroIdentificavel regBusca = buscar(reg.obterChave());
        if (regBusca == null) {
            return false;
        } else {
            cadastro.alterar(reg, reg.obterChave());
            return true;
        }
    }
	
	public boolean excluir(RegistroIdentificavel reg) {
        RegistroIdentificavel regBusca = buscar(reg.obterChave());
        if (regBusca == null) {
            return false;
        } else {
            cadastro.excluir(reg.obterChave());
            return true;
        }
    }
	
	public RegistroIdentificavel[] buscarTodos() {
        Serializable[] rets = cadastro.buscarTodos(tipoEntidade);
        RegistroIdentificavel[] regs = new RegistroIdentificavel[rets.length];
        for(int i=0; i<rets.length; i++) {
            regs[i] = (RegistroIdentificavel) rets[i];
        }
        return regs;
    }
	

}
