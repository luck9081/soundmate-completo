package ar.edu.grupoesfera.cursospring.dao;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface PerfilDAOService {
	public Usuario obtenerUsuarioPorNombre (String nombreUsuario);
	
	public Banda obtenerBandaPorNombre (String nombreBanda);
	
	public String editarPerfil (Usuario usuario,String nombreUsuarioActual, String emailActual);
}