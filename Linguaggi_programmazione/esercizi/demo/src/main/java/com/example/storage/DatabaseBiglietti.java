package com.example.storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Biglietto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DatabaseBiglietti {
  private static final String BIGLIETTI_FILE = "biglietti.json";
  private static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

  public static List<Biglietto> caricaBiglietto(){
    File file = new File(BIGLIETTI_FILE);
    if(!file.exists()){
      return new ArrayList<>();
    }
    try{
      return mapper.readValue(file, new TypeReference<List<Biglietto>>(){});
    }catch(IOException e){
      e.printStackTrace();
      return new ArrayList<>();
    }
  } 

  public static void salvaBiglietto(List<Biglietto> biglietti){
    try{
      mapper.writeValue(new File(BIGLIETTI_FILE), biglietti);
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}