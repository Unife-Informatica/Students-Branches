public class CartaBrano{
    private String codice;
    private int braniDisponibili;
    private boolean attiva;

    public CartaBrano(String codice, int braniDisponibili, boolean attiva){
        this.codice=codice;
        this.braniDisponibili=braniDisponibili;
        this.attiva=attiva;
    }
    public String getCodice(){
        return codice;
    }
    public int getBraniDisponibili(){
        return braniDisponibili;
    }
    public boolean getAttiva(){
        return attiva;
    }
    public void attiva()throws CartaGiaAttivaException{
        if(attiva){
            throw new CartaGiaAttivaException("La carta"
            +codice+"e' gia' attiva.");
        }
        attiva=true;
    }
    public void compraBrano() throws CartaNonAttivaException,CartaEsauritaException{
        if(!attiva){
            throw new CartaNonAttivaException("La carta non e' attiva");
        }
        if(braniDisponibili<=0){
            throw new CartaEsauritaException("Non ci sono piu' brani disponibili sulla carta.");
        }
        braniDisponibili--;
    }
    public void ricaricaBrano() throws CartaNonAttivaException{
        if(!attiva){
            throw new CartaNonAttivaException("La carte non e' attiva");
        }
        braniDisponibili++;
    }
}