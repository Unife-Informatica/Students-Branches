package com.example.storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Utente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DatabaseUtenti {
    private static final String UTENTI_FILE = "utenti.json";
    private static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    @SuppressWarnings("CallToPrintStackTrace")
    public static List<Utente> caricaUtenti(){
        File file = new File(UTENTI_FILE);
        if(!file.exists()) return new ArrayList<>();
        try {
            return mapper.readValue(file, new TypeReference<List<Utente>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static void salvaUtenti(List<Utente> utenti){
        try {
            mapper.writeValue(new File(UTENTI_FILE),utenti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
