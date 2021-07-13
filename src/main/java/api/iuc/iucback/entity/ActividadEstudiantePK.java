package api.iuc.iucback.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ActividadEstudiantePK implements Serializable{
	
	@Column(name = "estudiante_id")
	private Long estudiante_id;

	@Column(name = "actividad_id")
	private Long actividad_id;

	public Long getEstudiante_id() {
		return estudiante_id;
	}

	public void setEstudiante_id(Long estudiante_id) {
		this.estudiante_id = estudiante_id;
	}

	public Long getActividad_id() {
		return actividad_id;
	}

	public void setActividad_id(Long actividad_id) {
		this.actividad_id = actividad_id;
	}

	
	
}
