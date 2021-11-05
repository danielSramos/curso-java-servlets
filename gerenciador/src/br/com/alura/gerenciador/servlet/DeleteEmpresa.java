package br.com.alura.gerenciador.servlet;

import java.io.IOException;
//import java.util.List;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteEmpresa extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer remove = Integer.valueOf(request.getParameter("id"));
		Banco banco = new Banco();
		banco.remove(remove);

		response.sendRedirect("listaEmpresas");
	}
}
