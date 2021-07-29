package api.iuc.iucback.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.iuc.iucback.entity.Inasistencia;

public interface InasistenciaDao extends JpaRepository<Inasistencia, Long>{

	@Query(value="select * from inasistencias i right join (\r\n"
			+ "select MAX(fecha) as fecha_entrega\r\n"
			+ "from inasistencias \r\n"
			+ "where estudiante_id = :id) ex on i.fecha= ex.fecha_entrega and i.estudiante_id = :id", nativeQuery = true)
		Map<String, Object> UltimaEstudiante(@Param("id") Long id);
}
