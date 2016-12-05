package ar.edu.grupoesfera.cursospring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
@Transactional
public class BusquedaDAOServiceImpl implements BusquedaDAOService{
	
	@Inject
    private SessionFactory sessionFactory;
	
	
	/* ------- BUSQUEDA POR INSTRUMENTO Y UBICACION -------- */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarUsuariosPorInstrumentoYUbicacion(Busqueda busqueda, String nombre){
		
		List<Usuario> resultadoFinal = new ArrayList<Usuario>();
		
		resultadoFinal.addAll(
				(List<Usuario>)sessionFactory.getCurrentSession()
					.createCriteria(Usuario.class)
					.add(
							Restrictions.and(
									Restrictions.not(Restrictions.eq("nombre",nombre)),
									Restrictions.eq("instrumento",busqueda.getInstrumento().toLowerCase()),
									Restrictions.like("localidad",busqueda.getLocalidad()),
									Restrictions.like("partido",busqueda.getPartido()),
									Restrictions.like("provincia",busqueda.getProvincia())
							)
					)
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("idusuario"),"idusuario")
							.add(Projections.property("nombre"),"nombre")
							.add(Projections.property("instrumento"),"instrumento")
							.add(Projections.property("localidad"),"localidad")
							.add(Projections.property("partido"),"partido")
							.add(Projections.property("provincia"),"provincia")
					)
					.setResultTransformer(Transformers.aliasToBean(Usuario.class))
					.list()
		);
		
		resultadoFinal.addAll(
				(List<Usuario>)sessionFactory.getCurrentSession()
					.createCriteria(Usuario.class)
					.add(
							Restrictions.and(
									Restrictions.not(Restrictions.eq("nombre",nombre)),
									Restrictions.not(Restrictions.eq("localidad",busqueda.getLocalidad())),
									Restrictions.eq("instrumento",busqueda.getInstrumento().toLowerCase()),
									Restrictions.like("partido",busqueda.getPartido()),
									Restrictions.like("provincia",busqueda.getProvincia())
							)
					)
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("idusuario"),"idusuario")
							.add(Projections.property("nombre"),"nombre")
							.add(Projections.property("instrumento"),"instrumento")
							.add(Projections.property("localidad"),"localidad")
							.add(Projections.property("partido"),"partido")
							.add(Projections.property("provincia"),"provincia")
					)
					.setResultTransformer(Transformers.aliasToBean(Usuario.class))
					.list()
		);
		
		resultadoFinal.addAll(
				(List<Usuario>)sessionFactory.getCurrentSession()
					.createCriteria(Usuario.class)
					.add(
							Restrictions.and(
									Restrictions.not(Restrictions.eq("nombre",nombre)),
									Restrictions.not(Restrictions.eq("localidad",busqueda.getLocalidad())),
									Restrictions.not(Restrictions.eq("partido",busqueda.getPartido())),
									Restrictions.eq("instrumento",busqueda.getInstrumento().toLowerCase()),
									Restrictions.like("provincia",busqueda.getProvincia())
							)
					)
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("idusuario"),"idusuario")
							.add(Projections.property("nombre"),"nombre")
							.add(Projections.property("instrumento"),"instrumento")
							.add(Projections.property("localidad"),"localidad")
							.add(Projections.property("partido"),"partido")
							.add(Projections.property("provincia"),"provincia")
					)
					.setResultTransformer(Transformers.aliasToBean(Usuario.class))
					.list()
		);
		
		resultadoFinal.addAll(
				(List<Usuario>)sessionFactory.getCurrentSession()
					.createCriteria(Usuario.class)
					.add(
							Restrictions.and(
									Restrictions.not(Restrictions.eq("nombre",nombre)),
									Restrictions.not(Restrictions.eq("localidad",busqueda.getLocalidad())),
									Restrictions.not(Restrictions.eq("partido",busqueda.getPartido())),
									Restrictions.not(Restrictions.eq("provincia",busqueda.getPartido())),
									Restrictions.eq("instrumento",busqueda.getInstrumento().toLowerCase())
							)
					)
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("idusuario"),"idusuario")
							.add(Projections.property("nombre"),"nombre")
							.add(Projections.property("instrumento"),"instrumento")
							.add(Projections.property("localidad"),"localidad")
							.add(Projections.property("partido"),"partido")
							.add(Projections.property("provincia"),"provincia")
					)
					.setResultTransformer(Transformers.aliasToBean(Usuario.class))
					.list()
		);
		
		return resultadoFinal;
	}
	
	/* ------- BUSQUEDA POR NOMBRE O EMAIL -------- */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarUsuariosPorNombreOEmail(String nombre, String email){
		
		return sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(
						Restrictions.or(
								Restrictions.eq("nombre",nombre),
								Restrictions.eq("email",email)
						)
				)
				.list();
	}
	
/* ------- BUSQUEDA POR NOMBRE Y CONTRASEniA -------- */
	
	@Override
	public Usuario buscarUsuariosPorNombreYContrasenia(String nombre, String pass){
		
		return (Usuario)sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(
						Restrictions.and(
								Restrictions.eq("nombre",nombre),
								Restrictions.eq("pass",pass)
						)
				)
				.uniqueResult();
	}

}