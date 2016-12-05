package ar.edu.grupoesfera.cursospring.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.BusquedaDAOService;
import ar.edu.grupoesfera.cursospring.interfaces.BusquedaService;
import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
@Transactional
public class BusquedaServiceImpl implements BusquedaService {
	
	@Inject
	public BusquedaDAOService busquedaDAO;
	
	@Override
	public List<Usuario> buscarUsuariosPorInstrumentoYUbicacion(Busqueda busqueda, String nombre) {		// Recibo el tipo de busqueda que debo efectuar
		// TODO Auto-generated method stub		
		
		// Defino la coleccion de usuarios de tipo "Usuario" que contendra los usuarios resultados de la busqueda, y se los asigno
		
		List<Usuario> listaResultados = busquedaDAO.buscarUsuariosPorInstrumentoYUbicacion(busqueda,nombre);
		
		return listaResultados;		// Retorno la lista de resultados
	}
	
	@Override
	public List<Usuario> buscarUsuariosPorNombreOEmail(String nombre, String email) {
		// TODO Auto-generated method stub		
		
		List<Usuario> listaResultados = busquedaDAO.buscarUsuariosPorNombreOEmail(nombre, email);
		
		return listaResultados;
	}
	
	@Override
	public Usuario buscarUsuariosPorNombreYContrasenia(String nombre, String pass) {
		// TODO Auto-generated method stub
		
		Usuario resultado = busquedaDAO.buscarUsuariosPorNombreYContrasenia(nombre, pass);
		
		return resultado;
	}

}