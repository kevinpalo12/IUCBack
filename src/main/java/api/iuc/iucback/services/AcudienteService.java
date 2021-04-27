package api.iuc.iucback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.iuc.iucback.entity.Acudiente;
import api.iuc.iucback.repository.AcudienteDao;

@Service
public class AcudienteService implements IAcudienteService{

	@Autowired
	private AcudienteDao acudienteDao;
	
	@Override
	@Transactional
	public Acudiente save(Acudiente padre) {
		return acudienteDao.save(padre);
	}

	@Override
	@Transactional(readOnly = true)
	public Acudiente findById(Long id) {
		return acudienteDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Acudiente findByCedula(String cedula) {
		return acudienteDao.findByCedula(cedula);
	}

}
