package api.iuc.iucback.services;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.iuc.iucback.entity.Grupo;
import api.iuc.iucback.repository.GrupoDao;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GrupoService implements IGrupoService {

	@Autowired
	private GrupoDao grupoDao;
	
	@Override
	@Transactional
	public Grupo save(Grupo grupo) {
		return grupoDao.save(grupo);
	}

	@Override
	@Transactional(readOnly = true)
	public Grupo findById(Long id) {
		return grupoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Grupo> findAll() {
		return grupoDao.findAll();
	}

	@Override
	public Page<Grupo> findAll(Pageable pegeable) {
		return grupoDao.findAll(pegeable);
	}

	@Override
	public Map<String, Object> getNroEstudiantes(Long id) {
		return grupoDao.getNroEstudiantes(id);
	}
	

}
