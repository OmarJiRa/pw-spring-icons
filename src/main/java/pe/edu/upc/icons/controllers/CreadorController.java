package pe.edu.upc.icons.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.icons.models.entities.Creador;
import pe.edu.upc.icons.services.CreadorService;

@Controller
@RequestMapping("/creadores")
public class CreadorController {
	
	@Autowired
	private CreadorService creadorService;
	
	@GetMapping
	public String inicio(Model model) {
		Creador creador = new Creador();
		
		try {
			List<Creador> creadores = creadorService.findAll();
			model.addAttribute("creadores", creadores);
			model.addAttribute("creador", creador);
		}
		catch (Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "creadores/index";
	}
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Creador> optional = creadorService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("distrito", optional.get());
				return "distritos/view";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/creadores";		
	}
}
