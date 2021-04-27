package api.iuc.iucback.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
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

import api.iuc.iucback.entity.Ayuda;
import api.iuc.iucback.services.IAyudaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/ayuda")
public class AyudaController {

	@Autowired
	private IAyudaService ayudaService;


	@GetMapping("/all")
	public List<Ayuda> index() {
		return ayudaService.findAll();
	}

	@GetMapping("/allCantidad")
	public List<Map<String, Object>> indexCantidad() {
		return ayudaService.listarCantidad();
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Ayuda ayuda) {
		Ayuda ayudaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {

			ayudaNew = ayudaService.save(ayuda);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La ayuda ha sido creado con éxito");
		response.put("ayuda", ayudaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PostMapping("/listFiltro/{page}")
	public ResponseEntity<?> listFiltro(@RequestBody Map<String, String> filtro, @PathVariable int page) {
		Page<Map<String, Object>> lista = null;
		Map<String, Object> response = new HashMap<>();
		try {
			lista = ayudaService.findAllEstudiantes(filtro.get("documento"), filtro.get("idGrupo"),  filtro.get("idAyuda"),page);
			
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", true);
		response.put("lista", lista);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/agregarEntrega/{id}")
	public ResponseEntity<?> agregarAyuda(@PathVariable Long id, @RequestBody Map<String, Object> proxima)
			throws Exception {
		Map<String, Object> response = new HashMap<>();
		Ayuda ayudaActual = ayudaService.findById(id);
		Ayuda ayudaActualizada = null;

		if (ayudaActual == null) {
			response.put("mensaje", "la ayuda ID: "
					.concat(id.toString().concat(" no existe en la base de datos por tanto no se puede editar")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			ayudaActual.setUltimaEntrega(ayudaActual.getProximaEntrega());
			Date nuevaFecha = new SimpleDateFormat("yyyy-MM-dd").parse(proxima.get("proxima").toString());
			ayudaActual.setProximaEntrega(nuevaFecha);
			System.out.println(ayudaActual.getProximaEntrega());
			ayudaActualizada = ayudaService.save(ayudaActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el estudiante en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El estudiante ha sido actualizado con éxito, ayuda agregada");
		response.put("ayuda", ayudaActualizada);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
