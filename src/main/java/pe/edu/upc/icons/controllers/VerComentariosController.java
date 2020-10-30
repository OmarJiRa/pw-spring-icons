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

import pe.edu.upc.icons.models.entities.Comentarios;
import pe.edu.upc.icons.services.ComentariosService;

@Controller
@RequestMapping("/VerComentarios")
@SessionAttributes("comentarioUsuarios")
public class VerComentariosController {

	
	@Autowired
	private ComentariosService comentarioUsuariosService;
		
	
	@GetMapping
	public String inicio(Model model) {
		Comentarios comentarioUsuarios = new Comentarios();

		try {
			List<Comentarios> comentarios = comentarioUsuariosService.findAll();
			model.addAttribute("comentarios", comentarios);
			// Enviando el objeto comunidad para el nuevo elemento
			model.addAttribute("comentarioUsuarios", comentarioUsuarios);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve el nombre del archivo HTML
		return "/Vercomentarios/inicio";
	}
	
	
	@PostMapping("save")
	public String save(@ModelAttribute("comentarioUsuarios") Comentarios comentarioUsuarios, SessionStatus status ) {
			try {
				comentarioUsuariosService.save(comentarioUsuarios);
				status.setComplete();
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
			//Devuelve la URL mapping
			return "redirect:/VerComentarios";
	}

}
