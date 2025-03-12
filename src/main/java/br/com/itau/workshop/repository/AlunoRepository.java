package br.com.itau.workshop.repository;

import br.com.itau.workshop.repository.entity.AlunoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<AlunoEntity, String> {
    List<AlunoEntity> findByNomeRealIgnoreCaseStartingWith(String prefixoNome);
}
