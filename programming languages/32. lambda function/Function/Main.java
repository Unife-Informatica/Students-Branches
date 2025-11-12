import java.util.function.Function;
public class Main {
  public static void main() {
    /*
     * L'interfaccia Function<T,R> prende un argomento (T) e restituisce un valore(R)
     * i ``::`` servono per creare un riferimento alla funzione `length`,
     * è come se passassi dentro le parentesi di `length`` cio che passo in `apply``
     */
    Function<String, Integer> numeroLettere = String::length;

    System.out.println(numeroLettere.apply("ciao"));
  }
}
