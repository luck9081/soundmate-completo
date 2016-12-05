package ar.edu.grupoesfera.cursospring.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.PublicacionDao;
import ar.edu.grupoesfera.cursospring.interfaces.PublicacionService;
import ar.edu.grupoesfera.cursospring.modelo.Publicacion;
import ar.edu.grupoesfera.cursospring.modelo.PublicacionUsuario;

@Service
@Transactional
public class PublicacionServiceImpl implements PublicacionService {
	
	@Inject PublicacionDao publicacionDao;
	
	@Override
	public void crearPublicacion (Publicacion publicacion, String username, String nombreBanda){
		
		if(publicacion.getVideo() != null){
			publicacion.setVideo((publicacion.getVideo().substring(32)));
		}
		
		publicacionDao.crearPublicacion(publicacion, username, nombreBanda);
		
	}
	
	@Override
	public List<Publicacion> mostrarPublicaciones (String nombreBanda){
		
		List<Publicacion> publicaciones = publicacionDao.mostrarPublicaciones(nombreBanda);
		
		return publicaciones;
	}
	
	
	@Override
	public void crearPublicacionUsuario ( PublicacionUsuario publicacion, String username){
		
		if(publicacion.getVideo() != null){
			publicacion.setVideo((publicacion.getVideo().substring(32)));
		}
		
		
		publicacionDao.crearPublicacionUsuario(publicacion, username);
	}
	
	@Override
	public List<PublicacionUsuario> mostrarPublicacionesUsuario (String username){
		
		List<PublicacionUsuario> publicacionesUser = publicacionDao.mostrarPublicacionesUsuario(username);
		
		return publicacionesUser;
	}
}
