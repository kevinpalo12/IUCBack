package api.iuc.iucback.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.iuc.iucback.entity.Estudiante;

public interface EstudianteDao extends JpaRepository<Estudiante, Long> {

	@Query(value="SELECT e.* FROM estudiantes e " +
			   "WHERE e.grupo = :grupo", nativeQuery = true)
		List<Estudiante> estudiantesGrupo(@Param("grupo") Long grupo);
	
	
	@Query(value="SELECT e.* FROM estudiantes e " +
			   "WHERE e.nombre ilike %:nombre% and e.apellido ilike %:apellido% and e.documento ilike %:identificacion% ", nativeQuery = true)
		List<Estudiante> estudianteFiltro(@Param("nombre") String nombre,@Param("apellido") String apellido,@Param("identificacion") String id);
	
	@Query(value="SELECT e.nombre, e.apellido, e.id as id_estudiante, a.id as id_ayuda, a.descripcion, e.grupo, e.edad FROM estudiantes e inner join estudiantes_ayudas ea on e.id=ea.estudiante_id inner join ayudas a on a.id=ea.ayudas_id " +
			   "WHERE e.id = :id", nativeQuery = true)
		List<Map<String, Object>> findAyudas(@Param("id") Long id);
}
