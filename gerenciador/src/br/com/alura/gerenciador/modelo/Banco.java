package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Oxebank");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("daniel");
		u1.setSenha("1234");
		
		Usuario u2 = new Usuario();
		u2.setLogin("bia");
		u2.setSenha("123");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
		
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}
	
	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) return empresa;
		}
		return null;
	}
	
	public void atualizaEmpresa(Integer id, String nome, Date data) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				emp.setNome(nome);
				emp.setDataAbertura(data);
			}
		}
	}

	public void remove(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Usuario verificaUsuario(String login, String senha) {
		for(Usuario usuario : listaUsuarios) {
			if(usuario.autentica(login, senha)) { 
				return usuario;
			}
		}
		return null;
	}
}
