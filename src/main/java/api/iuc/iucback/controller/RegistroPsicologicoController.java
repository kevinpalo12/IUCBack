package api.iuc.iucback.controller;

import java.util.HashMap;
import java.util.List;
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

import api.iuc.iucback.entity.Estudiante;
import api.iuc.iucback.entity.Profesor;
import api.iuc.iucback.entity.RegistroPsicologico;
import api.iuc.iucback.services.IEstudianteService;
import api.iuc.iucback.services.IRegistroPsicologicoService;

@RestController
@RequestMapping("/api/psicologico")
@CrossOrigin(origins = { "http://localhost:4200" })
public class RegistroPsicologicoController {

	@Autowired
	private IRegistroPsicologicoService registroPsicologicoService;
	
	@Autowired IEstudianteService estudianteService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody RegistroPsicologico registro) {
		RegistroPsicologico registroNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			Estudiante estudiante = estudianteService.findById(registro.getEstudiante().getId());
			registro.setEstudiante(estudiante);
			registroNew = registroPsicologicoService.save(registro);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El registro ha sido creado con éxito");
		response.put("registro", registroNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/registros/{estudiante}")
	public List<RegistroPsicologico> porGrupo(@PathVariable Long estudiante) {
		return registroPsicologicoService.findRegistrosEstudiantes(estudiante);
	}
}
