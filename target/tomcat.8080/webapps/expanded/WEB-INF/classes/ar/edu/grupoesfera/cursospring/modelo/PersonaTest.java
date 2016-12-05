package ar.edu.grupoesfera.cursospring.modelo;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

public class PersonaTest extends SpringTest {
	
	@Test
	@Transactional @Rollback
	public void testPersona(){
		
		Usuario seba = new Usuario();
		seba.setNombre("sebastian");
		
		Session s = getSession();
		
		s.save(seba);
		
		assertThat(s.get(Usuario.class,seba.getIdusuario())).isNotNull();
		
	}

}
