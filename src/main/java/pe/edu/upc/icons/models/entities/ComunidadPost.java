package pe.edu.upc.icons.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "comunidad_post")
public class ComunidadPost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "comunidad_id")
	private Comunidad comunidad;
	
	@Transient
	private Integer comunidadId;

	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name = "descripcion", length = 1000, nullable = false)
	private String descripcion;
	
	@Column(name = "creador", length = 30, nullable = false)
	private String creador;
	
	@Column(name = "fecha_creacion", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@Column(name = "url_image", length = 100)
	private String urlImage;
	
	@Column(name = "tag", length = 50)
	private String tag;
	
	public Integer getComunidadId() {
		if(this.comunidadId <= 0 && this.comunidad != null) {
			this.comunidadId = this.comunidad.getId();
		}
		return comunidadId;
	}
	
	public Comunidad getComunidad() {
		return comunidad;
	}

	public void setComunidad(Comunidad comunidad) {
		this.comunidad = comunidad;
	}

	public void setComunidadId(Integer comunidadId) {
		this.comunidadId = comunidadId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<ComunidadUsuario> getComunidadUsuarios() {
		return comunidadUsuarios;
	}

	public void setComunidadUsuarios(List<ComunidadUsuario> comunidadUsuarios) {
		this.comunidadUsuarios = comunidadUsuarios;
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
	
	@OneToMany(mappedBy = "comunidad")
	private List<ComunidadUsuario> comunidadUsuarios;

}
