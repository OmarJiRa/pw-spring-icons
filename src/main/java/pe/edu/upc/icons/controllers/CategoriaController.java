package pe.edu.upc.icons.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.icons.models.entities.Categoria;
import pe.edu.upc.icons.models.entities.Post;
import pe.edu.upc.icons.services.CategoriaService;
import pe.edu.upc.icons.services.PostService;


@Controller
@RequestMapping("/categorias")
@SessionAttributes("post")
public class CategoriaController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoriaService categoriaService;
	
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
		
		
		try {
			List<Categoria> categorias = categoriaService.findAll();
			model.addAttribute("categorias", categorias);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		return "/categorias/inicio";
	}
	
	@GetMapping("{id}")
	public String view(@PathVariable("id") Integer id, Model model) {

		try {
			Optional<Categoria> optional = categoriaService.findById(id);
			List<Post> posts = postService.findByCategoria(optional.get());
			if (optional.isPresent()) {

				model.addAttribute("posts", posts);
				return "categorias/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/creadores";
	}
}