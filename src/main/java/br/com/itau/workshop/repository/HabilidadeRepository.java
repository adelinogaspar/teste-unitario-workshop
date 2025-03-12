package br.com.itau.workshop.repository;

import br.com.itau.workshop.repository.entity.HabilidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadeRepository extends JpaRepository<HabilidadeEntity, String> {
}
