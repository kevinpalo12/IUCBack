package api.iuc.iucback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.iuc.iucback.entity.Profesor;

public interface ProfesorDao extends JpaRepository<Profesor, Long> {

}
