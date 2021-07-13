package api.iuc.iucback.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.iuc.iucback.entity.Ayuda;

public interface AyudaDao extends JpaRepository<Ayuda, Long>{

	
	@Query(value="SELECT e.* FROM estudiantes_ayudas e " +
			   "WHERE e.estudiantes_id ilike %:id%", nativeQuery = true)
		Object findByEstudiante(@Param("id") String id);
	
	@Query(value="SELECT count(estudiante_id), ay.descripcion FROM estudiantes_ayudas e RIGHT JOIN " +
			   "ayudas ay on ay.id = e.ayudas_id group by ay.descripcion order by count desc", nativeQuery = true)
	List<Map<String, Object>> listAyudasCantidad();
	
	@Query(value="SELECT tt.estudiante_id, tt.ayudas_id, tt.nombre, tt.apellido, tt.grupo, tt.documento, y.descripcion as ayuda, y.fecha_entrega as fecha "
			+ "FROM (estudiantes es left join estudiantes_ayudas t on t.estudiante_id=es.id) tt left join ayudas y on tt.ayudas_id=y.id"
			+ " where tt.ayudas_id\\:\\:varchar(255) ilike %:id% order by fecha desc", nativeQuery = true)
	List<Map<String, Object>> listAyudasFilter(@Param("id") String id);
	
	@Query(value="SELECT  descripcion FROM public.ayudas group by descripcion;", nativeQuery = true)
	List<String> cantAyudas();
}
