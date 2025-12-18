package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        BankAccount bankAccount = new BankAccount(123, "Geekific");

        // Scrive nella cartella del progetto
        File output = new File("libri.json");

        objectMapper.writeValue(output, bankAccount);

        System.out.println("File JSON scritto in: " + output.getAbsolutePath());
    }
}
