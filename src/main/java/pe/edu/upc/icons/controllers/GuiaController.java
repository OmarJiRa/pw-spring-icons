package pe.edu.upc.icons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guiausuario")
public class GuiaController {
	
	@GetMapping
	public String GuiaUsuario() {
		return "GuiaUsuario";
	}

}
