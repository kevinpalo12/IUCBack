package api.iuc.iucback.services;

import java.util.List;

import api.iuc.iucback.entity.Actividad;

public interface IActividadService {

	public Actividad save(Actividad actividad);
	
	public Actividad findById(Long Id);
	
	public List<Actividad> findAll();
}
