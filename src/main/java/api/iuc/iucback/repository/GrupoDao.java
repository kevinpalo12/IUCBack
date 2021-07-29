package api.iuc.iucback.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.iuc.iucback.entity.Grupo;

public interface GrupoDao extends JpaRepository<Grupo, Long>{

	@Query(value="select count(id), grupo from estudiantes where grupo = :id group by grupo", nativeQuery = true)
	Map<String, Object> getNroEstudiantes(@Param("id") Long id);
}
