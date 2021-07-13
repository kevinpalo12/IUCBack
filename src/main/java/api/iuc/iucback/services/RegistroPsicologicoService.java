package api.iuc.iucback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.iuc.iucback.entity.RegistroPsicologico;
import api.iuc.iucback.repository.RegistroPsicologicoDao;

@Service
public class RegistroPsicologicoService implements IRegistroPsicologicoService {

	@Autowired
	private RegistroPsicologicoDao registroPsicologicoDao;
	
	@Override
	@Transactional
	public RegistroPsicologico save(RegistroPsicologico registro) {
		return registroPsicologicoDao.save(registro);
	}

	@Override
	@Transactional
	public List<RegistroPsicologico> findRegistrosEstudiantes(Long estudiante) {
		return registroPsicologicoDao.findRegistrosEstudiantes(estudiante);
	}

	
}
