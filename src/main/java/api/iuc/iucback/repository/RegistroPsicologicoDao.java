package api.iuc.iucback.repository;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.iuc.iucback.entity.RegistroPsicologico;

public interface RegistroPsicologicoDao extends JpaRepository<RegistroPsicologico,Long> {

	@Query(value="SELECT * FROM registro_psicologico " +
			   "WHERE estudiante = :estudiante", nativeQuery = true)
		List<RegistroPsicologico> findRegistrosEstudiantes(@Param("estudiante") Long estudiante);
}
