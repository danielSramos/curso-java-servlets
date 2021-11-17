package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.CriaEmpresa;
import br.com.alura.gerenciador.acao.FormNovaEmpresa;
import br.com.alura.gerenciador.acao.DeletaEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;

@WebServlet("/entrada")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		HttpSession sessao = request.getSession();
		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean acaoProtegida =  !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		if (usuarioNaoLogado && acaoProtegida) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}

		
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
//		String comando = null;
//		if (paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			comando = acao.executa(request, response);
//
//		} else if (paramAcao.equals("LriaEmpresa")) {
//			CriaEmpresa acao = new CriaEmpresa();
//			comando = acao.executa(request, response);
//
//		} else if (paramAcao.equals("MostraEmpresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			comando = acao.executa(request, response);
//
//		} else if (paramAcao.equals("DeletaEmpresa")) {
//			DeletaEmpresa acao = new DeletaEmpresa();
//			comando = acao.executa(request, response);
//
//		} else if (paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			comando = acao.executa(request, response);
//
//		} else if (paramAcao.equals("FormNovaEmpresa")) {
//			FormNovaEmpresa acao = new FormNovaEmpresa();
//			comando = acao.executa(request, response);
//		}
	}
}
