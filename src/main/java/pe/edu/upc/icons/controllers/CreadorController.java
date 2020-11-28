package pe.edu.upc.icons.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.icons.models.entities.Creador;
import pe.edu.upc.icons.models.entities.Post;
import pe.edu.upc.icons.models.entities.Usuario;
import pe.edu.upc.icons.security.UsuarioDetails;
import pe.edu.upc.icons.services.CreadorService;
import pe.edu.upc.icons.services.PostService;
import pe.edu.upc.icons.services.UsuarioService;

@Controller
@RequestMapping("/creadores")
@SessionAttributes("creador")
public class CreadorController {

	@Autowired
	private CreadorService creadorService;

	@Autowired
	private PostService postService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public String inicio(Model model) {
		Creador creador = new Creador();

		try {
			List<Creador> creadores = creadorService.findAll();
			model.addAttribute("creadores", creadores);
			model.addAttribute("creador", creador);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "creadores/index";
	}

	@GetMapping("{tag}-{id}")
	public String view(@PathVariable("id") Integer id, Model model) {

		try {
			Optional<Creador> optional = creadorService.findById(id);
			List<Post> posts = postService.findByCreador(optional.get());
			if (optional.isPresent()) {
				model.addAttribute("creador", optional.get());
				model.addAttribute("posts", posts);
				return "creadores/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/creadores";
	}

	@PostMapping("seguir")
	public String seguir(@ModelAttribute("creador") Creador creador, SessionStatus status) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails) authentication.getPrincipal();
		
		try {
			Optional<Usuario> optional = usuarioService.findById(usuarioDetails.getIdSegmento());
			System.out.println("EL id es: " + creador.getId());
			usuarioService.setSeguimiento(optional.get().getId(), creador.getId());
			status.setComplete();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/creadores";
	}

	@PostMapping("suscripcion")
	public String suscripcion(@ModelAttribute("creador") Creador creador, SessionStatus status) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails) authentication.getPrincipal();
		try {
			Optional<Usuario> optional = usuarioService.findById(usuarioDetails.getIdSegmento());
			System.out.println("EL id es: " + creador.getId());
			usuarioService.setSeguimiento(optional.get().getId(), creador.getId());	
			status.setComplete();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/creadores";
	}
	
	@GetMapping("estadisticas-{id}")
	public String estadisticas(@PathVariable("id") Integer id, Model model) {
			
		try {
			Integer reporteComentario = creadorService.numeroComentarios(id);
			Integer reporteMeGusta = creadorService.numeroMeGusta(id);
			Integer reporteSeguidores = creadorService.numeroSeguidores(id);
			Integer reporteSuscriptores = creadorService.numeroSuscriptores(id);

			model.addAttribute("reporteComentario", reporteComentario);
			model.addAttribute("reporteMeGusta", reporteMeGusta);
			model.addAttribute("reporteSuscriptores", reporteSuscriptores);
			model.addAttribute("reporteSeguidores", reporteSeguidores);
			
			return "creadores/estadisticas";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/creadores";
		
	}
}
