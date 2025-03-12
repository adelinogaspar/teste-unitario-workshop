package br.com.itau.workshop;

import br.com.itau.workshop.facade.AlunoFacade;
import br.com.itau.workshop.repository.entity.AlunoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApplicationTests {

	@Autowired
	AlunoFacade alunoFacade;

	@Test
	void contextLoads() {
		assertNotNull(alunoFacade);
	}

}
