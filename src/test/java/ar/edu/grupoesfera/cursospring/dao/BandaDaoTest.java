package ar.edu.grupoesfera.cursospring.dao;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.SpringTest;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;
import static org.assertj.core.api.Assertions.*;



public class BandaDaoTest extends SpringTest {
	
	@Inject
	 BandaDaoService bandaDaoService;
	
	@Test @Rollback @Transactional
	public void testConsultarBandaDevuelveBandaExistente(){
		
		
		Banda banda = new Banda();
		
		banda.setGenero("rock");
		banda.setNombre("Programadores");
		banda.setId(1);
		
		getSession().save(banda);
		
		
		Usuario usuario = new Usuario();
		
		usuario.setIdusuario(1);
		usuario.setNombre("username");
		usuario.setPass("hola");
		usuario.setEmail("mail@user.com");
		usuario.setInstrumento("bajo");
		usuario.setLocalidad("San Justo");
		usuario.setPartido("La Matanza");
		usuario.setProvincia("Buenos Aires");
		usuario.setImagen("img");
		usuario.setInfluencias("banda");
		usuario.setBanda(banda);
		
		getSession().save(usuario);
		
		
		
		
		getSession().save(banda);
		
		Banda bandaResultado = bandaDaoService.consultarBandas("username");
		
		assertThat(banda).isEqualTo(bandaResultado);
	}
	
	
	@Test
	@Rollback @Transactional
	public void testCrearBandaYConsultarBanda(){
		
		Banda banda = new Banda();
		
		banda.setNombre("metallica");
		banda.setGenero("rock");
		//banda.setId(1);
		
		
		Usuario usuario = new Usuario();
		
		usuario.setIdusuario(1);
		usuario.setNombre("username");
		usuario.setPass("hola");
		usuario.setEmail("mail@user.com");
		usuario.setInstrumento("bajo");
		usuario.setLocalidad("San Justo");
		usuario.setPartido("La Matanza");
		usuario.setProvincia("Buenos Aires");
		usuario.setImagen("img");
		usuario.setInfluencias("banda");
		//usuario.setBanda(banda);
		
		getSession().save(usuario);
		
		String nombreUsuario = usuario.getNombre();
		
		bandaDaoService.crearNuevaBanda(banda, nombreUsuario);
		
		Banda bandaResultado = bandaDaoService.consultarBandas(nombreUsuario);
		
		assertThat(banda).isEqualTo(bandaResultado);

		
		
	}
	
	@Test
	@Rollback @Transactional
	public void testConsultarMiembros(){
		
		Banda banda = new Banda();
		banda.setGenero("experimental");
		banda.setNombre("programadores");
		banda.setId(1);
		
		getSession().save(banda);
		
		Usuario usuario = new Usuario();
		
		usuario.setIdusuario(1);
		usuario.setNombre("username");
		usuario.setPass("hola");
		usuario.setEmail("mail@user.com");
		usuario.setInstrumento("bajo");
		usuario.setLocalidad("San Justo");
		usuario.setPartido("La Matanza");
		usuario.setProvincia("Buenos Aires");
		usuario.setImagen("img");
		usuario.setInfluencias("banda");
		usuario.setBanda(banda);
		
		getSession().save(usuario);
		
		Usuario otroUsuario = new Usuario();
		
		otroUsuario.setIdusuario(1);
		otroUsuario.setNombre("username2");
		otroUsuario.setPass("chau");
		otroUsuario.setEmail("mail@user2.com");
		otroUsuario.setInstrumento("contrabajo");
		otroUsuario.setLocalidad("San Justo");
		otroUsuario.setPartido("La Matanza");
		otroUsuario.setProvincia("Buenos Aires");
		otroUsuario.setImagen("img2");
		otroUsuario.setInfluencias("pink floyd");
		otroUsuario.setBanda(banda);
		
		getSession().save(otroUsuario);
		
		List<Usuario> listaDeMiembros;
		
		listaDeMiembros = bandaDaoService.consultarMiembros(banda);
		
		assertThat(listaDeMiembros).isNotEmpty();
		assertThat(listaDeMiembros).hasSize(2);
		
	
		
		
		
		
		
	}
	
	public void testAniadirABanda(){
		
		Banda banda = new Banda();
		banda.setGenero("experimental");
		banda.setNombre("programadores");
		banda.setId(1);
		
		Banda otraBanda = new Banda();
		otraBanda.setGenero("trash");
		otraBanda.setNombre("webDevelopers");
		otraBanda.setId(2);
		
		getSession().save(banda);
		
		getSession().save(otraBanda);
		
		Usuario usuario = new Usuario();
		
		usuario.setIdusuario(1);
		usuario.setNombre("username");
		usuario.setPass("hola");
		usuario.setEmail("mail@user.com");
		usuario.setInstrumento("bajo");
		usuario.setLocalidad("San Justo");
		usuario.setPartido("La Matanza");
		usuario.setProvincia("Buenos Aires");
		usuario.setImagen("img");
		usuario.setInfluencias("banda");
		
		getSession().save(usuario);
		
		bandaDaoService.aniadirABanda(usuario.getNombre(), banda);
		
		assertThat(usuario.getBanda()).isEqualTo(banda);
		assertThat(usuario.getBanda()).isNotEqualTo(otraBanda);
	}
	
}

