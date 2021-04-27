package api.iuc.iucback.services;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.iuc.iucback.entity.Grupo;
import api.iuc.iucback.entity.Profesor;
import api.iuc.iucback.repository.ProfesorDao;

@Service
public class ProfesorService implements IProfesorService {

	@Autowired
	private ProfesorDao profesorDao;
	
	@Override
	@Transactional
	public Profesor save(Profesor profesor) {
		// TODO Auto-generated method stub
		return profesorDao.save(profesor);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Profesor findById(Long id) {
		return profesorDao.findById(id).orElse(null);
	}

	@Override

	@Transactional(readOnly = true)
	public List<Profesor> findAll() {
		return profesorDao.findAll();
	}

	
}
