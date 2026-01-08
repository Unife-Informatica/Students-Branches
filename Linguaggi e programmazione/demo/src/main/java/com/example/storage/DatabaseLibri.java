package com.example.storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Libro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DatabaseLibri {

    private static final String FILE_PATH = "libri.json";
    private static final ObjectMapper mapper =
            new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @SuppressWarnings("CallToPrintStackTrace")
    public static List<Libro> caricaLibri() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            return mapper.readValue(
                    file,
                    new TypeReference<List<Libro>>() {
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static void salvaLibri(List<Libro> libri) {
        try {
            mapper.writeValue(new File(FILE_PATH), libri);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
