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
import ar.edu.grupoesfera.cursospring.modelo.PublicacionUsuario;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Controller
@Scope("session")
public class PerfilController {
	
	@Inject
	public PerfilService perfilService;
	
	@Inject
	public PublicacionService publicacionService;
	
	@Inject
	public BandaService bandaservice;
	
	//Setters para mockear en testeos
	public void setPerfilServiceMock(PerfilService perfilServiceMock) {
		this.perfilService = perfilServiceMock;
	}

	public void setPublicacionServiceMock(PublicacionService publicacionServiceMock) {
		this.publicacionService = publicacionServiceMock;
	}

	public void setBandaserviceMock(BandaService bandaserviceMock) {
		this.bandaservice = bandaserviceMock;
	}
	
	/* ------ MOSTRAR PERFIL PROPIO ------ */


	@RequestMapping("/perfil")
	public ModelAndView perfil(HttpServletRequest request) {
		
		Usuario miUsuario = perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username")); // A la busqueda de perfil de usuario le paso el atributo de session (casteado a string).
		
		PublicacionUsuario publicacion = new PublicacionUsuario();
		
		List<PublicacionUsuario> publicacionesUser = publicacionService.mostrarPublicacionesUsuario((String)request.getSession().getAttribute("username"));
		
		ModelMap perfil = new ModelMap();
		perfil.addAttribute("usuario",miUsuario);
		perfil.addAttribute("publicar", publicacion);
		perfil.addAttribute("publicaciones", publicacionesUser);
		
		return new ModelAndView("profile",perfil);
	}
	
	/* ------ PUBLICAR CONTENIDOS ------ */
	
	@RequestMapping(path="/post" , method = RequestMethod.POST)
	public ModelAndView nuevaPublicacion(@ModelAttribute("publicar") PublicacionUsuario publicacion, HttpServletRequest request){
		
		publicacionService.crearPublicacionUsuario(publicacion, (String)request.getSession().getAttribute("username"));
		
		return new ModelAndView("redirect:/perfil");
		
	}
	
	/* ------ BUSCAR PERFIL PUBLICO O EDITAR PERFIL PROPIO ------ */
	
	
	@RequestMapping("/perfil/{username}")
	public ModelAndView perfilUser(@PathVariable("username") String nombreUsuario,HttpServletRequest request){
		
		Usuario miUsuarioLogueadoGlobal = new Usuario();
		miUsuarioLogueadoGlobal=perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username"));
		
		ModelMap perfil = new ModelMap();
		
		if(nombreUsuario.equals("editar")){
			Usuario miUsuario = perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username"));
			
			perfil.addAttribute("usuario",miUsuario);
			perfil.addAttribute("reubicacion","../");
			
			return new ModelAndView("profileEdit",perfil);
			
			
			
		}
	
		else if(nombreUsuario.equals((String)request.getSession().getAttribute("username"))){
			
			return new ModelAndView("redirect:../perfil");
		}
		else{
			Usuario usuarioEncontrado = perfilService.buscarPerfilUsuario(nombreUsuario);
			
			if(usuarioEncontrado == null){
				ModelMap resultado = new ModelMap();
				
				resultado.addAttribute("title","Perfil");
				resultado.addAttribute("titulo","Ups. No hemos encontrado este usuario.");
				resultado.addAttribute("subtitulo","Probablemente haya dado de baja su cuenta. Proba buscar otro");
				resultado.addAttribute("inputValue","Ir a Busqueda");
				resultado.addAttribute("inputHref","../busqueda");
				resultado.addAttribute("iconClass","fa fa-chevron-left");
				resultado.addAttribute("reubicacion","../");
				
				return new ModelAndView("landing",resultado);
			}
			else{
				List<PublicacionUsuario> publicacionesUser = publicacionService.mostrarPublicacionesUsuario(nombreUsuario);
				
				perfil.addAttribute("usuario",usuarioEncontrado);
				perfil.addAttribute("publicaciones", publicacionesUser);
				perfil.addAttribute("reubicacion","../");	// String necesario para que todos los recursos css, js, imagenes y backgrounds tengan su "src" correctamente (a causa del PathVariable)
				
				if (miUsuarioLogueadoGlobal.getBanda() != null && usuarioEncontrado.getBanda() != null){
					if(usuarioEncontrado.getBanda().getId() == miUsuarioLogueadoGlobal.getBanda().getId()){
						
						perfil.addAttribute("mismaBanda",true);
						
					}
					else{
						
						perfil.addAttribute("mismaBanda",true);
						
					}
				}else if(miUsuarioLogueadoGlobal.getBanda() != null && usuarioEncontrado.getBanda()==null){
					
					perfil.addAttribute("mismaBanda", false);
					
				}
				
				return new ModelAndView("profile",perfil);
			}
		}
	
	}
	
	/* ------ REDIRIGIR A PERFIL PROPIO ------ */
	
	@RequestMapping("/perfil/")
	public ModelAndView redirigirAPerfil(){
		return new ModelAndView("redirect:../perfil");
	}
	
	/* ------ ACTUALIZACION DE PERFIL PROPIO ------ */
	
	@RequestMapping("/editarPerfil")
	public ModelAndView modificarPerfil(@ModelAttribute("usuario") Usuario usuario,HttpServletRequest request){
		
		usuario.setNombre(usuario.getNombre().toLowerCase());
		usuario.setInstrumento(usuario.getInstrumento().toLowerCase());
		
		String flag = perfilService.editarPerfil(usuario,(String)request.getSession().getAttribute("username"),(String)request.getSession().getAttribute("email"));
		
		ModelMap resultado = new ModelMap();
		
		if(flag == "success"){
			request.getSession().setAttribute("username", usuario.getNombre());
			request.getSession().setAttribute("email", usuario.getEmail());
			
			resultado.addAttribute("title","Perfil");
			resultado.addAttribute("titulo","Se ha modificado tu perfil");
			resultado.addAttribute("subtitulo","Todos tus datos se guardaron satisfactoriamente");
			resultado.addAttribute("inputValue","Ver Mi Perfil");
			resultado.addAttribute("inputHref","perfil");
			resultado.addAttribute("iconClass","fa fa-chevron-right");
			
			return new ModelAndView("landing",resultado);
		}
		else{
			resultado.addAttribute("title","Editar Perfil");
			resultado.addAttribute("titulo","Ups. No ha salido bien");
			resultado.addAttribute("subtitulo","Parece que existe un usuario con mismo nombre/email. No te preocupes, volve a intentarlo.");
			resultado.addAttribute("inputValue","Volver a Editar Perfil");
			resultado.addAttribute("inputHref","perfil/editar");
			resultado.addAttribute("iconClass","fa fa-chevron-left");
			
			return new ModelAndView("landing",resultado);
		}
		
	}
	
}
