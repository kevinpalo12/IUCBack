package api.iuc.iucback.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ayudas")
public class Ayuda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String descripcion;

	@Column(name = "entregado_desde", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date entregadoDesde;

	private boolean activo;

	@Column(name = "ultima_entrega")
	@Temporal(TemporalType.DATE)
	private Date ultimaEntrega;

	@Column(name = "proxima_entrega")
	@Temporal(TemporalType.DATE)
	private Date proximaEntrega;
	
	@PrePersist
	public void prePersist() {
		proximaEntrega = ultimaEntrega;
	}

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

	public Date getProximaEntrega() {
		return proximaEntrega;
	}

	public void setProximaEntrega(Date proximaEntrega) {
		this.proximaEntrega = proximaEntrega;
	}

	public Date getUltimaEntrega() {
		return ultimaEntrega;
	}

	public void setUltimaEntrega(Date ultimaEntrega) {
		this.ultimaEntrega = ultimaEntrega;
	}

}
