package pe.edu.upc.icons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comunidades")
public class ComunidadController {
	
	@GetMapping
	public String inicio() {
		return "/comunidades/inicio";
	}
	
}
