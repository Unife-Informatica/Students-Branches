public class Casa extends Partita {
    String palazzetto;
    public Casa(char tipoPartita,String data, String orario, String punteggi,int vittoria,String palazzetto){
        super(tipoPartita, data, orario, punteggi, vittoria);
        this.palazzetto=palazzetto;
    }    
    public String getPalazzetto(){
        return palazzetto;
    }
}
