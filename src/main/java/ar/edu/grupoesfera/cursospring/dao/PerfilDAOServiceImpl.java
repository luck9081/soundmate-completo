package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
@Transactional
public class PerfilDAOServiceImpl implements PerfilDAOService {
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Usuario obtenerUsuarioPorNombre (String nombreUsuario){
		
		return (Usuario)sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("nombre",nombreUsuario))
				.uniqueResult();
	}
	

	@Override
	public Banda obtenerBandaPorNombre (String nombreBanda){
		
		@SuppressWarnings("rawtypes")
		List resultadosQuery = sessionFactory.getCurrentSession()
				.createCriteria(Banda.class)
				.add(Restrictions.eq("nombre",nombreBanda)).list();
		
		Banda miBanda = new Banda();
		
		for(Object item : resultadosQuery){
			miBanda = (Banda)item;
		}
		
		return miBanda;
	}
	
	@Override
	public String editarPerfil (Usuario usuarioEditado,String nombreUsuarioActual, String emailActual){
		
		Usuario usuario = new Usuario();
		
		if(usuarioEditado.getNombre().equals(nombreUsuarioActual) && usuarioEditado.getEmail().equals(emailActual)){
			usuario = (Usuario)sessionFactory.getCurrentSession()
					.createCriteria(Usuario.class)
					.add(
							Restrictions.and(
									Restrictions.eq("nombre",nombreUsuarioActual),
									Restrictions.eq("email",emailActual)
							)							
						)
					.uniqueResult();
			
			usuario.setNombre(usuarioEditado.getNombre());
			usuario.setPass(usuarioEditado.getPass());
			usuario.setEmail(usuarioEditado.getEmail());
			usuario.setInstrumento(usuarioEditado.getInstrumento());
			usuario.setLocalidad(usuarioEditado.getLocalidad());
			usuario.setPartido(usuarioEditado.getPartido());
			usuario.setProvincia(usuarioEditado.getProvincia());
			usuario.setInfluencias(usuarioEditado.getInfluencias());
			usuario.setImagen(usuario.getImagen());

			
			sessionFactory.getCurrentSession().update("Usuario", usuario);
			
			return "success";
		}
		
		else if(usuarioEditado.getNombre().equals(nombreUsuarioActual) && !usuarioEditado.getEmail().equals(emailActual)){
			usuario = (Usuario)sessionFactory.getCurrentSession()
					.createCriteria(Usuario.class)
					.add(
							Restrictions.and(
									Restrictions.eq("email",usuarioEditado.getEmail()),
									Restrictions.not(Restrictions.eq("nombre", nombreUsuarioActual))
							)						
						)
					.uniqueResult();
			
			if(usuario == null){
				
				usuario = new Usuario();
				
				usuario = (Usuario)sessionFactory.getCurrentSession()
						.createCriteria(Usuario.class)
						.add(
								Restrictions.and(
										Restrictions.eq("nombre",usuarioEditado.getNombre()),
										Restrictions.eq("email",emailActual)
								)							
							)
						.uniqueResult();
				
				usuario.setNombre(usuarioEditado.getNombre());
				usuario.setPass(usuarioEditado.getPass());
				usuario.setEmail(usuarioEditado.getEmail());
				usuario.setInstrumento(usuarioEditado.getInstrumento());
				usuario.setLocalidad(usuarioEditado.getLocalidad());
				usuario.setPartido(usuarioEditado.getPartido());
				usuario.setProvincia(usuarioEditado.getProvincia());
				usuario.setInfluencias(usuarioEditado.getInfluencias());
				usuario.setImagen(usuario.getImagen());
				
				sessionFactory.getCurrentSession().update("Usuario", usuario);
				
				return "success";
			}
			else{
				return "fail";
			}
			
		}
		
		else if(!usuarioEditado.getNombre().equals(nombreUsuarioActual) && usuarioEditado.getEmail().equals(emailActual)){
			usuario = (Usuario)sessionFactory.getCurrentSession()
					.createCriteria(Usuario.class)
					.add(
							Restrictions.and(
									Restrictions.eq("nombre",usuarioEditado.getNombre()),
									Restrictions.not(Restrictions.eq("email", emailActual))
							)
						)
					.uniqueResult();
			
			if(usuario == null){
				usuario = new Usuario();
				
				usuario = (Usuario)sessionFactory.getCurrentSession()
						.createCriteria(Usuario.class)
						.add(
								Restrictions.and(
										Restrictions.eq("nombre",nombreUsuarioActual),
										Restrictions.eq("email",usuarioEditado.getEmail())
								)							
							)
						.uniqueResult();
				
				usuario.setNombre(usuarioEditado.getNombre());
				usuario.setPass(usuarioEditado.getPass());
				usuario.setEmail(usuarioEditado.getEmail());
				usuario.setInstrumento(usuarioEditado.getInstrumento());
				usuario.setLocalidad(usuarioEditado.getLocalidad());
				usuario.setPartido(usuarioEditado.getPartido());
				usuario.setProvincia(usuarioEditado.getProvincia());
				usuario.setInfluencias(usuarioEditado.getInfluencias());
				usuario.setImagen(usuario.getImagen());
				
				sessionFactory.getCurrentSession().update("Usuario", usuario);
				
				return "success";
			}
			else{
				return "fail";
			}
		}
		
		else{
			@SuppressWarnings("unchecked")
			List<Usuario>resultado = (List<Usuario>)sessionFactory.getCurrentSession()
					.createCriteria(Usuario.class)
					.add(
							Restrictions.or(
									Restrictions.eq("nombre",usuarioEditado.getNombre()),
									Restrictions.eq("email",usuarioEditado.getEmail())
							)
							
						)
					.list();
			
			if (resultado.isEmpty() || resultado.equals(null)){
				
				usuario = (Usuario)sessionFactory.getCurrentSession()
						.createCriteria(Usuario.class)
						.add(Restrictions.eq("nombre",nombreUsuarioActual))
						.uniqueResult();
				
				usuario.setNombre(usuarioEditado.getNombre());
				usuario.setPass(usuarioEditado.getPass());
				usuario.setEmail(usuarioEditado.getEmail());
				usuario.setInstrumento(usuarioEditado.getInstrumento());
				usuario.setLocalidad(usuarioEditado.getLocalidad());
				usuario.setPartido(usuarioEditado.getPartido());
				usuario.setProvincia(usuarioEditado.getProvincia());
				usuario.setInfluencias(usuarioEditado.getInfluencias());
				usuario.setImagen(usuario.getImagen());
				
				sessionFactory.getCurrentSession().update("Usuario", usuario);
				
				return "success";
				
			}
			else{
				
				return "fail";	// Si existe un usuario con el mismo nombre/email que al que yo lo quiero cambiar (que no sea mi actual usuario), devuelvo string "nulo".
				
			}
			
		}
		
	}
	
}
