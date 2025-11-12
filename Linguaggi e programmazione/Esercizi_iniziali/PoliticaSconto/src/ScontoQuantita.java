public class ScontoQuantita extends PoliticaSconto{
    private int minimo;
    private int percentuale;
    private double sconto;
    public ScontoQuantita(int minimo, int percentuale){
        this.minimo=minimo;
        this.percentuale=percentuale;
    }
    public double calcolaSconto(int numeroArticoli,double prezzoArticolo){
        if(numeroArticoli>minimo){
            sconto = ((numeroArticoli*prezzoArticolo)*percentuale)/100;
        }
        else{
            sconto=0.0;
        }
        return sconto;
    }

}
