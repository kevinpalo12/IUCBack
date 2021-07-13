package api.iuc.iucback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.iuc.iucback.entity.Actividad;

public interface ActividadDao extends JpaRepository<Actividad, Long>{
/*
	@Query(value="SELECT e.* FROM estudiantes_actividades e " +
			   "WHERE e.estudiante_id ilike %:id%", nativeQuery = true)
		Object findByEstudiante(@Param("id") String id);
		*/
}
