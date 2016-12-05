package ar.edu.grupoesfera.cursospring.modelo;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class TestFarmacia extends SpringTest {
	
	@Test
	@Transactional
	@Rollback
	public void testearRelacion1a1EntreFarmaciaYDireccion(){
		
		Farmacia miFarmacia = new Farmacia();
		Direccion miDireccion = new Direccion();
		
		miDireccion.setPuerta(2);
		miDireccion.setCalle("Arieta");
		
		miFarmacia.setNombre("FarmaGrosa");
		miFarmacia.setDireccion(miDireccion);
		
		Session s = getSession();
		
		s.save(miFarmacia);
		
		assertThat(s.get(Farmacia.class,miFarmacia.getId())).isNotNull();
	}

}
