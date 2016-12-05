package ar.edu.grupoesfera.cursospring.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dto.ListadoBandasDTO;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service("usuarioDao") @Transactional
public class UsuarioDaoImpl implements UsuarioDao{

	@Inject
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ListadoBandasDTO> buscarUsuarioBandaPor(String email) {
		
		List<String> ll = new LinkedList<>();
		List<String> ll2 = new ArrayList<>();
		
		return factory.getCurrentSession().createCriteria(Usuario.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("nombre"), "nombreUsuario")
						.add(Projections.property("b.nombre"), "nombreBanda")
						)
				.createAlias("banda", "b")
				.add(Restrictions.eq("email", email))
				.setResultTransformer(Transformers.aliasToBean(ListadoBandasDTO.class))
				.list();
	}
	
	
}
