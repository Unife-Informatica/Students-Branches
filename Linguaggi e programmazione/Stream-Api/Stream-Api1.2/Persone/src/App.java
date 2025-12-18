import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<Persona> persone = Arrays.asList(
            new Persona("Mario", "Rossi", 17, Arrays.asList("Lettura","Nuoto")),
            new Persona("Carlo", "Antinori",35,Arrays.asList("Lettura","Film")),
            new Persona("Flavio","Rotari",70,Arrays.asList("Sigari","Poker"))
        ); 

        //1) Solo persone maggiorenni
        System.out.println("Persone maggiorenni:");
        persone.stream().filter(n->n.getEta()>=18).forEach(System.out::println);
        System.out.println("");
        //2) Ordina l'eta' in modo crescente
        System.out.println("Eta in ordine crescente:");
        persone.stream().sorted(Comparator.comparing(Persona::getEta)).forEach(System.out::println);
        System.out.println("");
        //3) 
        Map<String,List<Persona>> personePerPassione = persone.stream().collect(Collectors.groupingBy(p->p.getPassioni().get(0)));
        //4 
        personePerPassione.forEach((passione, personeConPassione)->{
            System.out.println("Passione: "+passione);
            System.out.println("Numero persone: "+personeConPassione.size());
            personeConPassione.forEach(p->System.out.println(" "+p.getNome()+" "+p.getCognome()));
        });

        
    }
}
