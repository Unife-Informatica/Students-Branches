// 1️⃣ Questa è un'interfaccia funzionale: significa che ha UN SOLO metodo astratto
interface Functional {
  // Qui si definisce la "firma" del metodo (nome, parametri, tipo di ritorno)
  int operation(int a, int b);
}

public class Main {
  public static void main(String[] args) {
    /*
      Crea una variabile di tipo "Functional".
      Invece di scrivere una classe separata che implementa l'interfaccia,
      si puo usare una LAMBDA FUNCTION.

      Una lambda è un "modo abbreviato" per dire:
      "Quando qualcuno chiama operation(a, b), esegui questa operazione".
         
      Sintassi base (nei parametri non vanno deifiniti i tipi):
      (parametri) -> { corpo }
         
      Nel nostro caso:
      (a, b) -> a + b
      significa: "Prendi due numeri a e b, e ritorna la loro somma"
    */
    Functional add = (a, b) -> a + b;

    /*
      Qui viene richiamato il metodo operation() definito nell'interfaccia.
      Anche se non è stata scritta una classe con 'implements Functional',
      la lambda lo ha fatto "dietro le quinte".
         
      Quindi add.operation(6, 3) esegue:
      (6, 3) -> 6 + 3 → 9
    */
    System.out.println(add.operation(6, 3));
  }
}

