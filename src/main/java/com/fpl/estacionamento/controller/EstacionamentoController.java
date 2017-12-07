package com.fpl.estacionamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("estacionamento/registro-carro");
		return modelAndView;
	}
	
}