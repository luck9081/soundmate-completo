package ar.edu.grupoesfera.cursospring.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.BandaService;
import ar.edu.grupoesfera.cursospring.interfaces.PerfilService;
import ar.edu.grupoesfera.cursospring.interfaces.PublicacionService;
import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Publicacion;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Controller
@Scope("session")
public class BandaController {
	
	@Inject
	public PerfilService perfilService;
	
	@Inject
	public BandaService bandaService;
	
	@Inject
	public PublicacionService publicacionService;
	
	
	//SETTERS PARA SERVICIOS MOCK
	public void setPerfilServiceMock(PerfilService perfilService) {
		this.perfilService = perfilService;
	}
	public void setBandaServiceMock(BandaService bandaService) {
		this.bandaService = bandaService;
	}	
	public void setPublicacionServiceMock(PublicacionService publicacionService){
		this.publicacionService=publicacionService;
	}
	
	
	@RequestMapping(path="/banda/{nombreBanda}")
	public ModelAndView perfilUser(@PathVariable("nombreBanda") String nombreBanda, HttpServletRequest request){
		
		Banda miBanda = perfilService.buscarPerfilBanda(nombreBanda); // A la busqueda de banda le paso el atributo de session (casteado a string).
		Usuario miUsuario = perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username"));

		ModelMap perfilBanda = new ModelMap();

		Publicacion publicacion = new Publicacion();
		
	
		
		perfilBanda.addAttribute(miBanda);
		perfilBanda.addAttribute("reubicacion","../");	// String necesario para que todos los recursos css, js, imagenes y backgrounds tengan su "src" correctamente (a causa del PathVariable)
		List<Publicacion> publicaciones = publicacionService.mostrarPublicaciones(nombreBanda);
		perfilBanda.addAttribute("publicaciones", publicaciones);
		perfilBanda.addAttribute("publicar", publicacion);
		perfilBanda.addAttribute("usuario", miUsuario);
		
		List<Usuario> miembros = bandaService.consultarMiembros(miBanda);
		perfilBanda.addAttribute("miembros", miembros);
		
		return new ModelAndView("banda",perfilBanda);
		
	}
	
	@RequestMapping(path="/mis-bandas")
	public ModelAndView misbandas(HttpServletRequest request){
		
		ModelMap misbandas=new ModelMap();
		Banda banda = bandaService.consultarBandas((String)request.getSession().getAttribute("username"));
		misbandas.addAttribute("banda", banda);
		
		return new ModelAndView("misBandas",misbandas);
	}
	
	
	
	@RequestMapping(path="/registrarBanda", method = RequestMethod.POST)
	public ModelAndView crearBanda(@ModelAttribute("banda") Banda banda, HttpServletRequest request){ 
		
			Usuario miUsuario = perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username"));
			
			String nombreUsuario = miUsuario.getNombre();
			
			bandaService.registrarBanda(banda,nombreUsuario);
						
			
			ModelMap modelCrearBanda = new ModelMap();
			modelCrearBanda.addAttribute("titulo","Banda registrada");
			modelCrearBanda.addAttribute("subtitulo","Haz click en el link de abajo y comienza a disfrutar del increible mundo de Soundmate");
			modelCrearBanda.addAttribute("inputValue","ir a banda");
			modelCrearBanda.addAttribute("inputHref","banda/"+banda.getNombre());
			modelCrearBanda.addAttribute("iconClass","fa fa-chevron-right");
			
			return new ModelAndView("landing", modelCrearBanda);
	}

	
	
	@RequestMapping("/crear-banda")
	public ModelAndView nuevaBanda(){
		ModelMap registroBanda = new ModelMap();
		Banda banda = new Banda();
		registroBanda.addAttribute(banda);
		return new ModelAndView("registroBanda", registroBanda);
	}
	
	
	@RequestMapping(path="/postear/{nombreBanda}" , method = RequestMethod.POST)
	public ModelAndView nuevaPublicacion(@ModelAttribute("publicar") Publicacion publicacion, HttpServletRequest request, @PathVariable("nombreBanda") String nombreBanda){
		publicacionService.crearPublicacion(publicacion,(String)request.getSession().getAttribute("username"), nombreBanda);
		return new ModelAndView("redirect:/banda/"+nombreBanda);
	}
	
