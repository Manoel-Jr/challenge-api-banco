package br.com.org.banco.listener;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.PrePersist;

import br.com.org.banco.entity.Extrato;

public class TimeListener {

	@PrePersist
	protected void timesTamp(Extrato extrato) {
		LocalDateTime hoje = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		extrato.setTimestamp(hoje);
	}
}
