//package br.com.org.banco.entity;
//
//import java.io.Serializable;
//import java.time.LocalDate;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//
//import br.com.org.banco.enums.TransacaoEnum;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "extrato")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Extrato implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@JsonFormat(pattern = "dd-MM-yyyy")
//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//	private LocalDate hora;
//	
//	//@OneToMany
//	//@JoinColumn(name = "fk_transacao")
//	private TransacaoEnum tipoTransacao; 
//	
//	//@OneToMany
//	//@JoinColumn(name = "fk_contas")
//	private Conta conta;
//}
