package br.com.org.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.org.banco.entity.Extrato;

@Repository
public interface ExtratoRepository extends JpaRepository<Extrato, Long>{

}
