package br.com.itau.workshop.repository;

import br.com.itau.workshop.repository.entity.HabilidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface HabilidadeRepository extends JpaRepository<HabilidadeEntity, String> {

    @Query("SELECT ha.id FROM HabilidadeEntity ha WHERE ha.id IN :habilidadeIds")
    Set<String> findHabilidadesPorListaDeIds(@Param("habilidadeIds") Set<String> habilidadeIds);
}
