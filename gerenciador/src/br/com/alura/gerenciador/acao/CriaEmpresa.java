package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class CriaEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Criando uma nova empresaaaaaaaaaaaaaaaaaa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("data");

		Date dtAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dtAbertura = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dtAbertura);

		Banco banco = new Banco();
		banco.adiciona(empresa);

//		response.sendRedirect("entrada?acao=listaEmpresas");
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
