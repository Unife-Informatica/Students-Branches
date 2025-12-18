
import java.util.*;

class Node {
    private final String name;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class OrdinamentoLista {
    public static void main(String[] args) {
        List<Node> lista = Arrays.asList(
            new Node("a"),
            new Node("c"),
            new Node("b")
        );

        List<Node> listaOrdinata = lista.stream().sorted(Comparator.comparing(Node::getName)).toList();

        for(Node n : listaOrdinata) {
            System.out.println(n.getName());
        }
    }
}
