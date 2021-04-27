package api.iuc.iucback.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.iuc.iucback.entity.Grupo;
import api.iuc.iucback.entity.Profesor;
import api.iuc.iucback.services.*;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/grupo")
public class GrupoController {
	
	@Autowired
	private IGrupoService grupoService;
	
	@Autowired
	private IProfesorService profesorService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Grupo grupo) {
		Grupo grupoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			Profesor profesor = profesorService.findById(grupo.getProfesor().getId());
			grupo.setProfesor(profesor);
			grupoNew = grupoService.save(grupo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El grupo ha sido creado con éxito");
		response.put("grupo", grupoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/index")
	public List<Grupo> index(){
		return grupoService.findAll();
	}
}
