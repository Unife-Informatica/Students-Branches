public class App {    
    public static void main(String[] args) {
        MetodoPagamento pagamentoPayPal = new PayPal(10, "pippo%edu.unife.it", "plutoPaperino");
        MetodoPagamento pagamentoBonifico = new BonificoBancario(50.17, "IT123456", 3042);
        MetodoPagamento pagamentoCC = new CartaCredito(35.13, "48573", 435, "Topolino");

        Ordine[] ordini = new Ordine[3];
        ordini[0] = new Ordine(0, "Lavatrice", pagamentoPayPal);
        ordini[1] = new Ordine(1, "Sedia", pagamentoBonifico);
        ordini[2] = new Ordine(2, "Macchina", pagamentoCC);

        for (Ordine ordini1 : ordini) {
            ordini1.exeOrdine();
        }
    }
    
}
