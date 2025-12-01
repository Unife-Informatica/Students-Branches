import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        String array[] = {"Mela", "Pera", "Arancia", "Fragola", "Kiwi", "Arancia"};
        Arrays.stream(array).sorted().distinct().forEach(s->System.out.println(s));
    }
}
