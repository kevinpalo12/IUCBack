package api.iuc.iucback.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import api.iuc.iucback.entity.Estudiante;
import api.iuc.iucback.entity.Grupo;
import api.iuc.iucback.entity.Padre;
import api.iuc.iucback.services.IEstudianteService;
import api.iuc.iucback.services.IGrupoService;
import api.iuc.iucback.services.IPadreService;

//@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IGrupoService grupoService;

	@Autowired
	private IPadreService padreService;

	@GetMapping("/all")
	public List<Estudiante> index() {
		return estudianteService.findAll();
	}

	@GetMapping("/grupo/{grupo}")
	public List<Estudiante> porGrupo(@PathVariable Long grupo) {
		return estudianteService.porGrupo(grupo);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Estudiante estudiante) {
		Estudiante estudianteNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			Grupo grupo = grupoService.findById(estudiante.getGrupo().getId());
			estudiante.setGrupo(grupo);
			Padre padre = padreService.findById(estudiante.getPadre().getId());
			estudiante.setPadreId(padre);
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

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Estudiante estudiante, @PathVariable Long id) {
		Estudiante estudianteActual = estudianteService.findById(id);
		Estudiante estudianteActualizado = null;

		Map<String, Object> response = new HashMap<>();

		if (estudianteActual == null) {
			response.put("mensaje", "el cliente ID: "
					.concat(id.toString().concat(" no existe en la base de datos por tanto no se puede editar")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			if (estudiante.getNombre() != null)
				estudianteActual.setNombre(estudiante.getNombre());
			if (estudiante.getApellido() != null) {
				estudianteActual.setApellido(estudiante.getApellido());
			}
			if (estudiante.getDocumento() != null)
				estudianteActual.setDocumento(estudiante.getDocumento());
			if (estudiante.getEstado()!=null&&(estudiante.getEstado().equals("MATRICULADO")||estudiante.getEstado().equals("DESERCION")||estudiante.getEstado().equals("TRASLADO"))) {
				estudianteActual.setEstado(estudiante.getEstado());
			}
			if(estudiante.getPadre()!=null) {
				Padre padre = padreService.findById(estudiante.getPadre().getId());
				estudianteActual.setPadreId(padre);
			}
			if(estudiante.getGrupo()!=null) {
				Grupo grupo = grupoService.findById(estudiante.getGrupo().getId());
				estudianteActual.setGrupo(grupo);
			}
			if(estudiante.getNacimiento()!=null) {
				estudianteActual.setNacimiento(estudiante.getNacimiento());
			}
			estudianteActualizado = estudianteService.save(estudianteActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el estudiante en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El estudiante ha sido actualizado con éxito");
		response.put("estudiante", estudianteActualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
