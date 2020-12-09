package api.iuc.iucback.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, nullable=false, unique=true)
	private String documento;
	
	@Column(nullable=false)
	private String nombre; 
	
	@Column(nullable=false)
	private String apellido; 
		
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "grupo",nullable=false, foreignKey = @ForeignKey(name="FK_GRUPO_KEY"))
	private Grupo grupo;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public Grupo getGrupo() {
		return grupo;
	}


	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}


	
	
	

}
