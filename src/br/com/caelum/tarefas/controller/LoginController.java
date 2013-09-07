package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	public String loginForm(){
		return "formulario-login";
	}
	@RequestMapping("autentica")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		boolean existeUsuario = new JdbcUsuarioDao().existeUsuario(usuario);
		if (!existeUsuario){
			return "redirect:login";
		}
		session.setAttribute("usrlogado", usuario);		
		return "/home";
		
		
	}
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}

}
