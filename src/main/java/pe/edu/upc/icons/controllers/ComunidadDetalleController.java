package pe.edu.upc.icons.controllers;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

//import javax.persistence.Id;

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

import pe.edu.upc.icons.models.entities.ComentariosPost;
import pe.edu.upc.icons.models.entities.ComunidadDetalle;
//import pe.edu.upc.icons.models.entities.ComentariosPost;
//import pe.edu.upc.icons.models.entities.Comunidad;
import pe.edu.upc.icons.models.entities.ComunidadPost;
import pe.edu.upc.icons.services.ComentariosPostService;
import pe.edu.upc.icons.services.ComunidadDetalleService;
import pe.edu.upc.icons.services.ComunidadPostService;

@Controller
@RequestMapping("/comunidadDetalles")
@SessionAttributes("comunidadDetalle")
public class ComunidadDetalleController {
	@Autowired
	private ComunidadDetalleService comunidadDetalleService;
	private ComentariosPostService comentariosPostService;
	
	//Para obtener data de la BD y enviarlo al Front
	@GetMapping
	public String inicio(Model model) {
		ComunidadDetalle comunidadDetalle = new ComunidadDetalle();

		try {
			List<ComunidadDetalle> comunidadDetalles = comunidadDetalleService.findAll();
			model.addAttribute("comunidadDetalles", comunidadDetalles);
			// Enviando el objeto comunidad para el nuevo elemento
			model.addAttribute("comunidadDetalle", comunidadDetalle);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve el nombre del archivo HTML
		return "/comunidades/comunidad-posts";
	}
		
	//  /publicaciones/save
	/*@PostMapping("save")
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
	
	//   /publicaciones/edit
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<ComunidadPost> optional = comunidadPostService.findById(id);
			if( optional.isPresent() ) {
				model.addAttribute("comunidadPost", optional.get());
			}
			else {
				return "redirect:/publicaciones/edit";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Devuelve la URL mapping
		return "/publicaciones/edit";
	}
	
    //  /publicaciones/delete
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<ComunidadPost> optional = comunidadPostService.findById(id);
			if( optional.isPresent() ) {
				comunidadPostService.deleteById(id);
			}
			else {
				return "redirect:/publicaciones";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Devuelve la URL mapping
		return "redirect:/publicaciones";
	}
	
	@PostMapping("search_descripcion")
	public String search(@ModelAttribute("comunidadPost") ComunidadPost comunidadPost, Model model) {
		model.addAttribute("comunidadPost", comunidadPost);
		System.out.println(comunidadPost.getDescripcion());
		try {
			List<ComunidadPost> comunidadPosts = comunidadPostService.findByDescripcion(comunidadPost.getDescripcion());
			//System.out.println(comunidadPosts.size());
			model.addAttribute("comunidadPosts", comunidadPosts);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/publicaciones/viewp";
	}
	
	@GetMapping("{tag}-{id}/p")
	public String viewPublicacion(@ModelAttribute("comunidadPost") ComunidadPost comunidadPost,
			@PathVariable("id") Integer id, Model model ) {

		try {
			Optional<ComunidadPost> optional = comunidadPostService.findById(id);
			if(optional.isPresent()) {		
				model.addAttribute("comunidadPost", comunidadPost);	// Search
				model.addAttribute("comunidadPostDetalle", optional.get());
				return "/publicaciones/viewp-publicacion";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/publicaciones";
	}
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<ComentariosPost> optional = comentariosPostService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("comentarioPost", optional.get());
				return "comentarios/inicio";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/comentarios";
	}*/

}
