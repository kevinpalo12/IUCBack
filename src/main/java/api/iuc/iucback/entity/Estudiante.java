package api.iuc.iucback.entity;

import java.time.Period;
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
	@JoinColumn(name = "grupo",nullable=false, foreignKey = @ForeignKey(name="FK_ESTUDIANTE_GRUPO"))
	private Grupo grupo;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@Temporal(TemporalType.DATE)
	private Date nacimiento;	
	
	private Integer edad;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "padre_id", nullable=false, foreignKey = @ForeignKey(name="FK_ESTUDIANTE_PADRE"))
	private Padre padre;
	
	@Column(length = 20, nullable=false)
	private String estado;

	@PrePersist
	public void prePersist() {
		estado="MATRICULADO";
		createAt = new Date();		
	}


	public Date getNacimiento() {
		return nacimiento;
	}


	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public void setPadre(Padre padre) {
		this.padre = padre;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Padre getPadre() {
		return padre;
	}


	public void setPadreId(Padre padreId) {
		this.padre = padreId;
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
