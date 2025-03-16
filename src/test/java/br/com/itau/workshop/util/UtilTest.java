package br.com.itau.workshop.util;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {
    private static final String REGEX_SOMENTE_LETRAS_E_NUMEROS = "[a-fA-F0-9]+";

    @Test
    void geraId() {
        String id = Util.geraId();

        assertNotNull(id);
        assertEquals(32, id.length(), "O resultado gerado pelo UUID possui mais do que 32 caracteres");
        assertTrue(id.matches(REGEX_SOMENTE_LETRAS_E_NUMEROS), "O resultado possui mais do que letras e numeros");
    }

}