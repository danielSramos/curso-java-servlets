package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Mostrando dados da empresa");
		String paramID = request.getParameter("id");
		Integer id = Integer.valueOf(paramID);

		Banco banco = new Banco();

		Empresa empresa = banco.buscaEmpresaPeloId(id);

		System.out.println(empresa.getNome());

		request.setAttribute("empresa", empresa);
//		request.getRequestDispatcher("/alteraEmpresa.jsp").forward(request, response);
		
		return "foward:/alteraEmpresa.jsp";

	}
}
