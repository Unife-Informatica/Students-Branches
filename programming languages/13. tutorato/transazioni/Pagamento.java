public abstract class Pagamento {
    protected double importo;

    public Pagamento(double importo) {
        this.importo = importo;
    }
    
    /*
     * le funzioni definite come abstract vanno ridefinite in ogni classe
     * che estende Pagamento
     */
    public abstract boolean autentica();
    public abstract String getDettagli();

    public double getImporto() {
        return importo;
    }

    public boolean isRimborsabile() {
        return false;
    }

    public void rimborsa() {
        if (isRimborsabile()) {
            System.out.println("Rimborso effettuato di: €" + importo);
        } else {
            System.out.println("Questo metodo di pagamento non supporta il rimborso.");
        }
    }
}

