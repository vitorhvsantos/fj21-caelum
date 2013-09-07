package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	@RequestMapping("oi")
	public String executo(){
		System.out.println("Executando logica com Spring MVC");
		return "ok";
		
	}

}
