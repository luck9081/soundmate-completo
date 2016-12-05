package ar.edu.grupoesfera.cursospring.dao;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.SpringTest;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public class PerfilDaoTest extends SpringTest {
	
	@Inject
	PerfilDAOService perfilDaoService;
	
	@Test
	@Rollback @Transactional
	public void testEditarPerfil(){
		
		Usuario usuario = new Usuario();
		
		//usuario.setIdusuario(1);
		usuario.setNombre("username");
		usuario.setPass("hola");
		usuario.setEmail("mail@user.com");
		usuario.setInstrumento("bajo");
		usuario.setLocalidad("San Justo");
		usuario.setPartido("La Matanza");
		usuario.setProvincia("Buenos Aires");
		usuario.setInfluencias("banda");
		usuario.setImagen("img");

		
		
		getSession().save(usuario);
		
		Usuario usuarioEditado = new Usuario();
		
	
		usuarioEditado.setNombre("username");
		usuarioEditado.setPass("holaasd");
		usuarioEditado.setEmail("mailasdasd@user.com");
		usuarioEditado.setInstrumento("bajo");
		usuarioEditado.setLocalidad("San Justo5");
		usuarioEditado.setPartido("La Matanza4");
		usuarioEditado.setProvincia("Buenos Airesa");
		usuarioEditado.setInfluencias("banda2");
		
		
		String flag =perfilDaoService.editarPerfil(usuarioEditado, usuario.getNombre(), usuario.getEmail());
		
		assertThat(flag).isEqualTo("success");
		
		
		
	}
	
	@Test
	@Rollback @Transactional
	public void testEditarNombredePerfilAUnoYaExistenteDaError(){
		
		Usuario usuario = new Usuario();
		
		//usuario.setIdusuario(1);
		usuario.setNombre("username");
		usuario.setPass("hola");
		usuario.setEmail("mail@user.com");
		usuario.setInstrumento("bajo");
		usuario.setLocalidad("San Justo");
		usuario.setPartido("La Matanza");
		usuario.setProvincia("Buenos Aires");
		usuario.setInfluencias("banda");
		usuario.setImagen("img");

		
		Usuario usuario2 = new Usuario();
		
		//usuario.setIdusuario(1);
		usuario2.setNombre("pepe");
		usuario2.setPass("hola");
		usuario2.setEmail("pepe@user.com");
		usuario2.setInstrumento("bajo");
		usuario2.setLocalidad("San Justo");
		usuario2.setPartido("La Matanza");
		usuario2.setProvincia("Buenos Aires");
		usuario2.setInfluencias("banda");
		usuario2.setImagen("img");

		
		
		getSession().save(usuario);
		getSession().save(usuario2);
		
		Usuario usuarioEditado = new Usuario();
		
	
		usuarioEditado.setNombre("pepe");
		usuarioEditado.setPass("holaasd");
		usuarioEditado.setEmail("mailasdasd@user.com");
		usuarioEditado.setInstrumento("bajista");
		usuarioEditado.setLocalidad("San Justo5");
		usuarioEditado.setPartido("La Matanza4");
		usuarioEditado.setProvincia("Buenos Airesa");
		usuarioEditado.setInfluencias("banda2");
		
		
		String flag1 =perfilDaoService.editarPerfil(usuarioEditado, usuario.getNombre(), usuario.getEmail());
		
		
		
		assertThat(flag1).isEqualTo("fail");
		
		
		
	}
	
	
	
	
	
	
	@Test
	@Rollback @Transactional
	public void obtenerBandaPorNombreTest(){
		
		Banda banda = new Banda();
		banda.setGenero("rock");
		banda.setNombre("banda");
		
		getSession().save(banda);
		
		Banda banda2=new Banda();
		banda2=perfilDaoService.obtenerBandaPorNombre(banda.getNombre());
		
		assertThat(banda).isEqualTo(banda2);
	}
	
	public void obtenerUsuarioPorNombre(){
		
		Usuario usuario = new Usuario();
		usuario.setNombre("username");
		usuario.setPass("hola");
		usuario.setEmail("mail@user.com");
		usuario.setInstrumento("bajo");
		usuario.setLocalidad("San Justo");
		usuario.setPartido("La Matanza");
		usuario.setProvincia("Buenos Aires");
		usuario.setInfluencias("banda");
		usuario.setImagen("img");

		
		getSession().save(usuario);
		
		Usuario usuarioObtenido = new Usuario();
		
		usuarioObtenido=perfilDaoService.obtenerUsuarioPorNombre(usuario.getNombre());
		
		assertThat(usuario).isEqualTo(usuarioObtenido);
		
	}

}
