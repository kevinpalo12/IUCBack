package api.iuc.iucback.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.iuc.iucback.entity.Profesor;

public interface IProfesorService {

	public Profesor save(Profesor profesor);
	
	public Profesor findById(Long id);
	
	public List<Profesor> findAll();
	
	public Page<Profesor> findAll(Pageable pegeable);
	
	public void delete(Long id);
	
	public List<Map<String, Object>> profesoresSinGrupo();
}
