package br.com.org.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.org.banco.entity.Conta;
import br.com.org.banco.entity.Extrato;
import br.com.org.banco.enums.TransacaoEnum;
import br.com.org.banco.repository.ContaRepository;
import br.com.org.banco.repository.ExtratoRepository;

@Service
public class ExtratoServiceImpl implements ExtratoService {

	@Autowired
	private ExtratoRepository extratoRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	

	@Override
	public void gerarExtratoSaque(Conta conta, double valor) {
		String descricao = "Saque R$ " + valor + ". Novo Saldo: " + conta.getSaldo();
		Extrato extrato = new Extrato(conta, TransacaoEnum.SAQUE, descricao, valor);
		extratoRepository.save(extrato);
	}

	@Override
	public void gerarExtratoDeposito(Conta conta, double valor) {
		String descricao = " Feito Saque na conta " + conta.getNumeroConta() + " Saldo e " + conta.getSaldo();
		Extrato extrato = new Extrato(conta, TransacaoEnum.DEPOSITO, descricao, valor);
		extratoRepository.save(extrato);
	}

	public void gerarExtratoTransferencia(Long idContaOrigem, Long idContaDestino, double valor) {
		Conta contaOrigem = contaRepository.findById(idContaOrigem).get();
		Conta contaDestino = contaRepository.findById(idContaDestino).get();
		String descricao = " Realizado Transferencia do valor " + valor + " da conta " 
				+ contaOrigem.getNumeroConta() + " Para conta " 
				+ contaDestino.getNumeroConta();
			Extrato extrat = new Extrato(contaDestino,TransacaoEnum.TRANSFERENCIA, descricao, valor);
			extratoRepository.save(extrat);
	}

}
