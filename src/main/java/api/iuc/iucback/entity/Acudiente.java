package api.iuc.iucback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acudientes")
public class Acudiente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(unique = true)
	private String cedula;
	
	private String nombre;
	
	private String telefono; 
	
	@Column(name="telefono_alterno")
	private String telefonoAlterno;
	
	private String clave;

	private String apellido;
	
	private String direccion;
	
	public Acudiente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Acudiente(Long id, String nombre, String telefono, String telefonoAlterno, String clave, String usuario,
			String apellido, String direccion, String cedula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cedula=cedula;
		this.telefono = telefono;
		this.telefonoAlterno = telefonoAlterno;
		this.clave = clave;
		this.apellido = apellido;
		this.direccion=direccion;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
