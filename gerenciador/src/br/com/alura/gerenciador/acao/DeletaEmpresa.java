package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class DeletaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("Deletando os dados da empresa");
		
		Integer remove = Integer.valueOf(request.getParameter("id"));
		Banco banco = new Banco();
		banco.remove(remove);

//		response.sendRedirect("entrada?acao=listaEmpresas");
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
