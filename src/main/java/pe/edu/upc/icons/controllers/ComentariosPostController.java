package pe.edu.upc.icons.controllers;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.icons.models.entities.ComentariosPost;
//import pe.edu.upc.icons.models.entities.ComunidadPost;
import pe.edu.upc.icons.services.ComentariosPostService;

@Controller
@RequestMapping("/comentarios")
@SessionAttributes("comentario")
public class ComentariosPostController {
	
	@Autowired
	private ComentariosPostService comentariosPostService;
	
	//Para obtener data de la BD y enviarlo al Front
	@GetMapping
	public String inicio(Model model) {
		ComentariosPost comentario = new ComentariosPost();
		
		try {
			List<ComentariosPost> comentarios = comentariosPostService.findAll();
			model.addAttribute("comentarios", comentarios);
			model.addAttribute("comentario", comentario);
		} catch (Exception e) { 
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "/comentarios/inicio";
	}
	
//  /comentarios/save
	@PostMapping("save")
	public String save(@ModelAttribute("comentario") ComentariosPost comentario, SessionStatus status ) {
		try {
			comentariosPostService.save(comentario);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping
		return "redirect:/comentarios";
	}	
}
