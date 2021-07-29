package api.iuc.iucback.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.iuc.iucback.entity.Estudiante;
import api.iuc.iucback.entity.Profesor;
import api.iuc.iucback.services.IProfesorService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

	@Autowired
	private IProfesorService profesorService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Profesor profesor) {
		Profesor profesorNew = null;
		Map<String, Object> response = new HashMap<>();
		try {			
			profesorNew = profesorService.save(profesor);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El profesor ha sido creado con éxito");
		response.put("profesor", profesorNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/page/{page}")
	public Page<Profesor> index(@PathVariable int page) {
		Pageable pageable = PageRequest.of(page, 10);
		return profesorService.findAll(pageable);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){

		Map<String, Object> response = new HashMap<>();
		try {			
			 profesorService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "No se puede eliminar el profesor");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El profesor ha sido eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/sin-grupo")
	public ResponseEntity<?> profesoresSinGrupo(){
		Map<String, Object> response = new HashMap<>();
		try {		
			response.put("respuesta",  profesorService.profesoresSinGrupo());
		} catch (DataAccessException e) {
			response.put("mensaje", "No se puede eliminar el profesor");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", true);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
