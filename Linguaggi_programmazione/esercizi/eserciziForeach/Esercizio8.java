import java.util.ArrayList;
import java.util.List;

public class Esercizio8 {
  public static void main(String[] args) {
    List<Persona> persone = new ArrayList<>();
    persone.add(new Persona("Mario", 30));
    persone.add(new Persona("Luca", 25));
    persone.add(new Persona("Anna", 35));
    for(Persona persona : persone){
      System.out.println(persona.getNome() + " - " + persona.getEta() + " anni");
    }
  }
}
