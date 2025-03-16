package br.com.itau.workshop.controller;


import br.com.itau.workshop.controller.response.HabilidadeDetalheResponse;
import br.com.itau.workshop.facade.HabilidadeFacade;
import br.com.itau.workshop.mapper.HabilidadeMapper;
import br.com.itau.workshop.repository.entity.HabilidadeEntity;
import br.com.itau.workshop.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class HabilidadeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HabilidadeFacade habilidadeFacade;

    @Autowired
    private HabilidadeMapper habilidadeMapper;

    @Test
    void testListaHabilidadesControllerOK() throws Exception {
        // Carrega um objeto mockado
        List<HabilidadeEntity> habilidadeEntityList = JsonUtil.loadListFromJson("HabilidadeEntityListOK.json", new TypeReference<List<HabilidadeEntity>>() {});
        Mockito.when(habilidadeFacade.listaHabilidades()).thenReturn(habilidadeEntityList);

        // chama o controller como um cUrl
        MvcResult resultController = mockMvc.perform(get("/habilidade"))
                .andExpect(status().isOk())
                .andReturn();

        // Obtem o resultado do controller (json) e converte para um objeto
        // Força o json a ser lido como UTF8 por causa dos acentos
        List<HabilidadeDetalheResponse> responseBodyAtual = JsonUtil.loadListFromJsonString(resultController.getResponse().getContentAsString(StandardCharsets.UTF_8), new TypeReference<List<HabilidadeDetalheResponse>>() {});

        // Carrega o mesmo objeto do controller, mas através de um arquivo json mockado na pasta resources
        List<HabilidadeDetalheResponse> responseBodyEsperado = JsonUtil.loadListFromJson("HabilidadeDetalheResponseListOK.json", new TypeReference<List<HabilidadeDetalheResponse>>() {});

        // compara o resultado obtido pelo controller com o mock esperado
        assertThat(responseBodyAtual)
                .usingRecursiveComparison()
                .isEqualTo(responseBodyEsperado);

    }
}
