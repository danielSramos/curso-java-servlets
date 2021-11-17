package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class AlteraEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Alterando os dados da empresa");
		Banco banco = new Banco();

		Integer id = Integer.valueOf(request.getParameter("id"));
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("data");

		Date dtAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dtAbertura = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		banco.atualizaEmpresa(id, nomeEmpresa, dtAbertura);

//		response.sendRedirect("entrada?acao=listaEmpresas");
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
