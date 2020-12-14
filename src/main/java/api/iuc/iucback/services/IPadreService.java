package api.iuc.iucback.services;

import api.iuc.iucback.entity.Padre;


public interface IPadreService {


	public Padre save(Padre padre);
	
	public Padre findById(Long id);
}
