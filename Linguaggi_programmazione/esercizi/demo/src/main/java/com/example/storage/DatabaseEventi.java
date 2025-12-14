package com.example.storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Evento;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DatabaseEventi {
  private static final String EVENTI_FILE = "eventi.json";
  private static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

  public static List<Evento> caricaEventi(){
    File file = new File(EVENTI_FILE);
    if(!file.exists()){
      return new ArrayList<>();
    }
    try{
      return mapper.readValue(file, new TypeReference<List<Evento>>(){});
    }catch(IOException e){
      e.printStackTrace();
      return new ArrayList<>();
    }
  } 

  public static void salvaEvento(List<Evento> eventi){
    try{
      mapper.writeValue(new File(EVENTI_FILE), eventi);
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}