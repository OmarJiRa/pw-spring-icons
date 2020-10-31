package pe.edu.upc.icons.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import pe.edu.upc.icons.services.CreadorService;
import pe.edu.upc.icons.services.PostService;

@Controller
@RequestMapping("/posts")
@SessionAttributes("post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private CreadorService creadorService;
	
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
			List<Post> posts = postService.findAll();
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
		try {
			Optional<Post> optional = postService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("post", optional.get());
				return "posts/view";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/posts";		
	}
}
