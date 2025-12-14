package com.example.storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DatabaseClienti {
  private static final String CLIENTI_FILE = "clienti.json";
  private static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

  public static List<Cliente> caricaClienti(){
    File file = new File(CLIENTI_FILE);
    if(!file.exists()){
      return new ArrayList<>();
    }
    try{
      return mapper.readValue(file, new TypeReference<List<Cliente>>(){});
    }catch(IOException e){
      e.printStackTrace();
      return new ArrayList<>();
    }
  } 

  public static void salvaCliente(List<Cliente> clienti){
    try{
      mapper.writeValue(new File(CLIENTI_FILE), clienti);
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}


