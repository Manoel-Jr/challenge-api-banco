package br.com.org.banco.service;

import br.com.org.banco.entity.Conta;

public interface ContaService {
		
	Conta criarConta(Conta conta);
	
	Conta buscarContaPorAgencia(String agencia);
	
	void saque(Conta conta, double valor);
	
	Conta buscarPorAgenciaNumroConta(String agencia, String numeroConta);
	
	void transferencia(Long contaOrigemId,Long contaDestinoId, double valor);
	
	void deposito(Conta conta , double valor);
}
