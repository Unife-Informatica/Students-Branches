import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Spesa> spese = new ArrayList<Spesa>();
    spese.add(new Spesa(10.00, "vitto"));
    spese.add(new Spesa(15.50, "cinema"));
    spese.add(new Spesa(300.00, "alloggio"));
    spese.add(new Spesa(32.70, "vitto"));
    spese.add(new Spesa(52.10, "vitto"));

    Map<String, List<Spesa>> mappa2 = spese.stream().collect(Collectors.groupingBy(spesa -> spesa.getTipologia()));
    System.out.println(mappa2.keySet());
    System.out.println(mappa2.get("vitto"));
    System.out.println(mappa2.get("cinema"));
    System.out.println(mappa2.get("alloggio"));

    Map<String, List<Spesa>> mappa = new HashMap<String,List<Spesa>>();
    for(Spesa spesa : spese){
      String tipologia = spesa.getTipologia();
      if(mappa.containsKey(tipologia)){
        mappa.get(tipologia).add(spesa);
      }else{
        List<Spesa> nuoveSpese = new ArrayList<>();
        nuoveSpese.add(spesa);
        mappa.put(tipologia, nuoveSpese);
      }
    }
    System.out.println(mappa.keySet());
    System.out.println(mappa.get("vitto"));
    System.out.println(mappa.get("cinema"));
    System.out.println(mappa.get("alloggio"));
  }
}
