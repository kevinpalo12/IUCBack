package api.iuc.iucback.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.iuc.iucback.entity.Ayuda;
import api.iuc.iucback.entity.Grupo;
import api.iuc.iucback.repository.AyudaDao;

@Service
public class AyudaService implements IAyudaService {

	@Autowired
	private AyudaDao ayudaDao;

	@Autowired
	private IGrupoService grupoService;

	@Override
	@Transactional
	public Ayuda save(Ayuda ayuda) {
		return ayudaDao.save(ayuda);
	}
	
	@Override
	@Transactional
	public List<String> cantAyudas() {
		return ayudaDao.cantAyudas();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ayuda> findAll() {
		return ayudaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Ayuda findById(Long id) {
		return ayudaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> listarCantidad() {
		return ayudaDao.listAyudasCantidad();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Map<String, Object>> findAllEstudiantes(String descripcion, int page) {
		Pageable pageable = PageRequest.of(page, 10);
		List<Map<String, Object>> listEstudiantes = ayudaDao.listAyudasFilter(descripcion);
		List<Map<String, Object>> fin = new ArrayList<>();

		int tamano = 10;
		if (page == listEstudiantes.size() / 10 && listEstudiantes.size() % 10 < 10) {
			tamano = listEstudiantes.size() % 10;
		}
		for (int i = 0; i < tamano; i++) {
			Map<String, Object> estudiante = listEstudiantes.get((i + (int) pageable.getOffset()));			
			Grupo grupo = grupoService.findById(Long.parseLong(String.valueOf(estudiante.get("grupo"))));
			Map<String, Object> newMap = new HashMap<>();
			newMap.putAll(estudiante);
			newMap.put("grupo",grupo);
			System.out.println(newMap.toString());
			fin.add(newMap);
		}
		Page<Map<String, Object>> paginas = new PageImpl<Map<String, Object>>(fin, pageable, listEstudiantes.size());
		return paginas;
	}
	
	
}
