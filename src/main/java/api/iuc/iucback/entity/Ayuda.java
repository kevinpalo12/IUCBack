package api.iuc.iucback.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ayudas",uniqueConstraints={
	    @UniqueConstraint(columnNames = {"descripcion", "fecha_entrega"})
	})
public class Ayuda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String descripcion;

	@Column(name = "fecha_entrega",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaEntrega;
	
	
	@PrePersist
	public void prePersist() {

		descripcion=descripcion.toUpperCase();
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	@SuppressWarnings("deprecation")
	public void cambiarDia() {
		this.fechaEntrega.setDate(this.fechaEntrega.getDate() + 1);
		this.fechaEntrega.setHours(0);
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



}
