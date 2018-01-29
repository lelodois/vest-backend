package br.com.lelo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lelo.backend.model.Curriculum;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
}
