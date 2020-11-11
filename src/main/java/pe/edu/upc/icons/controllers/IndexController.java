package pe.edu.upc.icons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.icons.models.entities.Comunidad;

@Controller
<<<<<<< HEAD
@RequestMapping("/")
public class IndexController {
	
	@GetMapping
	public String land() {
		return "landing";
	}
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("layout")
	public String layout() {
		return "layout/layout";
	}
}
=======
@RequestMapping("/inicio")
@SessionAttributes("comunidad")
public class IndexController {
	
	@GetMapping
	public String index(Model model) {
		Comunidad comunidad= new Comunidad();
		model.addAttribute("comunidad", comunidad);
		return "index";
	}
}
>>>>>>> b7842678a49aa7ff52102a175ac3a50fdc9337ce
