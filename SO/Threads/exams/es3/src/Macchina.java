public class Macchina { //Struttura dati condivisa
    private int macchinaId;//Impostare e ottenere id della macchina
    private int pezziProdotti;//Impostare e ottenere prezzi prodotti dalla macchina
    public synchronized void setMacchinaId(int macchinaId){
        this.macchinaId=macchinaId;
    }
    public synchronized int getMacchinaId(){
        return macchinaId;
    }

    public synchronized void setPezziProdotti(int pezziProdotti){
        this.pezziProdotti=pezziProdotti;
    }
    public synchronized int getPezziProdotti(){
        return pezziProdotti;
    }
}
