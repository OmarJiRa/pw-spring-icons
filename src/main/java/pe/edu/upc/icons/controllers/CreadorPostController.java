package pe.edu.upc.icons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/postcreador")
public class CreadorPostController {
	
	@GetMapping
	public String Publicaciones() {
		return "/pagina_creador/Publicaciones";
	}

}
