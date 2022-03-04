package br.com.org.banco.dto;

import lombok.Getter;

@Getter
public class DepositoDTO {

	private String agencia;
	
	private String numeroConta;
	
	private double valor;
}
