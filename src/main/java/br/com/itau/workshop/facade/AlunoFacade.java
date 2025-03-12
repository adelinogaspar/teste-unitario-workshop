package br.com.itau.workshop.facade;

import br.com.itau.workshop.controller.request.AlunoDetalheRequest;
import br.com.itau.workshop.facade.exception.AlunoJaCadastradoException;
import br.com.itau.workshop.mapper.AlunoMapper;
import br.com.itau.workshop.repository.AlunoRepository;
import br.com.itau.workshop.repository.entity.AlunoEntity;
import br.com.itau.workshop.repository.entity.HabilidadeEntity;
import br.com.itau.workshop.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class AlunoFacade {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    HabilidadeFacade habilidadeFacade;

    @Autowired
    AlunoMapper alunoMapper;

    public List<AlunoEntity> buscarAlunoPorNome(String nomeAluno) {
        String nomePesquisa = nomeAluno != null ? nomeAluno : "";
        return alunoRepository.findByNomeRealIgnoreCaseStartingWith(nomePesquisa);
    }

    private void preparaAlunoParaCadastro(AlunoEntity alunoEntity) {
        alunoEntity.setId(Util.geraId());
        alunoEntity.setDataCadastro(LocalDate.now());
    }

    private void validaSeAlunoJaFoiCadastrado(AlunoEntity alunoEntity) {
        if (!alunoRepository.findByNomeReal(alunoEntity.getNomeReal()).isEmpty()) {
            throw new AlunoJaCadastradoException(String.format("O aluno %s já está cadastrado na escola.", alunoEntity.getNomeReal()));
        }
    }

    public AlunoEntity cadastraAluno(AlunoDetalheRequest alunoDetalheRequest) {
        AlunoEntity alunoEntity = alunoMapper.toAlunoEntity(alunoDetalheRequest);
        habilidadeFacade.validaHabilidades(alunoEntity.getHabilidades());
        validaSeAlunoJaFoiCadastrado(alunoEntity);
        preparaAlunoParaCadastro(alunoEntity);
        return alunoRepository.save(alunoEntity);
    }
}
