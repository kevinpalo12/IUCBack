package api.iuc.iucback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.iuc.iucback.entity.Actividad;
import api.iuc.iucback.repository.ActividadDao;

@Service
public class ActividadService implements IActividadService{

	@Autowired
	private ActividadDao actividadDao;
	
	@Override
	public Actividad save(Actividad actividad) {
		// TODO Auto-generated method stub
		return actividadDao.save(actividad);
	}

	@Override
	public Actividad findById(Long Id) {
		// TODO Auto-generated method stub
		return actividadDao.findById(Id).orElse(null);
	}

	@Override
	public List<Actividad> findAll() {
		// TODO Auto-generated method stub
		return actividadDao.findAll();
	}

}
