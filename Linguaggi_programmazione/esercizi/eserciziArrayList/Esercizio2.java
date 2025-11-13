import java.util.ArrayList;

public class Esercizio2 {
  public static void main(String[] args) {
    ArrayList<String> s1 = new ArrayList<>();
    s1.add("Ciao");
    s1.add("come");
    s1.add("stai");
    s1.add("tu?");
    s1.remove("tu?");

    for(String parola : s1){
      System.out.println(parola);
    }
  }
}
