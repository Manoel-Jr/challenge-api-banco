package br.com.org.banco.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.org.banco.dto.SaqueDTO;
import br.com.org.banco.dto.TransferenciaDTO;
import br.com.org.banco.entity.Conta;
import br.com.org.banco.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaRest {

	@Autowired
	private ContaService contaService;
	
	@PostMapping
	public ResponseEntity<Conta> addConta(@RequestBody Conta conta){
		return new ResponseEntity<>(contaService.criarConta(conta), HttpStatus.CREATED);
	}
	
	@GetMapping("/busca-conta-por-agencia/{agencia}")
	public ResponseEntity<Conta> buscarContaPorAgencia(@PathVariable String agencia){
		return new ResponseEntity<>(contaService.buscarContaPorAgencia(agencia),HttpStatus.OK);
	}
	
	@PostMapping("/saque")
	public ResponseEntity<String> sacar(@RequestBody SaqueDTO dto){
		Conta conta = contaService.buscarPorAgenciaNumroConta(dto.getAgencia(), dto.getNumeroConta());
		contaService.saque(conta, dto.getValor());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Saque realizado com sucesso!");
	}
	
	@GetMapping("/buscar-conta-por/{agencia}/{numeroConta}")
	public ResponseEntity<Conta> pesquisarContaPorAgenciaNumeroConta(
			@PathVariable String agencia,@PathVariable String numeroConta){
		return new ResponseEntity<>(contaService.buscarPorAgenciaNumroConta(agencia, numeroConta),
				HttpStatus.OK);
	}
	
	@PostMapping("/transferencia")
	public ResponseEntity<String> transferencia(@RequestBody TransferenciaDTO dto){
		Conta contaOrigem = contaService.buscarPorAgenciaNumroConta(dto.getAgenciaOrigem(), dto.getNumeroContaOrigem());
		Conta contaDestino = contaService.buscarPorAgenciaNumroConta(dto.getAgenciaDestino(),dto.getNumeroContaDestino());
		contaService.transferencia(contaOrigem.getId(), contaDestino.getId(), dto.getValor());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Transferência realizado com sucesso!");
	}
}
