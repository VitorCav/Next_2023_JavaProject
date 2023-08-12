package entidade;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class RegistroIdentificavel implements Serializable {
	
	private LocalDateTime dataHoracriacao = LocalDateTime.now();	
	
	public abstract String obterChave();
	public int obterTempoDeCriacao() {
		LocalDateTime inicioProjeto = LocalDateTime.of(2023, 8, 01, 00, 00, 00);
		int periodo = (int) ChronoUnit.DAYS.between(inicioProjeto, dataHoracriacao);
		return periodo;
	}
	

}
