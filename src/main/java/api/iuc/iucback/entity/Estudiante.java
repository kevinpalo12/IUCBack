package api.iuc.iucback.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20, nullable = false, unique = true)
	private String documento;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido;

	@ManyToOne()
	@JoinColumn(name = "grupo", nullable = false, foreignKey = @ForeignKey(name = "FK_ESTUDIANTE_GRUPO"))
	private Grupo grupo;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date nacimiento;

	private Integer edad;

	@ManyToOne()
	@JoinColumn(name = "acudiente_id", nullable = false, foreignKey = @ForeignKey(name = "FK_ESTUDIANTE_PADRE"))
	private Acudiente acudiente;

	@Column(length = 20, nullable = false)
	private String estado;

	@ManyToMany
	Set<Ayuda> ayudas;

	@PrePersist
	public void prePersist() {

		estado = "MATRICULADO";
		createAt = new Date();
	}

	public void addAyuda(Ayuda ayuda) {
		this.ayudas.add(ayuda);
	}

	@SuppressWarnings("deprecation")
	public void cambiarDia() {
		this.nacimiento.setDate(this.nacimiento.getDate() + 1);
		this.nacimiento.setHours(0);
	}

	public void setAcudienteId(Acudiente padreId) {
		this.acudiente = padreId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
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

	public Acudiente getAcudiente() {
		return acudiente;
	}

	public void setAcudiente(Acudiente acudiente) {
		this.acudiente = acudiente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Estudiante() {
		super();
	}

	public Estudiante(Long id, String documento, String nombre, String apellido, Grupo grupo, Date createAt,
			Date nacimiento, Integer edad, Acudiente acudiente, String estado) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.grupo = grupo;
		this.createAt = createAt;
		this.nacimiento = nacimiento;
		this.edad = edad;
		this.acudiente = acudiente;
		this.estado = estado;
	}


}
