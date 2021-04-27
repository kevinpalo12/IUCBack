package api.iuc.iucback.services;


import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import api.iuc.iucback.entity.Grupo;

public interface IGrupoService {
	
	public Grupo save(Grupo grupo);
	
	public Grupo findById(Long id);
	
	public List<Grupo> findAll();
	
	
}
