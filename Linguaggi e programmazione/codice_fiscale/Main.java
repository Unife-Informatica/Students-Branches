package LP.codice_fiscale;

public class Main {
    public static void main(String[] args) {
        CalcoloCf cf = new CalcoloCf();
        String prova = cf.calcoloCognome();
        System.out.println(prova);
    }
}
