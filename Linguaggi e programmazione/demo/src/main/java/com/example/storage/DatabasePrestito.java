package com.example.storage;

import com.example.model.Prestito;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabasePrestito {

    private static final String FILE_PATH = "prestiti.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Carica tutti i prestiti dal file JSON.
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public static List<Prestito> caricaPrestiti() {
        try {
            File file = new File(FILE_PATH);

            if (!file.exists()) return new ArrayList<>();

            return mapper.readValue(
                    file,
                    new TypeReference<List<Prestito>>() {}
            );

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Salva tutti i prestiti nel file JSON.
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public static void salvaPrestiti(List<Prestito> prestiti) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(
                    new File(FILE_PATH),
                    prestiti
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

