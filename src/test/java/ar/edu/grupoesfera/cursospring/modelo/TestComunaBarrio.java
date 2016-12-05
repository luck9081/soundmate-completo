package ar.edu.grupoesfera.cursospring.modelo;

import static org.assertj.core.api.Assertions.assertThat;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class TestComunaBarrio extends SpringTest {
	
	@Test
	@Transactional
	@Rollback
	public void testearQueSeSalvoEnLaBaseDeDatosUnComunaConSusBarrios(){
		
		Comuna miComuna = new Comuna();
		Barrio miBarrio1= new Barrio();
		Barrio miBarrio2= new Barrio();
		Barrio miBarrio3= new Barrio();
		
		
		
		Session s = getSession();
		
		s.save(miComuna);
		
		assertThat(s.get(Comuna.class,miComuna.getId())).isNotNull();
		
	}

}