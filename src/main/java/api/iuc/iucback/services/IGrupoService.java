package api.iuc.iucback.services;

import api.iuc.iucback.entity.Grupo;

public interface IGrupoService {
	
	public Grupo save(Grupo grupo);
	
	public Grupo findById(Long id);
}
