import java.util.ArrayList;
import java.util.List;

public class Esercizio5 {
  public static void main(String[] args) {
    List<String> parole = new ArrayList<>();
    parole.add("Ciao");
    parole.add("Mondo");
    parole.add("java");
    for(String parola : parole){
      System.out.println(parola);
    } 
  }
}
