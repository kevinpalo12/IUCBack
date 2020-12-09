package api.iuc.iucback.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.iuc.iucback.entity.Estudiante;
import api.iuc.iucback.entity.Grupo;
import api.iuc.iucback.services.IEstudianteService;
import api.iuc.iucback.services.IGrupoService;

//@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IGrupoService grupoService;
	

	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Estudiante estudiante) {
		Estudiante estudianteNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			Grupo grupo = grupoService.findById(estudiante.getGrupo().getId());
			estudiante.setGrupo(grupo);
			estudianteNew = estudianteService.save(estudiante);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El estudiante ha sido creado con éxito");
		response.put("estudiante", estudianteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
