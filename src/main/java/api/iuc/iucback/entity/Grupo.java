package api.iuc.iucback.entity;

import javax.persistence.*;


@Entity
@Table(uniqueConstraints={
    @UniqueConstraint(columnNames = {"grado", "identificador"})
}) 
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(nullable = false, length = 2)
	private String grado;
	
	@Column(nullable = false, length = 1)
	private String identificador;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name="FK_grupo_profesor"), nullable = false)
	private Profesor profesor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Grupo(Long id, String grado, String identificador, Profesor profesor) {
		super();
		this.id = id;
		this.grado = grado;
		this.identificador = identificador;
		this.profesor = profesor;
	}

	public Grupo() {
		super();
	}

	
	

}
