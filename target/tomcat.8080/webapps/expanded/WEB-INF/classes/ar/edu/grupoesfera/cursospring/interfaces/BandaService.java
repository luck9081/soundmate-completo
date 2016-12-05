package ar.edu.grupoesfera.cursospring.interfaces;

import java.util.List;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface BandaService {
	
	public void registrarBanda(Banda banda,String nombreUsuario);
	
	public Banda consultarBandas(String nombre);
	
	public List<Usuario> consultarMiembros(Banda banda);
	
	public void aniadirABanda(String nombreUsuario,Banda banda);
	
	public void eliminarUsuarioDeBanda (String nombreUsuario);
	
}
