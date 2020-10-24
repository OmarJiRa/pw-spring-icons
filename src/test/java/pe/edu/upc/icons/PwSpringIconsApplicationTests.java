package pe.edu.upc.icons;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.upc.icons.models.entities.Categoria;
import pe.edu.upc.icons.services.CategoriaService;

@SpringBootTest
class PwSpringIconsApplicationTests {
	
	@Autowired
	private CategoriaService categoriaService;

	@Test
	void contextLoads() {
		Categoria cat = new Categoria();
		cat.setNombre("Viajes");
		cat.setDescripcion("Sección de viajes porque somos bien viajeros");
		
		try {
			categoriaService.save(cat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
