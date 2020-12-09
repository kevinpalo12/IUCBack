package api.iuc.iucback.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.iuc.iucback.entity.Estudiante;
import api.iuc.iucback.repository.EstudianteDao;
import api.iuc.iucback.repository.GrupoDao;

@Service
public class EstudianteService implements IEstudianteService {

	@Autowired
	private EstudianteDao estudianteDao;
	
	
	
	@Override
	@Transactional
	public Estudiante save(Estudiante estudiante) {
		return estudianteDao.save(estudiante);
	}

}
