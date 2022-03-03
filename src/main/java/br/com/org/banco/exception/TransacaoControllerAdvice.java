package br.com.org.banco.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static br.com.org.banco.utils.Constantes.TRANSACAO_INVALIDA;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class TransacaoControllerAdvice {

	
	@ExceptionHandler(TransacaoInvalidaException.class)
	public ResponseEntity<Object> transacaoInvalidaException(){
		HandlerGeneric generic = new HandlerGeneric(getTimesTamp(),
				HttpStatus.BAD_REQUEST.value(),TRANSACAO_INVALIDA);
		return new ResponseEntity<>(generic, HttpStatus.BAD_REQUEST);
	}
	
	public String getTimesTamp() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return formatter.format(dateTime);
	}
}
