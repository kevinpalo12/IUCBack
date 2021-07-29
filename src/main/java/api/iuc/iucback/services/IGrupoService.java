package api.iuc.iucback.services;


import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.iuc.iucback.entity.Grupo;

public interface IGrupoService {
	
	public Grupo save(Grupo grupo);
	
	public Grupo findById(Long id);
	
	public List<Grupo> findAll();
	
	public Page<Grupo> findAll(Pageable pegeable);
	
	public Map<String, Object> getNroEstudiantes(Long id);
}
