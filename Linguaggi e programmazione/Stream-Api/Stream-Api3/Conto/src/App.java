import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Conto> conti = new ArrayList<>();
        conti.add(new Conto(100));
        conti.add(new Conto(10));
        conti.add(new Conto(50));
        conti.add(new Conto(200));
        conti.add(new Conto(250));
        List<Conto> contiSaldoMaggiore50 =
        ContoDemo.selezionaContiSaldoMaggioreDi(conti, 50);

        System.out.println(contiSaldoMaggiore50);
        System.out.println(ContoDemo.verificaSaldoMaggioreDi(conti, 9));
    }
}
