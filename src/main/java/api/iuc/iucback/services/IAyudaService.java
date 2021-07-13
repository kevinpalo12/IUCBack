package api.iuc.iucback.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import api.iuc.iucback.entity.Ayuda;

public interface IAyudaService {

	public List<Ayuda> findAll();
	
	public Ayuda save(Ayuda ayuda);
	
	public Ayuda findById(Long id);
	
	public List<Map<String, Object>> listarCantidad();
	
	public Page<Map<String, Object>> findAllEstudiantes(String descripcion, int page);
	
	public List<String> cantAyudas();
}
