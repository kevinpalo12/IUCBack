package api.iuc.iucback.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.iuc.iucback.entity.ActividadEstudiante;
import api.iuc.iucback.entity.ActividadEstudiantePK;

public interface ActividadEstudianteDao extends JpaRepository<ActividadEstudiante, ActividadEstudiantePK> {

	@Query(value="SELECT ea.* FROM estudiantes_actividades ea " +
			   "WHERE ea.estudiante_id = :id", nativeQuery = true)
		List<Map<String, Object>> findActividad(@Param("id") Long id);
}
