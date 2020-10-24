package pe.edu.upc.icons.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class SeguimientoId implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer usuario;
	private Integer creador;
	
	public SeguimientoId() {
		}
		
	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getCreador() {
		return creador;
	}

	public void setCreador(Integer creador) {
		this.creador = creador;
	}

	public SeguimientoId(Integer usuario, Integer creador) {
		super();
		this.usuario = usuario;
		this.creador = creador;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(usuario, creador);
	}
		
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        SeguimientoId creadorUsuarioid = (SeguimientoId) obj;
        if (this.creador != creadorUsuarioid.creador) 
        	return false;
        return this.usuario == creadorUsuarioid.usuario;
	}
	
}
