package negocio;

import java.util.Comparator;

import entidade.ContaCorrente;

public class ComparadorContaCorrenteSaldo implements Comparator<ContaCorrente>{

	@Override
	public int compare(ContaCorrente o1, ContaCorrente o2) {
		if (o1.getSaldo() > o2.getSaldo()) {
			return 1;			
		}
		else if (o1.getSaldo() == o2.getSaldo()) {
			return 0;			
		}
		else {
			return -1;
		}
	}
}
