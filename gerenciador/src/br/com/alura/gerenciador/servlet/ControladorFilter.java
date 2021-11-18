package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletReponse, FilterChain chain) throws IOException, ServletException {

		@Override
		public void init(FilterConfig filterConfig) throws ServletException {}
		
		@Override
		public void destroy() {}
		
		System.out.println("ControladorFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletReponse;
		
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String nome;

		try {
			Class classeCarregada = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classeCarregada.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String[] acaoComando = nome.split(":");

		if (acaoComando[0].equals("foward")) {
			request.getRequestDispatcher("/WEB-INF/view/" + acaoComando[1]).forward(request, response);
		} else if (acaoComando[0].equals("redirect")) {
			response.sendRedirect(acaoComando[1]);
		}
	}
}
