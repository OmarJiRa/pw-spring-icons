package pe.edu.upc.icons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.icons.services.UsuarioService;
import pe.edu.upc.icons.utils.Segmento;
import pe.edu.upc.icons.models.entities.Usuario;
import pe.edu.upc.icons.security.UsuarioDetails;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping()
	public String verPerfil(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails) authentication.getPrincipal();

		if (usuarioDetails.getSegmento() == Segmento.USUARIO) {
			try {
				Optional<Usuario> opt = usuarioService.findById(usuarioDetails.getIdSegmento());
				if (opt.isPresent()) {
					model.addAttribute("usuario", opt.get());
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "perfil/perfil";
		}
		else if (usuarioDetails.getSegmento() == Segmento.CREADOR){
			
		}
		
		return "redirect:/posts";
	}

}
