import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Node> list = Arrays.asList(new Node("c"), new Node("b"), new Node("d"), new Node("a"));
        
        Collections.sort(list, (a,b)->a.getName().compareTo(b.getName()));
        System.out.println(list);
    }
}
