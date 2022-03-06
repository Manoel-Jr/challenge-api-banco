package br.com.org.banco.exception;

public class ContaExistenteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ContaExistenteException() {
		super();
	}
	
	public ContaExistenteException(String message) {
		super(message);
	}
}
