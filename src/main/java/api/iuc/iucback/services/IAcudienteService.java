package api.iuc.iucback.services;

import api.iuc.iucback.entity.Acudiente;


public interface IAcudienteService {


	public Acudiente save(Acudiente padre);
	
	public Acudiente findById(Long id);
	
	public Acudiente findByCedula(String cedula);
}
