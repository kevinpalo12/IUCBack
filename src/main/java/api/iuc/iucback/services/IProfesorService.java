package api.iuc.iucback.services;

import api.iuc.iucback.entity.Profesor;

public interface IProfesorService {

	public Profesor save(Profesor profesor);
	
	public Profesor findById(Long id);
}
