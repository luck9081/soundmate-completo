package ar.edu.grupoesfera.cursospring.controladores;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.BusquedaService;
import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;


public class TestBusqueda {
	//BUSQUEDA ROL CONTROLLER SI HAY RESULTADOS
	@Test
	public void busquedaRolControllerMeDebeLLevarALaVistaResultadoBusquedaSiHayResultados(){
		
		Busqueda busqueda = new Busqueda();
		
		busqueda.setInstrumento("bajista");
		busqueda.setLocalidad("moron");
		busqueda.setPartido("moron");
		busqueda.setProvincia("Buenos Aires");
		
		Banda banda = new Banda();
		
		Usuario usuario = new Usuario ();

		usuario.setNombre("rodrigo1990");
		usuario.setEmail("mcd77.1990@gmail.com");
		usuario.setBanda(banda);
		usuario.setImagen("rodri.jpg");
		usuario.setIdusuario(1);
		usuario.setInfluencias("rock");
		usuario.setInstrumento("bajista");
		usuario.setPartido("moron");
		usuario.setLocalidad("moron");
		usuario.setPass("1990");
		usuario.setProvincia("Buenos Aires");
		
		List<Usuario> listaDeUsuarios=Arrays.asList(usuario);;
		
		
		String nombreUsuario=usuario.getNombre();
		
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		when(requestMock.getSession().getAttribute("username")).thenReturn("rodrigo1990");
		
		BusquedaService busquedaServiceMock = mock(BusquedaService.class);
		when(busquedaServiceMock.buscarUsuariosPorInstrumentoYUbicacion(busqueda, nombreUsuario)).thenReturn(listaDeUsuarios);
		
		BusquedaController controller = new BusquedaController();
		controller.setBusquedaServiceMock(busquedaServiceMock);
		
		ModelAndView mav = new ModelAndView();
		
		mav=controller.busquedaRol(busqueda, requestMock);
		
		assertThat(mav.getViewName()).isEqualTo("resultadoBusqueda");
		assertThat(mav.getViewName()).isNotEqualTo("landing");
		
		
		
		
		
	}
	
	//BUSQUEDA ROL CONTROLLER SI NO HAY RESULTADOS
	@Test
	public void busquedaRolControllerMeDebeLLevarALaVistaLandingSiNoHayResultados(){
		
		Busqueda busqueda = new Busqueda();
		
		busqueda.setInstrumento("bajista");
		busqueda.setLocalidad("moron");
		busqueda.setPartido("moron");
		busqueda.setProvincia("Buenos Aires");
		
		Banda banda = new Banda();
		
		Usuario usuario = new Usuario ();

		usuario.setNombre("rodrigo1990");
		usuario.setEmail("mcd77.1990@gmail.com");
		usuario.setBanda(banda);
		usuario.setImagen("rodri.jpg");
		usuario.setIdusuario(1);
		usuario.setInfluencias("rock");
		usuario.setInstrumento("guitarrista");
		usuario.setPartido("merlo gomez");
		usuario.setLocalidad("libertador");
		usuario.setPass("1990");
		usuario.setProvincia("San Juan");
		
		
		List<Usuario> listaDeUsuarios = new ArrayList() ;
		
		
		String nombreUsuario=usuario.getNombre();
		
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		when(requestMock.getSession().getAttribute("username")).thenReturn("rodrigo1990");
		
		BusquedaService busquedaServiceMock = mock(BusquedaService.class);
		when(busquedaServiceMock.buscarUsuariosPorInstrumentoYUbicacion(busqueda, nombreUsuario)).thenReturn(listaDeUsuarios);
		
		BusquedaController controller = new BusquedaController();
		controller.setBusquedaServiceMock(busquedaServiceMock);
		
		ModelAndView mav = new ModelAndView();
		
		mav=controller.busquedaRol(busqueda, requestMock);
		
		assertThat(mav.getViewName()).isEqualTo("landing");
		assertThat(mav.getViewName()).isNotEqualTo("resultadoBusqueda");
		
		
		
		
		
	}
	

	
	
}