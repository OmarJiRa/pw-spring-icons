package pe.edu.upc.icons.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "creadores")
public class Creador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombres_apellidos", length = 60, nullable = false)
	private String nombresApellidos;
	
	@Column(name = "numero_documento", length = 12, nullable = false)
	private String numeroDocumento;

	@Column(name = "direccion", length = 50, nullable = false)
	private String direccion;

	@Column(name = "telefono", length = 9, nullable = false)
	private String telefono;

	@Column(name = "email", length = 30, nullable = false)
	private String email;
	
	@Column(name = "categoria", length = 15)
	private String categoria;
	
	@Column(name = "url_image", length = 100)
	private String urlImage;
	
	@Column(name = "tag", length = 30)
	private String tag;
	
	@OneToMany(mappedBy = "creador")
    private List<Suscripcion> creadorUsuarios;
	
	@OneToMany(mappedBy = "creador")
	private List<Post> posts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Suscripcion> getCreadorUsuarios() {
		return creadorUsuarios;
	}

	public void setCreadorUsuarios(List<Suscripcion> creadorUsuarios) {
		this.creadorUsuarios = creadorUsuarios;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
}
