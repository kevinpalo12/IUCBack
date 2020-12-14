package api.iuc.iucback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "padres")
public class Padre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String nombre;
	
	private String telefono; 
	
	@Column(name="telefono_alterno")
	private String telefonoAlterno;
	
	private String clave;
	
	@Column(unique = true)
	private String usuario;

	private String apellido;
	
	
	public Padre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Padre(Long id, String nombre, String telefono, String telefonoAlterno, String clave, String usuario,
			String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.telefonoAlterno = telefonoAlterno;
		this.clave = clave;
		this.usuario = usuario;
		this.apellido = apellido;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public String getTelefonoAlterno() {
		return telefonoAlterno;
	}

	public void setTelefonoAlterno(String telefonoAlterno) {
		this.telefonoAlterno = telefonoAlterno;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
}
