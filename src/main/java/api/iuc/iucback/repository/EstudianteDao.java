package api.iuc.iucback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.iuc.iucback.entity.Estudiante;

public interface EstudianteDao extends JpaRepository<Estudiante, Long> {

	@Query(value="SELECT e.* FROM estudiantes e " +
			   "WHERE e.grupo = :grupo", nativeQuery = true)
		List<Estudiante> estudiantesGrupo(@Param("grupo") Long grupo);
}
