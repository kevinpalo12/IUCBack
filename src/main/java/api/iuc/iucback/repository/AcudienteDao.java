package api.iuc.iucback.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.iuc.iucback.entity.Acudiente;


public interface AcudienteDao extends JpaRepository<Acudiente, Long>{

	
	@Query(value="SELECT e.* FROM acudientes e " +
			   "WHERE e.cedula ilike :cedula", nativeQuery = true)
		Acudiente findByCedula(@Param("cedula") String cedula);
	
}
