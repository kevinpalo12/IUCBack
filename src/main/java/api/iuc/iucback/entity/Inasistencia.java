package api.iuc.iucback.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "inasistencias",uniqueConstraints={
	    @UniqueConstraint(columnNames = {"estudiante_id", "fecha"})
	})
public class Inasistencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	private boolean excusa;
	
	@ManyToOne()
	@JoinColumn(name = "estudiante_id", nullable = false, foreignKey = @ForeignKey(name = "FK_AYUDA_ESTUDIANTE"))
	private Estudiante estudiante;

	

    private String nameFile;
    
    private String url;


	@PrePersist
	public void prePersist() {
		fecha = new Date();
		excusa=false;
	}
	
	
	public String getNameFile() {
		return nameFile;
	}


	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public boolean isExcusa() {
		return excusa;
	}


	public void setExcusa(boolean excusa) {
		this.excusa = excusa;
	}



	
}
