import java.util.*;

public class Media {

    public static void main(String[] args) {
        List<Double> valori = Arrays.asList(10.5, 20.0, 30.5, 40.0);

        double media = valori.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0); // valore di default se la lista è vuota

        System.out.println("La media è: " + media);
    }
}

