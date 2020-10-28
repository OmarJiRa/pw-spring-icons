package pe.edu.upc.icons;

//import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.upc.icons.models.entities.Categoria;
//import pe.edu.upc.icons.models.entities.Comunidad;
import pe.edu.upc.icons.services.CategoriaService;
//import pe.edu.upc.icons.services.ComunidadService;

@SpringBootTest
class PwSpringIconsApplicationTests {
	
	@Autowired
	private CategoriaService categoriaService;
	//private ComunidadService comunidadService;

	@Test
	void contextLoads() {
		Categoria cat = new Categoria();
		cat.setNombre("viajes");
		cat.setDescripcion("sección de viajes porque somos bien viajeros");
		
		try {
			categoriaService.save(cat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*@Test
	void contextLoads2() {
		Comunidad comunidad = new Comunidad();
		comunidad.setNombre("Deportes");
		comunidad.setTema("Temas Deportivos");
		comunidad.setDescripcion("Deportes");
		Date fechaCreacion = null;
		comunidad.setFechaCreacion(fechaCreacion);
		
		try {
			comunidadService.save(comunidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