	@RequestMapping("perfil/sumarABanda/{username}")
	public ModelAndView sumarABanda(@PathVariable("username") String nombreUsuario,HttpServletRequest request){
	
		Usuario miUsuario = perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username"));
		Banda banda = miUsuario.getBanda();
			if(banda==null){//Si el usuario logueado no tiene banda mostrar mensaje en lading y dirigir a crear banda
				
			
				ModelMap resultado = new ModelMap();
				resultado.addAttribute("title","Aniadir a banda ");
				resultado.addAttribute("titulo","Ups. Todavia no has creado una banda ");
				resultado.addAttribute("subtitulo","Procura crear una para aniadir a tus Soundmates");
				resultado.addAttribute("inputValue","Ir a crear banda");
				resultado.addAttribute("inputHref","../../crear-banda");
				resultado.addAttribute("iconClass","fa fa-chevron-left");
				resultado.addAttribute("reubicacion","../../");
				
				
				return new ModelAndView("landing",resultado);
			}
			else{//Si el usuario logueado tiene una banda aniade al usuario visitado a su propia banda
				bandaService.aniadirABanda(nombreUsuario, banda);
		
		ModelMap resultado2 = new ModelMap();
		resultado2.addAttribute("title","Agregar a banda ");
		resultado2.addAttribute("titulo","Genial, has agregado un nuevo Soundmate a tu banda ");
		resultado2.addAttribute("subtitulo","Sigue navegando y formando nuevas bandas");
		resultado2.addAttribute("inputValue","Ir a mis bandas");
		resultado2.addAttribute("inputHref","../../mis-bandas");
		resultado2.addAttribute("iconClass","fa fa-chevron-left");
		resultado2.addAttribute("reubicacion","../../");
		
		
		return new ModelAndView("landing",resultado2);

	}
			
}
	@RequestMapping("banda/eliminar-user/{username}")
	public ModelAndView emliminarUserDeBanda(@PathVariable("username") String username, HttpServletRequest request){
		
		request.getSession().removeAttribute("banda");
		
		bandaService.eliminarUsuarioDeBanda(username);
		
		
		ModelMap resultado3 = new ModelMap();
		resultado3.addAttribute("title","Eliminarne de banda");
		resultado3.addAttribute("titulo","Listo, te has eliminado tu banda :( ");
		resultado3.addAttribute("subtitulo","Ahora crea tu nueva banda o sumate a otras!");
		resultado3.addAttribute("inputValue","Ir a mis bandas");
		resultado3.addAttribute("inputHref","../../mis-bandas");
		resultado3.addAttribute("iconClass","fa fa-chevron-left");
		resultado3.addAttribute("reubicacion","../../");
		
		return new ModelAndView("landing",resultado3);
	}
	
	@RequestMapping("/banda/{nombreBanda}/agregarseABanda")
	public ModelAndView usuarioSeAgregaABanda(@PathVariable("nombreBanda") String nombreBanda,HttpServletRequest request){
		
		Usuario miUsuario = perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username"));
		Banda banda = perfilService.buscarPerfilBanda(nombreBanda);
		
		String nombreUsuario = miUsuario.getNombre();
		
		bandaService.aniadirABanda(nombreUsuario, banda);
		
		request.getSession().setAttribute("banda", miUsuario.getBanda());
			
		ModelMap resultado = new ModelMap();
		resultado.addAttribute("title","Agregarse a banda ");
		resultado.addAttribute("titulo","Genial, te  has agregado a una nueva  banda ");
		resultado.addAttribute("subtitulo","Sigue navegando en Soundmate");
		resultado.addAttribute("inputValue","Ir a perfil");
		resultado.addAttribute("inputHref","../../perfil");
		resultado.addAttribute("iconClass","fa fa-chevron-left");
		resultado.addAttribute("reubicacion","../../");
		
		request.getSession().setAttribute("banda", miUsuario.getBanda());

		
		return new ModelAndView("landing",resultado);
	
	}


}
