public class FuoriCasa extends Partita {
    String cittaOspitante;
    public FuoriCasa(char tipoPartita,String data, String orario, String punteggi,int  vittoria,String cittaOspitante){
        super(tipoPartita, data, orario, punteggi, vittoria);
        this.cittaOspitante=cittaOspitante;
    }    
    public String getCittaOspitante(){
        return cittaOspitante;
    }
}
