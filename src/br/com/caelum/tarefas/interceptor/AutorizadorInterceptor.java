package br.com.caelum.tarefas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest req,
			HttpServletResponse res, Object controller) throws Exception {
		
		String uri = req.getRequestURI();
		if (uri.endsWith("login") || uri.endsWith("autentica") 
						|| uri.contains("imagens")){
			return true;
		}
		
		if (req.getSession().getAttribute("usrlogado") != null){
			return true;
		}
		
		
		
		res.sendRedirect("login");
		return false;
	}

}
