package pe.edu.upc.icons.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.icons.models.entities.CreadorPost;
import pe.edu.upc.icons.services.CreadorPostService;

@Controller
@RequestMapping("/creadorpost")
@SessionAttributes("creadorPost")
public class CreadorPostController {
	
	@Autowired
	private CreadorPostService creadorPostService;
	
	//Para obtener data de la BD y enviarlo al Front
	@GetMapping
	public String inicio(Model model) {
		CreadorPost creadorPost = new CreadorPost();

		try {
			List<CreadorPost> creadorposts = creadorPostService.findAll();
			model.addAttribute("creadorposts", creadorposts);
			// Enviando el objeto comunidad para el nuevo elemento
			model.addAttribute("creadorPost", creadorPost);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve el nombre del archivo HTML
		return "/pagina_creador/Publicaciones";
	}
		
	//  /publicaciones/save
	@PostMapping("save")
	public String save(@ModelAttribute("creadorPost") CreadorPost creadorPost, SessionStatus status ) {
		try {
			creadorPostService.save(creadorPost);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping
		return "redirect:/pagina_creador";
	}
}
