package br.com.itau.workshop.facade;

import br.com.itau.workshop.repository.AlunoRepository;
import br.com.itau.workshop.repository.entity.AlunoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoFacade {
    @Autowired
    AlunoRepository alunoRepository;

    public List<AlunoEntity> buscarAlunoPorNome(String nomeAluno) {
        String nomePesquisa = nomeAluno != null ? nomeAluno : "";
        return alunoRepository.findByNomeRealIgnoreCaseStartingWith(nomePesquisa);
    }
}
