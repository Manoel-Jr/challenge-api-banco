package br.com.org.banco.service;

import br.com.org.banco.entity.Conta;

public interface ExtratoService {
	
	void gerarExtratoSaque(Conta conta , double valor);
	
	
	
	
}
