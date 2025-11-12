public class Partita extends Evento {
    private String sport;

    public Partita(String nomeEvento, int codEvento, String tipoEvento, int posti, String strutOspit, String data,
            float prezzo, String sport) {
        super(nomeEvento, codEvento, tipoEvento, posti, strutOspit, data, prezzo);
        this.sport = sport;
    }

    public String getSport() {
        return sport;
    }
    
}
