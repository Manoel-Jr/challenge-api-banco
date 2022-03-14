package br.com.org.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.org.banco.entity.Conta;
import br.com.org.banco.entity.Extrato;
import br.com.org.banco.enums.TransacaoEnum;
import br.com.org.banco.repository.ExtratoRepository;

@Service
public class ExtratoServiceImpl implements ExtratoService {

	@Autowired
	private ExtratoRepository extratoRepository;
	

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

	@Override
	public void gerarExtratoConsultarSaldo(Conta conta) {
		String descricao = " Usuario " + conta.getNomeUsuario() +
				" Realizou uma consulta de Saldo  em sua conta " + conta.getNumeroConta();
		Extrato extrato = new Extrato(conta, TransacaoEnum.CONSULTAR_SALDO,descricao);
		extratoRepository.save(extrato);
	}

}
