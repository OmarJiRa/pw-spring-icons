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

import pe.edu.upc.icons.models.entities.MedioPago;
import pe.edu.upc.icons.models.entities.Usuario;
import pe.edu.upc.icons.services.MedioPagoService;
import pe.edu.upc.icons.services.UsuarioService;

@Controller
@RequestMapping("/medios")
@SessionAttributes("medio")
public class MedioPagoController {

	@Autowired
	private MedioPagoService medioPagoService;
	
	@Autowired
	private UsuarioService usuarioService;
		
	@GetMapping
	public String inicio(Model model) {
		
		MedioPago medioPago = new MedioPago();
		
		try {
			List<MedioPago> mediosPago = medioPagoService.findAll();
			model.addAttribute("medio", medioPago);
			model.addAttribute("medios", mediosPago); 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/medios/inicio";
	}
	
	
	
	@PostMapping("save")
	public String save(@ModelAttribute("medio") MedioPago medio, SessionStatus status) {
		try {
			Optional<Usuario> usuario = usuarioService.findById(3);
			medio.setUsuario(usuario.get());
			medioPagoService.save(medio);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/medios";
	}
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<MedioPago> optional = medioPagoService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("medio", optional.get());
				return "medios/view";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/medios";		
	}
}
