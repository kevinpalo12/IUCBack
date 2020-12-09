package api.iuc.iucback.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Anotador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "estudiante_id", nullable = false, foreignKey = @ForeignKey(name="FK_ANOTADOR_ESTUDIANTE"))
	private Estudiante estudianteId;
	
	@Column(name = "create_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@Column(columnDefinition="TEXT")
	private String anotacion;
	
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "profesor_id", nullable = false, foreignKey = @ForeignKey(name="FK_ANOTADOR_PROFESOR"))
	private Profesor profesorId;
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Estudiante getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(Estudiante estudianteId) {
		this.estudianteId = estudianteId;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	public Profesor getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(Profesor profesorId) {
		this.profesorId = profesorId;
	}

	
}
