package pe.edu.upc.icons.controllers;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.icons.models.entities.ComunidadPost;
import pe.edu.upc.icons.services.ComunidadPostService;

@Controller
@RequestMapping("/publicaciones")
@SessionAttributes("comunidadPost")
public class ComunidadPostController {
	
	@Autowired
	private ComunidadPostService comunidadPostService;
	
	//Para obtener data de la BD y enviarlo al Front
	@GetMapping
	public String inicio(Model model) {
		ComunidadPost comunidadPost = new ComunidadPost();

		try {
			List<ComunidadPost> publicaciones = comunidadPostService.findAll();
			model.addAttribute("publicaciones", publicaciones);
			// Enviando el objeto comunidad para el nuevo elemento
			model.addAttribute("comunidadPost", comunidadPost);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve el nombre del archivo HTML
		return "/publicaciones/iniciop";
	}
		
	//  /publicaciones/save
	@PostMapping("save")
	public String save(@ModelAttribute("comunidadPost") ComunidadPost comunidadPost, SessionStatus status ) {
		try {
			comunidadPostService.save(comunidadPost);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping
		return "redirect:/publicaciones";
	
		}

}
