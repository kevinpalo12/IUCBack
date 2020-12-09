package api.iuc.iucback.entity;

import javax.persistence.*;

@Entity
@Table(name="profesores")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
		
	@Column(nullable = false)
	private String correo;

	@Column(nullable = false, length = 10)
	private String telefono;
	
	@Column(unique=true)
	private String usuario;
	
	private String clave;
	
	
	
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(Long id, String nombre, String correo, String telefono, String usuario, String clave) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.usuario = usuario;
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usario) {
		this.usuario = usario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
}
