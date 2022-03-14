package br.com.org.banco.exception;

public class ContaInvalidaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	

	public ContaInvalidaException() {
		super();
	}
	
	public ContaInvalidaException(String message) {
		super(message);
	}
}
