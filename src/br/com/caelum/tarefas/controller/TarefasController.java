package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {

	private final JdbcTarefaDao dao;
	
	@Autowired
	public TarefasController(JdbcTarefaDao dao){
		this.dao = dao;
	}
	
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping(method = RequestMethod.POST, value = "adicionaTarefa")
	public String adiciona(@Valid Tarefa t, BindingResult b) {
		if (b.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}

		dao.adiciona(t);

		return "redirect:listaTarefas";
	}

	@RequestMapping("listaTarefas")
	public String lista(Model m) {
		m.addAttribute("tarefa", dao.lista());
		return "tarefa/lista";

	}

	@RequestMapping("removeTarefa")
	public void remover(Tarefa t, HttpServletResponse res) {
		this.dao.remove(t);
		res.setStatus(200);
		
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model m) {
		Tarefa t = dao.buscaPorId(id);
		m.addAttribute("tarefa", t);

		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String alterarT(@Valid Tarefa t, BindingResult rs) {

		if (rs.hasFieldErrors("descricao")) {
			return "tarefa/mostra";

		} else if (t.isFinalizado() && t.getDataFinalizacao() == null) {
			rs.hasFieldErrors("dataFinalizacao");
			ObjectError error = new ObjectError("tarefa.dataFinalizacao",
					"A data nao pode estar vazia");
			rs.addError(error);
			return "tarefa/mostra";
		}
		dao.altera(t);

		return "redirect:listaTarefas";

	}

	@RequestMapping("finalizaTarefa")
	public void finalizaTarefa(Long id, HttpServletResponse res) {

		dao.finaliza(id);
		res.setStatus(200);
	}
	
	@RequestMapping("desfinalizaTarefa")
	public void desfinalizaTarefa(Long id, HttpServletResponse res) {

		dao.desfinalizarTarefa(id);
		res.setStatus(200);
	}

	

}
