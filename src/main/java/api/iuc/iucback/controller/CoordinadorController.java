package api.iuc.iucback.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.iuc.iucback.services.IAyudaService;
import api.iuc.iucback.services.IEstudianteService;
import api.iuc.iucback.services.IGrupoService;
import api.iuc.iucback.services.IProfesorService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/coordinador")
public class CoordinadorController {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IGrupoService grupoService;

	@Autowired
	private IAyudaService ayudaService;
	

	@Autowired
	private IProfesorService profesorService;
	
	@GetMapping("/number")
	public  ResponseEntity<?> numbers() {

		HashMap<String, String> map = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		try {			 
			 String estudiantes = estudianteService.findAll().size()+"";
			 map.put("estudiantes", estudiantes);
			 String grupos = grupoService.findAll().size()+"";
			 map.put("grupos", grupos);
			 String ayudas = ayudaService.cantAyudas().size()+"";
			 map.put("ayudas", ayudas);
			 String profesor = profesorService.findAll().size()+"";
			 map.put("profesor", profesor);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", true);
		response.put("respuesta", map);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
