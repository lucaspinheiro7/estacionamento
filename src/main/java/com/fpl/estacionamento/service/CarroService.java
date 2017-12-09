package com.fpl.estacionamento.service;

import java.math.BigDecimal;
import java.util.Date;

public interface CarroService {
	
	public BigDecimal calcularDiferenca(Date date, Date date2);
	
	public BigDecimal calcularPagamento(BigDecimal precoHora, BigDecimal horas);
}
