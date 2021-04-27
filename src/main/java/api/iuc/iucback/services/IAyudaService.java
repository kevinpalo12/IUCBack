package api.iuc.iucback.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import api.iuc.iucback.entity.Ayuda;
import api.iuc.iucback.entity.Estudiante;

public interface IAyudaService {

	public List<Ayuda> findAll();
	
	public Ayuda save(Ayuda ayuda);
	
	public Ayuda findById(Long id);
	
	public List<Map<String, Object>> listarCantidad();
	
	public Page<Map<String, Object>> findAllEstudiantes(String documento, String idGrupo, String idAyuda, int page);
}
