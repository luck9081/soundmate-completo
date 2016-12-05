package ar.edu.grupoesfera.cursospring.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.RegistroService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public class TestRegistrarse {
	
	@Test
	public void testQueRegistraUnNuevoUsuarioYLlevaALandingDeConfirmacion() {
		
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		
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
		
		
		RegistroService servicioMock = mock(RegistroService.class);
		when(servicioMock.registrarUsuario(usuario)).thenReturn(true);
		
		RegistroController registroDeUSer = new RegistroController();
		
		
		registroDeUSer.setRegistroServiceMock(servicioMock);
		
		ModelMap resultado = new ModelMap();
		
		
		resultado.addAttribute("titulo","Ya estas registrado");
		
		
		ModelAndView mav = registroDeUSer.crearUsuario(usuario, requestMock);
		
		
		assertThat(mav.getViewName()).isEqualTo("landing");
		assertThat(mav.getModel().get("titulo")).isEqualTo("Ya estas registrado").toString();
		
	}

}
