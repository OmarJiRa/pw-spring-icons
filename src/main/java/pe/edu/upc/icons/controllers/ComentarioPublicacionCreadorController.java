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

import pe.edu.upc.icons.models.entities.ComentarioCreadorPost;
import pe.edu.upc.icons.services.ComentarioCreadorPostService;

@Controller
@RequestMapping("/comentariocreadorpost")
@SessionAttributes("comentariocreadorPost")
public class ComentarioPublicacionCreadorController {
	
	@Autowired
	private ComentarioCreadorPostService comentariocreadorPostService;
	
	//Para obtener data de la BD y enviarlo al Front
	@GetMapping
	public String inicio(Model model) {
		ComentarioCreadorPost comentariocreadorPost = new ComentarioCreadorPost();

		try {
			List<ComentarioCreadorPost> comentariocreadorposts = comentariocreadorPostService.findAll();
			model.addAttribute("comentariocreadorposts", comentariocreadorposts);
			// Enviando el objeto comunidad para el nuevo elemento
			model.addAttribute("comentariocreadorPost", comentariocreadorPost);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve el nombre del archivo HTML
		return "/pagina_creador/ComentariosPublicacionCreador";
	}
		
	//  /publicaciones/save
	@PostMapping("save")
	public String save(@ModelAttribute("comentariocreadorPost") ComentarioCreadorPost comentariocreadorPost, SessionStatus status ) {
		try {
			comentariocreadorPostService.save(comentariocreadorPost);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping
		return "redirect:/comentariocreadorpost";
	}
}