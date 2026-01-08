package com.example.storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Prestito;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DatabasePrestito {

    private static final String FILE_PATH = "prestiti.json";
    private static final ObjectMapper mapper =
            new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @SuppressWarnings("CallToPrintStackTrace")
    public static List<Prestito> caricaPrestiti() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            return mapper.readValue(
                    file,
                    new TypeReference<List<Prestito>>() {
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static void salvaPrestiti(List<Prestito> prestiti) {
        try {
            mapper.writeValue(new File(FILE_PATH), prestiti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
