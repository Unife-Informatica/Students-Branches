import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Nigga!");
        List<Node> node=Arrays.asList(new Node("Gianni"),new Node("Arturo"),new Node("Massimo"),new Node("Thomas!"));

        Collections.sort(node,(a,b)->a.getName().compareTo(b.getName()));
        System.out.println(node);
    }
}
