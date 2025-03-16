package br.com.itau.workshop.controller;


import br.com.itau.workshop.facade.HabilidadeFacade;
import br.com.itau.workshop.mapper.HabilidadeMapper;
import br.com.itau.workshop.repository.entity.HabilidadeEntity;
import br.com.itau.workshop.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


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
        List<HabilidadeEntity> habilidadeEntityList = JsonUtil.loadListFromJson("HabilidadeEntityListOK.json", new TypeReference<List<HabilidadeEntity>>() {});
        Mockito.when(habilidadeFacade.listaHabilidades()).thenReturn(habilidadeEntityList);

        mockMvc.perform(get("/habilidade"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))  // Expect 1 item in the response list
                .andExpect(jsonPath("$[0].id").value("1"))  // Check the first element's id
                .andExpect(jsonPath("$[0].tipo").value("Técnica"))  // Check the first element's tipo
                .andExpect(jsonPath("$[0].descricao").value("Habilidade avançada em desenvolvimento de software."));  // Check the first element's descricao
    }
}
