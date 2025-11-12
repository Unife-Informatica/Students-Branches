public abstract class Evento{
    protected String nomeEvento,tipoEvento,strutOspit,data;
    protected int codEvento,posti;
    protected float prezzo;
    public Evento(String nomeEvento, int codEvento,String tipoEvento,int posti,String strutOspit,String data, float prezzo){
        this.nomeEvento=nomeEvento;
        this.codEvento=codEvento;
        this.tipoEvento=tipoEvento;
        this.posti = posti;
        this.strutOspit=strutOspit;
        this.data=data;
        this.prezzo=prezzo;
    }
    public String getNomeEvento() {
        return nomeEvento;
    }
    public String getTipoEvento() {
        return tipoEvento;
    }
    public String getStrutOspit() {
        return strutOspit;
    }
    public String getData() {
        return data;
    }
    public int getCodEvento() {
        return codEvento;
    }
    public int getPosti() {
        return posti;
    }
    public float getPrezzo() {
        return prezzo;
    }
    
}