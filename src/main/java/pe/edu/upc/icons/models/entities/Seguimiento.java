package pe.edu.upc.icons.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seguidores_creador")
@IdClass(SeguimientoId.class)
public class Seguimiento {
	@Id
	@ManyToOne
	@JoinColumn(name = "creador_id")
	private Creador creador;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name = "tipo", nullable = false)
	private Integer tipo;
	
	@Column(name = "monto", nullable = false)
	private Integer monto;

	public Creador getCreador() {
		return creador;
	}

	public void setCreador(Creador creador) {
		this.creador = creador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
}