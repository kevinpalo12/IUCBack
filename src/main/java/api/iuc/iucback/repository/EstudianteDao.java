package api.iuc.iucback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.iuc.iucback.entity.Estudiante;

public interface EstudianteDao extends JpaRepository<Estudiante, Long> {

}
