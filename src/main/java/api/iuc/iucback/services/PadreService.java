package api.iuc.iucback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.iuc.iucback.entity.Padre;
import api.iuc.iucback.repository.PadreDao;

@Service
public class PadreService implements IPadreService{

	@Autowired
	private PadreDao padreDao;
	
	@Override
	@Transactional
	public Padre save(Padre padre) {
		return padreDao.save(padre);
	}

	@Override
	@Transactional(readOnly = true)
	public Padre findById(Long id) {
		return padreDao.findById(id).orElse(null);
	}

}
