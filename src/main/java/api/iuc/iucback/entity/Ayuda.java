package api.iuc.iucback.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "ayudas")
public class Ayuda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String descripcion;

	@Column(name = "entregado_desde", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date entregadoDesde;

	private boolean activo;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "AYUDAS_ESTUDIANTES", joinColumns = @JoinColumn(name = "AYUDA_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ESTUDIANTE_ID", referencedColumnName = "ID"))
	@OrderBy
	@JsonIgnore
	private Collection<Estudiante> estudiantes;

	@Column(name = "ultima_entrega")
	@Temporal(TemporalType.DATE)
	private Date ultimaEntrega;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getEntregadoDesde() {
		return entregadoDesde;
	}

	public void setEntregadoDesde(Date entregadoDesde) {
		this.entregadoDesde = entregadoDesde;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public Date getUltimaEntrega() {
		return ultimaEntrega;
	}

	public void setUltimaEntrega(Date ultimaEntrega) {
		this.ultimaEntrega = ultimaEntrega;
	}

	public Collection<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Collection<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

}