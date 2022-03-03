package br.com.org.banco.enums;

import br.com.org.banco.exception.TransacaoInvalidaException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TransacaoEnum {
	
	SAQUE(1),
	DEPOSITO(2),
	TRANSFERENCIA(3),
	CONSULTAR_SALDO(4),
	CONSULTAR_EXTRATO(5);
	
	
	private int codigo;

	public static TransacaoEnum valueOf(Integer idTipoTransacao) {
		for(TransacaoEnum value : TransacaoEnum.values()) {
			if(idTipoTransacao.equals(value.getCodigo())) {
				return value;
			}
		}
		throw new TransacaoInvalidaException();
	}
}
