package ar.edu.grupoesfera.cursospring.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.RegistroDAOService;
import ar.edu.grupoesfera.cursospring.interfaces.BusquedaService;
import ar.edu.grupoesfera.cursospring.interfaces.RegistroService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
@Transactional
public class RegistroServiceImpl implements RegistroService {
	
	@Inject
	public RegistroDAOService registroDAOService;
	
	@Inject
	public BusquedaService busquedaService;
	
	@Override
	public Boolean registrarUsuario(Usuario usuario){
		
		String regex1 = "\\s*\\bPartido";
		String regex2 = "\\s*\\bProvince";
		
		usuario.setPartido(usuario.getPartido().replaceAll(regex1, ""));
		usuario.setProvincia(usuario.getProvincia().replaceAll(regex2, ""));
		usuario.setImagen("default-avatar.png");
		
		List<Usuario> listaResultados = busquedaService.buscarUsuariosPorNombreOEmail(usuario.getNombre(),usuario.getEmail());
		
		if(listaResultados.isEmpty()){
			registroDAOService.registrarUsuario(usuario);
			return true;
		}
		
		else{
			return false;
		}
	}
	
	@Override
	public Usuario loguearUsuario(Usuario usuario){
		
		Usuario resultado = busquedaService.buscarUsuariosPorNombreYContrasenia(usuario.getNombre(),usuario.getPass());
		
		return resultado;
	}
}
