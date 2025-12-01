import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<Spesa> spese = new ArrayList<>();
        spese.add(new Spesa(10.00, "vitto"));
        spese.add(new Spesa(15.50, "cinema"));
        spese.add(new Spesa(300.00, "alloggio"));
        spese.add(new Spesa(32.70, "vitto"));
        spese.add(new Spesa(52.10, "vitto"));

        //metodo con stream
        Map<String,List<Spesa>> mappa2 = spese.stream().collect(Collectors.groupingBy(s->s.getTipologia()));
        System.out.println(mappa2.keySet());
        System.out.println(mappa2.get("vitto"));
        System.out.println(mappa2.get("cinema"));
        System.out.println(mappa2.get("alloggio"));

        //metodo senza stream
        Map<String, List<Spesa>> mappa = new HashMap<>();
        for(Spesa s:spese){
            String tipologia = s.getTipologia();
            if(mappa.containsKey(tipologia)){
                mappa.get(tipologia).add(s);
            }else{
                List<Spesa> nuoveSpese = new ArrayList<>();
                nuoveSpese.add(s);
                mappa.put(tipologia, nuoveSpese);
            }
        }
        System.out.println(mappa.keySet());
        System.out.println(mappa.get("vitto"));
        System.out.println(mappa.get("cinema"));
        System.out.println(mappa.get("alloggio"));



    }
}
