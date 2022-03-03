package br.com.org.banco.dto;

import lombok.Getter;

@Getter
public class TransferenciaDTO {

	private String agenciaOrigem;

	private String numeroContaOrigem;
	
	private String agenciaDestino;
	
	private String numeroContaDestino;
	
	private double valor;
}
