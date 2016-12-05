package ar.edu.grupoesfera.cursospring.interfaces;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface RegistroService {
	public Boolean registrarUsuario(Usuario usuario);
	
	public Usuario loguearUsuario(Usuario usuario);
}
