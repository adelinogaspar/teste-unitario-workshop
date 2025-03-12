package br.com.itau.workshop.facade;

import br.com.itau.workshop.facade.exception.HabilidadeNaoEncontradaException;
import br.com.itau.workshop.facade.exception.MuitasHabilidadesException;
import br.com.itau.workshop.facade.exception.SemHabilidadesException;
import br.com.itau.workshop.repository.HabilidadeRepository;
import br.com.itau.workshop.repository.entity.HabilidadeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Set;

@Service
public class HabilidadeFacade {
    @Autowired
    HabilidadeRepository habilidadeRepository;

    private final int MAXIMO_HABILIDADES_SEGURANCA = 3;

    public List<HabilidadeEntity> listaHabilidades() {
        return habilidadeRepository.findAll();
    }

    void validaSePossuiMuitasHabilidades(Set<HabilidadeEntity> habilidades) {
        if (habilidades != null && habilidades.stream().count() > MAXIMO_HABILIDADES_SEGURANCA) {
            throw new MuitasHabilidadesException("Este aluno possui mais habilidades do que o esperado. Pode ser um risco para a infraestrutura da escola.");
        }
    }

    void validaSePossuiHabilidades(Set<HabilidadeEntity> habilidades) {
        if (habilidades == null || habilidades.isEmpty()) {
            throw new SemHabilidadesException("Parece que esse aluno não possui nenhuma habilidade. Ele é realmente um mutante?");
        }
    }

    void validaSeAsHabilidadesEstaoCadastradas(Set<HabilidadeEntity> habilidades) {
        Set<String> habilidadeIds = habilidades.stream()
                .map(HabilidadeEntity::getId)
                .collect(Collectors.toSet());

        Set<String> habilidadesEncontradas = habilidadeRepository.findHabilidadesPorListaDeIds(habilidadeIds);

        if (!habilidadesEncontradas.containsAll(habilidadeIds)) {
            throw new HabilidadeNaoEncontradaException("Algumas habilidades não foram encontradas no cadastro da escola. Por favor, cadastre elas antes ou escolha entre as existentes.");
        }
    }

    void validaHabilidades(Set<HabilidadeEntity> habilidades) {
        validaSePossuiHabilidades(habilidades);
        validaSePossuiMuitasHabilidades(habilidades);
        validaSeAsHabilidadesEstaoCadastradas(habilidades);
    }
}
