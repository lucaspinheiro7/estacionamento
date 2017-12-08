package com.fpl.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpl.estacionamento.model.Carro;

public interface Carros extends JpaRepository<Carro, Long> {

}
