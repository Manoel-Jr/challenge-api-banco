package br.com.org.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.org.banco.entity.Conta;
import br.com.org.banco.exception.ContaExistenteException;
import br.com.org.banco.exception.ContaInvalidaException;
import br.com.org.banco.repository.ContaRepository;

@Service
public class ContaServiceImpl implements ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ExtratoService extratoService;
	
	@Override
	public Conta criarConta(Conta conta) {
		boolean hasAgencia = contaRepository.existsByAgencia(conta.getAgencia());
		boolean hasNumeroConta = contaRepository.existsByNumeroConta(conta.getNumeroConta());
		if(hasAgencia || hasNumeroConta) {
			 throw new ContaExistenteException();
		}
		return contaRepository.save(conta);
	}

	@Override
	public Conta buscarContaPorAgencia(String agencia) {
		Conta conta = contaRepository.findByAgencia(agencia);
		if (conta != null) {
			return conta;
		}
		throw new ContaExistenteException();
	}

	public void saque(Conta conta, double valor) {
		Conta contaSalva = contaRepository.findById(conta.getId()).get();
		contaSalva.setSaldo(contaSalva.getSaldo() - valor);
		contaRepository.save(contaSalva);
		extratoService.gerarExtratoSaque(contaSalva, valor);
	}

	public Conta buscarPorAgenciaNumroConta(String agencia, String numeroConta) {
		Conta conta = contaRepository.findByAgenciaAndNumeroConta(agencia, numeroConta);
		if (conta.getAgencia() != null || conta.getNumeroConta() != null) {
			return conta;
		}
		return null;
	}

	@Override
	public void transferencia(Long contaOrigemId, Long contaDestinoId, double valor) {
		Conta contaOrigem = contaRepository.findById(contaOrigemId).get();
		Conta contaDestino = contaRepository.findById(contaDestinoId).get();
		contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
		contaDestino.setSaldo(contaDestino.getSaldo() + valor);
		contaRepository.save(contaOrigem);
		contaRepository.save(contaDestino);
		extratoService.gerarExtratoTransferencia(contaOrigemId, contaDestinoId, valor);
	}

	@Override
	public void deposito(Conta conta, double valor) {
		Conta cont = contaRepository.findById(conta.getId()).get();
		cont.setSaldo(cont.getSaldo() + valor);
		contaRepository.save(cont);
		extratoService.gerarExtratoDeposito(conta, valor);
	}

	@Override
	public Conta buscarPorId(Long id) {
		Conta conta = contaRepository.findById(id).get();
		return conta;
	}

	@Override
	public double consultarSaldo(Conta conta) {
		Conta cont = contaRepository.findByAgenciaAndNumeroConta(conta.getAgencia(), conta.getNumeroConta());
		if(cont != null) {
			return cont.getSaldo();
		}
		throw new ContaInvalidaException();
	}

	
}
