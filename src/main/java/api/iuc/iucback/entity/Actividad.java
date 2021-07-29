package api.iuc.iucback.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "actividades",uniqueConstraints={
		@UniqueConstraint(columnNames = {"nombre"})
})
public class Actividad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "estudiante")
	private Set<ActividadEstudiante> employerDeliveryAgent = new HashSet<ActividadEstudiante>();


	@PrePersist
	public void prePersist() {
		nombre=nombre.toUpperCase();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
