package ar.edu.grupoesfera.cursospring.controladores;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.PerfilService;
import ar.edu.grupoesfera.cursospring.interfaces.PublicacionService;
import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.PublicacionUsuario;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;


public class TestPerfil {
	//perfil controller
	@Test
	public void testearQueSeMuestraElPerfilPropio(){
		
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		when((String)requestMock.getSession().getAttribute("username")).thenReturn("rodrigo1990");
		
	
		
		Usuario usuario = new Usuario ();

		usuario.setNombre("rodrigo1990");
		usuario.setEmail("mcd77.1990@gmail.com");
		usuario.setImagen("rodri.jpg");
		usuario.setIdusuario(1);
		usuario.setInfluencias("rock");
		usuario.setInstrumento("bajista");
		usuario.setPartido("moron");
		usuario.setLocalidad("moron");
		usuario.setPass("1990");
		usuario.setProvincia("Buenos Aires");
		
		String nombreUsuario=usuario.getNombre();
		
		PerfilService perfilServiceMock=mock(PerfilService.class);
		when(perfilServiceMock.buscarPerfilUsuario(nombreUsuario)).thenReturn(usuario);
		
		PublicacionUsuario publicacionUsuario = new PublicacionUsuario();
		
		publicacionUsuario.setDescripcion("hola mundo");
		publicacionUsuario.setId(1);
		publicacionUsuario.setUsuario(usuario);
		publicacionUsuario.setVideo("www.youtube.com/TheBeattles");
		publicacionUsuario.setFechaPublicacion(null);
		
		List<PublicacionUsuario> listaPublicacionUsuario=Arrays.asList(publicacionUsuario);
		
		PublicacionService publicacionServiceMock=mock(PublicacionService.class);
		when(publicacionServiceMock.mostrarPublicacionesUsuario(nombreUsuario)).thenReturn(listaPublicacionUsuario);
		
		PerfilController controller = new PerfilController();
		controller.setPerfilServiceMock(perfilServiceMock);
		controller.setPublicacionServiceMock(publicacionServiceMock);
		
		ModelAndView mav = new ModelAndView();
		
		mav=controller.perfil(requestMock);
		
		assertThat(mav.getViewName()).isEqualTo("profile");
		
		
		
		
		
		
		
	}

}
