package pe.edu.upc.icons.controllers;

import java.util.Date;
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
import pe.edu.upc.icons.models.entities.UsuarioPost;
import pe.edu.upc.icons.security.UsuarioDetails;
import pe.edu.upc.icons.services.CreadorService;
import pe.edu.upc.icons.services.PostService;
import pe.edu.upc.icons.services.UsuarioPostService;
import pe.edu.upc.icons.services.UsuarioService;

@Controller
@RequestMapping("/posts")
@SessionAttributes("post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private CreadorService creadorService;
	
	@Autowired
	private UsuarioPostService usuarioPostService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public static Date getFechaActual() {
	    Date ahora = new Date();
	    return ahora;
	}
	
	public static Date getHoraActual() {
	    Date ahora = new Date();
	    return ahora;
	    
	}
	
	@GetMapping
	public String inicio(Model model) {
		
		Post post = new Post();
		try {
			Optional <Creador> creador = creadorService.findById(6);
			post.setCreador(creador.get());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		post.setFechaPublicacion(getFechaActual());
		post.setHoraPublicacion(getHoraActual());
		
		try {
			List<Post> posts = postService.findByExclusivo(false);
			model.addAttribute("post", post);
			model.addAttribute("posts", posts); 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/posts/inicio";
	}
	
	
	
	@PostMapping("save")
	public String save(@ModelAttribute("post") Post post, SessionStatus status) {
		try {
			postService.save(post);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/posts";
	}
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Integer id, Model model) {
		UsuarioPost comentario = new UsuarioPost();
		try {
			Optional<Post> optional = postService.findById(id);
			List<UsuarioPost> comentarios = usuarioPostService.findByPost(optional.get());
			
			if(optional.isPresent()) {
				model.addAttribute("post", optional.get());
				model.addAttribute("comentarios", comentarios);
				model.addAttribute("comentarioC", comentario);
				return "posts/view";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/posts";		
	}
	
	@PostMapping("comentar-{id}")
	public String saveComentario(@ModelAttribute("comentarioC") UsuarioPost comentarioC, @PathVariable("id") Integer id, SessionStatus status) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails) authentication.getPrincipal();
		try {
			Optional<Usuario> optional = usuarioService.findById(usuarioDetails.getIdSegmento());
			Optional<Post> post = postService.findById(id);
			comentarioC.setPost(post.get());
			comentarioC.setUsuario(optional.get());
			comentarioC.setFechaComentario(getFechaActual());
			comentarioC.setHoraComentario(getHoraActual());
			comentarioC.setMeGusta(false);

			usuarioPostService.save(comentarioC);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/posts/view-{id}";
	}
}