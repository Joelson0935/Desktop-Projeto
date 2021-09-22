package br.com.casa.view;

import br.com.casa.dao.Dao;
import br.com.casa.domain.Usuario;

public class SaidaUsuario {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {

		Dao<Usuario> dao = new Dao<Usuario>(Usuario.class);

//		List<Usuario> usuarios = new ArrayList<Usuario>();

		Usuario usuario = new Usuario("Edy", "edilene", true);

		dao.salvar(usuario);

		System.out.println(usuario.toString());

		dao.fecharEM();
	}

}
