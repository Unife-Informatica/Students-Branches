public class CompraNArticoliCompraUnoGratis extends PoliticaSconto{
    private int n;
    public double sconto;
    public CompraNArticoliCompraUnoGratis(int n){
        this.n=n;
    }
    public double calcolaSconto(int numeroArticoli,double prezzoArticolo){
        sconto=numeroArticoli/n*prezzoArticolo;
        return sconto;
    }

}