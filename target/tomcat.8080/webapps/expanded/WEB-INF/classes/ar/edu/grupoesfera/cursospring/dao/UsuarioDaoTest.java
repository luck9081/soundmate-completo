package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dto.ListadoBandasDTO;
import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.SpringTest;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;
import static org.assertj.core.api.Assertions.*;

public class UsuarioDaoTest extends SpringTest{

	@Inject
	private UsuarioDao dao;
	
	@Test @Transactional
	public void testBuscarUsuarioBandaPorEmail(){
		Banda b = new Banda();
		b.setNombre("Matellica");
		Usuario u = new Usuario();
		u.setBanda(b);
		u.setNombre("Sebastian");
		u.setEmail("seba@seba.com");
		u.setInstrumento("oboe");
		getSession().save(u);
		
		List<ListadoBandasDTO> lista = dao.buscarUsuarioBandaPor("seba@seba.com");
		assertThat(lista).isNotEmpty();
		assertThat(lista).hasSize(1);
	}
}
