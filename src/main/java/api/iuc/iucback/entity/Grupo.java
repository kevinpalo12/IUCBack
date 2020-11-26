package api.iuc.iucback.entity;

import javax.persistence.*;

@Entity
public class Grupo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(nullable = false, length = 2)
	private String grado;
	
	@Column(nullable = false, length = 1)
	private String identificador;
	
	@Column(nullable = false)
	private String profesor;
	

}
