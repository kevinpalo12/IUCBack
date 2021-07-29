package api.iuc.iucback.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import api.iuc.iucback.entity.Inasistencia;
import api.iuc.iucback.repository.InasistenciaDao;

@Service
public class InasistenciaService implements IInasistenciaService {

	private final Path root = Paths.get("uploads");
	
	@Autowired
	private InasistenciaDao inasistenciaDao;
	
	
	@Override
    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("No se puede inicializar la carpeta uploads");
        }
    }
	
	@Override
	public Inasistencia create(Inasistencia inasistencia) {
		
		return inasistenciaDao.save(inasistencia);
	}
	
	@Override
	    public void saveFile(MultipartFile file) {
	        try {
	            //copy (que queremos copiar, a donde queremos copiar)
	            Files.copy(file.getInputStream(), 
	                       this.root.resolve(file.getOriginalFilename()));
	        } catch (IOException e) {
	            throw new RuntimeException("No se puede guardar el archivo. Error " + e.getMessage());
	        }
	    }
	
	@Override
    public Resource loadFile(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new RuntimeException("No se puede leer el archivo ");
            }

        }catch (MalformedURLException e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

}
