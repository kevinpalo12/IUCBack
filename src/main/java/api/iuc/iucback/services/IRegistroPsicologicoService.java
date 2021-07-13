package api.iuc.iucback.services;

import java.util.List;

import api.iuc.iucback.entity.RegistroPsicologico;

public interface IRegistroPsicologicoService {
	
	public RegistroPsicologico save(RegistroPsicologico registro);
	
	public List<RegistroPsicologico> findRegistrosEstudiantes(Long estudiante);
}
