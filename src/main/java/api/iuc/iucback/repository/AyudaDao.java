package api.iuc.iucback.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.iuc.iucback.entity.Ayuda;

public interface AyudaDao extends JpaRepository<Ayuda, Long>{

	
	@Query(value="SELECT e.* FROM ayudas_estudiantes e " +
			   "WHERE e.estudiantes_id ilike %:id%", nativeQuery = true)
		Object findByEstudiante(@Param("id") String id);
	
	@Query(value="SELECT count(estudiante_id), ay.descripcion FROM estudiantes_ayudas e RIGHT JOIN " +
			   "ayudas ay on ay.id = e.ayudas_id where ay.activo=true group by e.ayudas_id, ay.descripcion order by count desc", nativeQuery = true)
	List<Map<String, Object>> listAyudasCantidad();
	
	@Query(value="SELECT t.estudiante_id, t.ayudas_id, t.descripcion as ayuda, es.nombre, es.apellido, es.grupo, es.documento FROM (estudiantes_ayudas e RIGHT JOIN ayudas ay on ay.id = e.ayudas_id) t Right join estudiantes es on t.estudiante_id=es.id "
			+ "where t.activo=true and es.documento ilike %:documento% and es.grupo||'' ilike :idGrupo and ayudas_id||'' ilike :idAyuda", nativeQuery = true)
	List<Map<String, Object>> listAyudasFilter(@Param("documento") String documento, @Param("idGrupo") String idGrupo, @Param("idAyuda") String idAyuda);
}
