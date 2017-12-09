package com.fpl.estacionamento.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fpl.estacionamento.model.Carro;
import com.fpl.estacionamento.repository.Carros;
import com.fpl.estacionamento.service.CarroService;

@Controller
@RequestMapping("/estacionamento")
public class EstacionamentoController {

	@Autowired
	private Carros carros;

	@Autowired
	private CarroService carroService;

	@GetMapping("/novo")
	public ModelAndView novo(Carro carro) {
		ModelAndView modelAndView = new ModelAndView("estacionamento/registro-carro");
		modelAndView.addObject(carro);
		return modelAndView;
	}

	@PostMapping("/novo")
	public ModelAndView registrar(@Valid Carro carro, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(carro);
		}

		Date horaEntrada = new Date();
		carro.setHoraEntrada(horaEntrada);
		carros.save(carro);
		attributes.addFlashAttribute("mensagem", "Carro registrado com sucesso!");

		return new ModelAndView("redirect:/estacionamento/novo");
	}
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("/estacionamento/lista-carros");
		modelAndView.addObject("carros", carros.findAll());

		if (carros.findAll().isEmpty()) {
			return modelAndView;
		}

		for (Carro c : carros.findAll()) {
			BigDecimal horas = carroService.calcularDiferenca(c.getHoraEntrada(), new Date());
			BigDecimal totPagar = carroService.calcularPagamento(c.getPrecoHora(), horas);
			c.setTotPagar(totPagar);
		}

		return modelAndView;
	}

	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id, RedirectAttributes attributes) {
		carros.delete(id);
		attributes.addFlashAttribute("mensagem", "Carro removido do pátio com sucesso!");
		return "redirect:/estacionamento";
	}

}