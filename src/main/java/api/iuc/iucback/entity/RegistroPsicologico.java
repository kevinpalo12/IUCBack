package api.iuc.iucback.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name ="registro_psicologico")
public class RegistroPsicologico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "estudiante", nullable = false, foreignKey = @ForeignKey(name="FK_PSICOLOGICO_ESTUDIANTE"))
	private Estudiante estudiante;
	
	@Column(columnDefinition="TEXT")
	private String anotacion;
	
	private String diagnostico;
	
	@Column(name = "create_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
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

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


}
