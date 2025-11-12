/*
 * Lo Stream è una sequenza di elementi che possono essere ciclati
 * in modo sequenziale o parallelo per essere:
 * * filtrati
 * * trasformati
 * * contati
 * * ...
 * ma non modifica la collezione originale
 */

import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<Integer> numeri = Array.asList(1, 2, 3, 4, 5);

    // // Codice senza Stream API
    // int somma = 0;
    // for (int n : numeri) {
    //   if (n % 2 == 0) {
    //     somma += n;
    //   }
    // }

    int somma = numeri.stream()             // crea uno stream dalla lista
                  .filter(n -> n % 2 == 0)  // tiene solo i pari
                  .mapToInt(n -> n)         // converte in int
                  .sum();                   // somma tutti

    System.out.println(somma);
  }
}

