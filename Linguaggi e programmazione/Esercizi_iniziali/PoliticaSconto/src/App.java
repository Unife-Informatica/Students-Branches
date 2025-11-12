public class App {
    public static void main(String[] args) throws Exception {
        double sconto1;
        double sconto2;
        ScontoQuantita sq = new ScontoQuantita(10,12);
        sconto1=sq.calcolaSconto(12, 23.3);
        System.out.println("Lo sconto della politica percentuale: "+sconto1+"$");
        CompraNArticoliCompraUnoGratis cnacq = new CompraNArticoliCompraUnoGratis(3);
        sconto2 = cnacq.calcolaSconto(3,10);
        System.out.println("Lo sconto della politica di compra N articoli e prendi uno"
        + "gratis e' di: "+sconto2+"$");

    }
}
