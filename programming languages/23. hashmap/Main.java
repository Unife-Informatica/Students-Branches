
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> mappa = new HashMap<>();

        mappa.put("chiave", 1);
        mappa.put("chiave-2", 2);
        mappa.put("chiave-3", 3);

        mappa.remove("chiave-2");

        for(Integer v : mappa.values()) {
            System.out.println(v);
        }

        for(String s : mappa.keySet()) {
            System.out.println(s);
        }
    }
}