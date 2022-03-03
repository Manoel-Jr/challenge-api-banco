package br.com.org.banco.exception;

public class TransacaoInvalidaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TransacaoInvalidaException() {
		super();
	}
	
	public TransacaoInvalidaException(String message) {
		super(message);
	}
}
