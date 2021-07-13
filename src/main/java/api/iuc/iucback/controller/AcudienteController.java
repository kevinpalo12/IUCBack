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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.iuc.iucback.entity.Acudiente;
import api.iuc.iucback.services.IAcudienteService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/acudiente")
public class AcudienteController {

	@Autowired
	private IAcudienteService acudienteService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Acudiente padre) {
		Acudiente padreNew = null;
		Map<String, Object> response = new HashMap<>();
		try {				
			padreNew = acudienteService.save(padre);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El acudiente ha sido creado con éxito");
		response.put("acudiente", padreNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/cedula/{cedula}")
	public ResponseEntity<?> Filtrado(@PathVariable String cedula) {	
		
		Acudiente padreNew = null;
		Map<String, Object> response = new HashMap<>();
		try {				
			padreNew = acudienteService.findByCedula(cedula);
			response.put("mensaje", "Encontrado");
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (padreNew == null) {
			response.put("mensaje", false);
		}
		response.put("acudiente", padreNew );
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Acudiente acudiente, @PathVariable Long id) {
		Acudiente acudienteActual = acudienteService.findById(id);
		Acudiente acudienteNuevo = null;

		Map<String, Object> response = new HashMap<>();

		if (acudienteActual == null) {
			response.put("mensaje", "el acudiente ID: "
					.concat(id.toString().concat(" no existe en la base de datos por tanto no se puede editar")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			acudienteNuevo = acudienteService.save(acudiente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el estudiante en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El estudiante ha sido actualizado con éxito");
		response.put("estudiante", acudienteNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
