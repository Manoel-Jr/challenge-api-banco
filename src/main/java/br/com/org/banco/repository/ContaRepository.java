package br.com.org.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.org.banco.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

	//public boolean existisByContaAndAngencia(String numeroConta, String agencia);
	
	public Conta findByAgencia(String agencia);
	
	Conta findByAgenciaAndNumeroConta(String agencia, String numeroConta);
	
	Conta findByNumeroConta(String numeroConta);
	
}
