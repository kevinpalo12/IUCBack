package api.iuc.iucback.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.iuc.iucback.entity.Padre;
import api.iuc.iucback.services.IPadreService;

//@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/padre")
public class PadreController {

	@Autowired
	private IPadreService padreService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Padre padre) {
		Padre padreNew = null;
		Map<String, Object> response = new HashMap<>();
		try {				
			padreNew = padreService.save(padre);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El padre ha sido creado con éxito");
		response.put("padre", padreNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
