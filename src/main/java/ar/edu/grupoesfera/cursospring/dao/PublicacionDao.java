package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import ar.edu.grupoesfera.cursospring.modelo.Publicacion;
import ar.edu.grupoesfera.cursospring.modelo.PublicacionUsuario;

public interface PublicacionDao {
	
	public void crearPublicacion (Publicacion publicacion, String username, String nombreBanda);
	public List<Publicacion> mostrarPublicaciones (String nombreBanda);
	public void crearPublicacionUsuario (PublicacionUsuario publicacion, String username);
	public List<PublicacionUsuario> mostrarPublicacionesUsuario (String username);
}
