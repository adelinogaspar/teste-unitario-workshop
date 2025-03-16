package br.com.itau.workshop.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String JSON_DIR = "/mocks/";

    private static ClassPathResource validaArquivo(String fileName) {
        String fullPath = JSON_DIR + fileName;
        ClassPathResource resource = new ClassPathResource(fullPath);

        if (!resource.exists()) {
            throw new IllegalArgumentException("Arquivo não encontrado: " + fullPath);
        }

        return resource;
    }

    public static <T> T loadFromJson(String fileName, Class<T> clazz) throws IOException {
        ClassPathResource resource = validaArquivo(fileName);

        try (InputStream inputStream = resource.getInputStream()) {
            return objectMapper.readValue(inputStream, clazz);
        }
    }

    public static <T> List<T> loadListFromJson(String fileName, TypeReference<List<T>> typeRef) throws IOException {
        ClassPathResource resource = validaArquivo(fileName);

        try (InputStream inputStream = resource.getInputStream()) {
            return objectMapper.readValue(inputStream, typeRef);
        }
    }

    public static <T> List<T> loadListFromJsonString(String jsonBody, TypeReference<List<T>> typeRef) throws IOException {
        return objectMapper.readValue(jsonBody, typeRef);
    }
}
