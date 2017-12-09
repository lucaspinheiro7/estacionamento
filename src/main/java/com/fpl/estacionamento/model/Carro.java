package com.fpl.estacionamento.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Carro implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long id;
	
	@NotBlank
	private String modelo;
	
	@NotBlank
	private String placa;
	
	@NotNull
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal precoHora;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaEntrada;
	
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal totPagar;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public BigDecimal getPrecoHora() {
		return precoHora;
	}
	public void setPrecoHora(BigDecimal precoHora) {
		this.precoHora = precoHora;
	}
	
	public Date getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	
	public BigDecimal getTotPagar() {
		return totPagar;
	}
	public void setTotPagar(BigDecimal totPagar) {
		this.totPagar = totPagar;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
