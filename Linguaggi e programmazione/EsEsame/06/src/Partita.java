public abstract class Partita {
    protected char tipoPartita;
    protected String data,orario,punteggi;
    protected int vittoria;
    public Partita(char tipoPartita,String data, String orario, String punteggi,int vittoria){
        this.tipoPartita=tipoPartita;
        this.data=data;
        this.orario=orario;
        this.punteggi=punteggi;
        this.vittoria=vittoria;
    }
    public char getTipoPartita(){
        return tipoPartita;
    }
    public String getData(){
        return data;
    }
    public String getOrario(){
        return orario;
    }
    public String getPunteggi(){
        return punteggi;
    }
    public int getVittoria(){
        return vittoria;
    }
}
