package ar.edu.grupoesfera.cursospring.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.RegistroService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public class TestLoguearse {

	
	@Test
	public void testUsuarioYContraseniaCorrectosDebenLlevarAPerfil(){
		
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		
		
				
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre("luck");
		usuario.setPass("pass");
		
		
		
		Usuario usuarioResultado = new Usuario();
		
		usuario.setIdusuario(1);
		usuario.setNombre("luck");
		usuario.setPass("pass");
		usuario.setEmail("luck@hotmail.com");
		usuario.setInstrumento("guitarra");
		usuario.setImagen("asd");
		usuario.setLocalidad("asd");
		usuario.setPartido("ads");
		usuario.setProvincia("asd");
		
		
		
		
		RegistroService serviceMock = mock(RegistroService.class);
		when(serviceMock.loguearUsuario(usuario)).thenReturn(usuarioResultado);
		
		
		
		
		
		RegistroController controlador = new RegistroController();
		controlador.setRegistroServiceMock(serviceMock);
		
		
		
		ModelAndView resultado = controlador.ingresoUsuario(usuario,requestMock);
		


		assertThat(resultado.getViewName()).isEqualTo("redirect:/perfil");
		
		
	}
	
	@Test
	public void testUsuarioYContraseniaIorrectosDebenIrALanding(){
		
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		
		
				
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre("luck");
		usuario.setPass("pass");

		
		
		
		
		RegistroService serviceMock = mock(RegistroService.class);
		when(serviceMock.loguearUsuario(usuario)).thenReturn(null);
		
		
		
		
		
		RegistroController controlador = new RegistroController();
		controlador.setRegistroServiceMock(serviceMock);
		
		
		
		ModelAndView resultado = controlador.ingresoUsuario(usuario,requestMock);
		


		assertThat(resultado.getViewName()).isEqualTo("landing");
		
		
	}
}
