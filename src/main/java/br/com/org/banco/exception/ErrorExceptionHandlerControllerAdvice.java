package br.com.org.banco.exception;

import static br.com.org.banco.utils.Constantes.CONTA_EXISTENTE;
import static br.com.org.banco.utils.Constantes.CONTA_INVALIDA;
import static br.com.org.banco.utils.Constantes.TRANSACAO_INVALIDA;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class ErrorExceptionHandlerControllerAdvice {

	
	@ExceptionHandler(TransacaoInvalidaException.class)
	public ResponseEntity<Object> transacaoInvalidaException(){
		HandlerGeneric generic = new HandlerGeneric(getTimesTamp(),
				HttpStatus.BAD_REQUEST.value(),TRANSACAO_INVALIDA);
		return new ResponseEntity<>(generic, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ContaExistenteException.class)
	public ResponseEntity<Object> ContaExistente(){
		HandlerGeneric generic = new HandlerGeneric(getTimesTamp(),
				HttpStatus.BAD_REQUEST.value(),CONTA_EXISTENTE);
		return new ResponseEntity<>(generic, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ContaExistenteException.class)
	public ResponseEntity<Object> Conta(){
		HandlerGeneric generic = new HandlerGeneric(getTimesTamp(),
				HttpStatus.BAD_REQUEST.value(),CONTA_INVALIDA);
		return new ResponseEntity<>(generic, HttpStatus.BAD_REQUEST);
	}
	
	public String getTimesTamp() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return formatter.format(dateTime);
	}
}
