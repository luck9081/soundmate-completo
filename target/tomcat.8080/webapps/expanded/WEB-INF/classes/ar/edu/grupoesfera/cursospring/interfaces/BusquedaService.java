package ar.edu.grupoesfera.cursospring.interfaces;

import java.util.List;
import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface BusquedaService {
	public List<Usuario> buscarUsuariosPorInstrumentoYUbicacion(Busqueda busqueda, String nombre);
	
	public List<Usuario> buscarUsuariosPorNombreOEmail(String nombre, String email);
	
	public Usuario buscarUsuariosPorNombreYContrasenia(String nombre, String pass);
}
