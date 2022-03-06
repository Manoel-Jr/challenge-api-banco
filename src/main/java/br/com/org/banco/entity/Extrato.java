package br.com.org.banco.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.org.banco.enums.TransacaoEnum;
import br.com.org.banco.listener.TimeListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "extrato")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(TimeListener.class)
public class Extrato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime timestamp;
	
	@Enumerated(EnumType.STRING)
	private TransacaoEnum tipoTransacao; 
	
	@ManyToOne
	@JoinColumn(name = "conta_fk")
	private Conta conta;
	
	private String descricao;
	
	private double valor;
	
	public Extrato(Conta conta, TransacaoEnum tipo, String descricao, double valor) {
		this.conta = conta;
		this.descricao = descricao;
		this.valor = valor;
		this.tipoTransacao = tipo;
	}
}
