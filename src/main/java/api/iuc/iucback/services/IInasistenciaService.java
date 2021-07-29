package api.iuc.iucback.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import api.iuc.iucback.entity.Inasistencia;

public interface IInasistenciaService {

	public Inasistencia create(Inasistencia inasistencia);

	public void init();

	public void saveFile(MultipartFile file);

	public Resource loadFile(String filename);
	
}
