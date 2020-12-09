package api.iuc.iucback.services;



import org.springframework.beans.factory.annotation.Autowired;
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

}
