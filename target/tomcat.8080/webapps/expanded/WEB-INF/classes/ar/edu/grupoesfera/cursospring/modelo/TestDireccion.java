package ar.edu.grupoesfera.cursospring.modelo;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class TestDireccion extends SpringTest {
	
	@Test
	@Transactional
	@Rollback
	public void testearRelacion1a1EntreFarmaciaYDireccion(){
		
		Direccion miDireccion=new Direccion();
		Barrio miBarrio = new Barrio();
		
		miDireccion.setPuerta(2);
		miDireccion.setCalle("Arieta");
		miDireccion.setBarrio(miBarrio);
		
		Session s = getSession();
		
		s.save(miDireccion);
		
		assertThat(s.get(Direccion.class,miDireccion.getId())).isNotNull();
	}

}
