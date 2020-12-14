package api.iuc.iucback.services;

import java.util.*;
import api.iuc.iucback.entity.Estudiante;
import api.iuc.iucback.entity.Grupo;

public interface IEstudianteService {

	public Estudiante save(Estudiante estudiante);
	
	public List<Estudiante> findAll();
	
	public List<Estudiante> porGrupo(Long grupo);
	
	public Estudiante findById(Long id);
	
	public Integer calcularEdad(Estudiante estudiante);
}
