package api.iuc.iucback.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import api.iuc.iucback.entity.Acudiente;
import api.iuc.iucback.entity.Estudiante;
import api.iuc.iucback.entity.Grupo;
import api.iuc.iucback.entity.Inasistencia;
import api.iuc.iucback.services.IEstudianteService;
import api.iuc.iucback.services.IInasistenciaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/inasistencia")
public class InasistenciaController {
	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IInasistenciaService inasistenciaService;

	@PostMapping("/create")
	public ResponseEntity<?> save(@RequestBody Inasistencia inasistencia) {
		Inasistencia inasistenciaNew = null;
		System.out.println(inasistencia);
		Map<String, Object> response = new HashMap<>();
		try {
			Estudiante estudiante = estudianteService.findById(inasistencia.getEstudiante().getId());
			inasistencia.setEstudiante(estudiante);
			inasistenciaNew = inasistenciaService.create(inasistencia);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El estudiante tiene una nueva inasistencia");
		response.put("Inasistencia", inasistenciaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

//	@PostMapping("/saveExcusa/{id}")
//	public ResponseEntity<?> saveExcusa(@PathVariable Long id, @RequestBody MultipartFile file) {
//		Map<String, Object> response = new HashMap<>();
//
//		try {
//			String fileName = file.getOriginalFilename();
//			inasistenciaService.saveFile(file);
//			
//
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al realizar la consulta en la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
//	}

}
