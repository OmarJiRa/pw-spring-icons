package pe.edu.upc.icons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vercomentarios")
public class VerComentariosController {
	
	@GetMapping
	public String GuiaUsuario() {
		return "/pagina_creador/VerComentarios";
	}

}
