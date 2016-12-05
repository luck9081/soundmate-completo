package ar.edu.grupoesfera.cursospring.controladores;


//imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.RegistroService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;

@Controller
@Scope("session")
public class RegistroController {
	
	@Inject
	public RegistroService registroService;
	
	
	// Metodo que permite setear el atributo registroService para mockearlo.
	public void setRegistroServiceMock (RegistroService servicioRegistro){
		this.registroService = servicioRegistro;
	}
	
	
	
	@RequestMapping("/signup")
	public ModelAndView signup(){
		
		Usuario usuario = new Usuario();
		
		ModelMap registro = new ModelMap();
		registro.addAttribute(usuario);
		
		return new ModelAndView("signup", registro);
	}
	
	@RequestMapping(path="/registro", method = RequestMethod.POST)
	public ModelAndView crearUsuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request){ 
			
			ModelMap resultado = new ModelMap();
			
			if(registroService.registrarUsuario(usuario)){
				
				resultado.addAttribute("title","Registro");
				resultado.addAttribute("titulo","Ya estas registrado");
				resultado.addAttribute("subtitulo","Hace click en el link de abajo y comenza a disfrutar del increible mundo de Soundmate");
				resultado.addAttribute("inputValue","Continuar");
				resultado.addAttribute("inputHref","login");
				resultado.addAttribute("iconClass","fa fa-chevron-right");
				
				return new ModelAndView("landing",resultado);
			}
			
			else {
				
				resultado.addAttribute("title","Registro");
				resultado.addAttribute("titulo","Ups No ha salido bien");
				resultado.addAttribute("subtitulo","Parece que existe un usuario con mismo nombre/email. No te preocupes, volve a intentarlo.");
				resultado.addAttribute("inputValue","Volver a Registrarse");
				resultado.addAttribute("inputHref","signup");
				resultado.addAttribute("iconClass","fa fa-chevron-left");
				
				return new ModelAndView("landing",resultado);
			}
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		
		Usuario usuario = new Usuario();
		
		ModelMap login = new ModelMap();
		login.addAttribute(usuario);

		return new ModelAndView("login", login);
	}
	
	@RequestMapping(path="/loguearse", method = RequestMethod.POST)
	public ModelAndView ingresoUsuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request){ 
			
			ModelMap login = new ModelMap();
		
			Usuario resultado = registroService.loguearUsuario(usuario);
			
			if(resultado != null){
				
				request.getSession().setAttribute("username", resultado.getNombre());
				request.getSession().setAttribute("imagen", resultado.getImagen());
				request.getSession().setAttribute("email", resultado.getEmail());
				
				if(resultado.getBanda() != null){
					request.getSession().setAttribute("banda", resultado.getBanda().getId());
				}
				
				return new ModelAndView("redirect:/perfil");
			}
			
			else{
				
				login.addAttribute("title","Login");
				login.addAttribute("titulo","Ups. No ha salido bien");
				login.addAttribute("subtitulo","Parece que no ingresaste correctamente tu usuario/contrasenia. No te preocupes, volve a intentarlo.");
				login.addAttribute("inputValue","Volver a Ingresar");
				login.addAttribute("inputHref","login");
				login.addAttribute("iconClass","fa fa-chevron-left");
				
				return new ModelAndView("landing",login);
			}
	}
	
	@RequestMapping(path="/destruir_sesion")
	public ModelAndView destruirSesion(HttpServletRequest request){
		
		request.getSession().removeAttribute("username");
		request.getSession().removeAttribute("imagen");
		request.getSession().removeAttribute("banda");
		request.getSession().removeAttribute("email");
		
		return new ModelAndView("redirect:/login");
	}
	
}