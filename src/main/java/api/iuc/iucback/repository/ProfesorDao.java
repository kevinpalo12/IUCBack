package api.iuc.iucback.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.iuc.iucback.entity.Profesor;

public interface ProfesorDao extends JpaRepository<Profesor, Long> {

	

	@Query(value=" select p.id, p.nombre from (select * from grupo) g right join \r\n"
			+ " (select * from profesores) p on g.profesor_id = p.id\r\n"
			+ " where g.grado is null", nativeQuery = true)
	List<Map<String, Object>> profesoresSinGrupo();
}
