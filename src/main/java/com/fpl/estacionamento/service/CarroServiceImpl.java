package com.fpl.estacionamento.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.springframework.stereotype.Service;

@Service
public class CarroServiceImpl implements CarroService {

	@Override
	public BigDecimal calcularDiferenca(Date horaEntrada, Date horaSaida) {
		
		DateTime entrada = new DateTime(horaEntrada);
		DateTime saida = new DateTime(horaSaida);
		
		/**
		 * Calculando apenas a parte inteira ( horas )
		 */
		// int i = Hours.hoursBetween(entrada, saida).getHours();
		
		/**
		 * Calculando Horas e minutos
		 */
		BigDecimal minutos =  new BigDecimal(Minutes.minutesBetween(entrada, saida).getMinutes());
		BigDecimal horas = minutos.divide(new BigDecimal("60"), 2, RoundingMode.HALF_UP);
		System.out.println("VALOR DAS HORAS = " +horas);
		return horas;
	}

	@Override
	public BigDecimal calcularPagamento(BigDecimal precoHora, BigDecimal horas) {
		
		BigDecimal totPagar = precoHora.multiply(horas);
		return totPagar;
	}
	
	
}
