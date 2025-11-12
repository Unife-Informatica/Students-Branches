/*
 * Sono interfaccie funzionali con un solo metodo astratto che non
 * restituiscono alcun risultato
 */
import java.util.function.Consumer;
import java.util.function.BiConsumer;

/*
 * Dovendo creare una interface ogni volta che si crea una funzione lambda
 * si usano i metodi Consumer e BiConsumer
 */

public class Main {
  public static void main() {
    // Cunsumer che stampa parole in maiuscolo
    Consumer<String> stampaMaiuscolo = s -> System.out.println(s.toUpperCase());
    BiConsumer<String, Integer> stampaPersona = (nome, eta) -> System.out.println("Ciao, sono " + nome + " e ho " + eta + " anni");

    // Uso il Consumer (`accept`` è un parametro fisso)
    stampaMaiuscolo.accept("ciao");
    stampaPersona.accept("Pietro", 20);
  }
}
