package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Publicacion;
import ar.edu.grupoesfera.cursospring.modelo.PublicacionUsuario;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
public class PublicacionDaoImpl implements PublicacionDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public void crearPublicacion (Publicacion publicacion, String username, String nombreBanda){
		
		Usuario usuario =  (Usuario)sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("nombre", username))
				.uniqueResult();
		
		Banda banda = (Banda)sessionFactory.getCurrentSession()
				.createCriteria(Banda.class)
				.add(Restrictions.eq("nombre", nombreBanda))
				.uniqueResult();
		
		publicacion.setUsuario(usuario);
		publicacion.setBanda(banda);
		
		final Session s = sessionFactory.openSession();
		
		s.save(publicacion);		
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacion> mostrarPublicaciones (String nombreBanda){
		
		
		List<Publicacion> publicaciones = sessionFactory.getCurrentSession()
			.createCriteria(Publicacion.class)
			.createAlias("banda", "b")
			.add(Restrictions.eq("b.nombre", nombreBanda ))
			.list();

		
		return publicaciones;
	}
	
	@Override
	public void crearPublicacionUsuario (PublicacionUsuario publicacion, String username){
		
		Usuario usuario =  (Usuario)sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("nombre", username))
				.uniqueResult();
		
		publicacion.setUsuario(usuario);
		
		Session s = sessionFactory.getCurrentSession();
		
		s.save(publicacion);
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PublicacionUsuario> mostrarPublicacionesUsuario (String username){
		
		
		List<PublicacionUsuario> publicacionesUser = sessionFactory.getCurrentSession()
			.createCriteria(PublicacionUsuario.class)
			.createAlias("usuario", "u")
			.add(Restrictions.eq("u.nombre", username ))
			.list();

		
		return publicacionesUser;
	}
	
}
