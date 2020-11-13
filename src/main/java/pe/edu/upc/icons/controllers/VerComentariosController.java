package pe.edu.upc.icons.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.icons.models.entities.ComentarioCreadorPost;
import pe.edu.upc.icons.models.entities.CreadorPost;
import pe.edu.upc.icons.services.ComentarioCreadorPostService;
import pe.edu.upc.icons.services.CreadorPostService;

@Controller
@RequestMapping("/vercomentarios")
public class VerComentariosController {
	
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
		return "/pagina_creador/VerComentarios";
	}
}
