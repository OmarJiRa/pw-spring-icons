package pe.edu.upc.icons.controllers;

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

import pe.edu.upc.icons.models.entities.Comunidad;
import pe.edu.upc.icons.models.entities.ComunidadPost;
import pe.edu.upc.icons.services.ComunidadPostService;
import pe.edu.upc.icons.services.ComunidadService;

@Controller
@RequestMapping("/comunidades")
@SessionAttributes("comunidad")
public class ComunidadController {
	
	@Autowired
	private ComunidadService comunidadService;
	private ComunidadPostService comunidadPostService;
	
	//Para obtener data de la BD y enviarlo al Front
	@GetMapping
	public String inicio(Model model) {
		Comunidad comunidad = new Comunidad();
		
		try {
			List<Comunidad> comunidades = comunidadService.findAll();
			model.addAttribute("comunidades", comunidades);
			//Enviando el objeto comunidad para el nuevo elemento
			model.addAttribute("comunidad", comunidad);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve el nombre del archivo HTML
		return "/comunidades/inicio";
	}
	
	//  /comunidades/save
	@PostMapping("save")
	public String save(@ModelAttribute("comunidad") Comunidad comunidad, SessionStatus status ) {
		try {
			comunidadService.save(comunidad);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve la URL mapping
		return "redirect:/comunidades";
	}
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<ComunidadPost> optional = comunidadPostService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("comunidadPost", optional.get());
				return "publicaciones";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/publicaciones";
	}
	
}
