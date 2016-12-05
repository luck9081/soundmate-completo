package ar.edu.grupoesfera.cursospring.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.BusquedaService;
import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Controller
public class BusquedaController {
	
	//Setter para servicio mockeado en testeos
	public void setBusquedaServiceMock(BusquedaService busquedaServiceMock) {
		this.busquedaService=busquedaServiceMock;
}
	
	@Inject
	public BusquedaService busquedaService;	// Añado la interface como atributo del controlador
	
	@RequestMapping(path="/busqueda")
	public ModelAndView search(){
		
		ModelMap search = new ModelMap();
		Busqueda busqueda = new Busqueda();
		search.addAttribute(busqueda);
		
		return new ModelAndView("busqueda", search);
		
	}
	
	@RequestMapping(path="/resultadoBusqueda", method = RequestMethod.POST)
	public ModelAndView busquedaRol(@ModelAttribute("busqueda") Busqueda busqueda, HttpServletRequest request){
		
		// Pasamos al servicio el objeto "busqueda" de tipo "Busqueda" y el nombre de usuario, y obtenemos una lista de Usuarios
		// con la lista de resultados de usuarios del instrumento buscado
		
		List<Usuario> listaResultados = busquedaService.buscarUsuariosPorInstrumentoYUbicacion(busqueda,(String)request.getSession().getAttribute("username"));
		
		ModelMap resultado = new ModelMap();
		
		if(!listaResultados.isEmpty()){
			resultado.addAttribute("resultados",listaResultados);
			
			return new ModelAndView("resultadoBusqueda",resultado);
		}
		
		else {
			resultado.addAttribute("title","Busqueda");
			resultado.addAttribute("titulo","No se han encontrado resultados");
			resultado.addAttribute("subtitulo","No te preocupes, pronto se registraran usuarios que cumplan con tu requisito. Intenta otra busqueda.");
			resultado.addAttribute("inputValue","Volver a Busqueda");
			resultado.addAttribute("inputHref","busqueda");
			resultado.addAttribute("iconClass","fa fa-chevron-left");
			
			return new ModelAndView("landing",resultado);
		}
	}

	
	
}
