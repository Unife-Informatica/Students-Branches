public class Concerto extends Evento {
    private int durata;

    public Concerto(String nomeEvento, int codEvento, String tipoEvento, int posti, String strutOspit, String data,
            float prezzo, int durata) {
        super(nomeEvento, codEvento, tipoEvento, posti, strutOspit, data, prezzo);
        this.durata = durata;
    }

    public int getDurata() {
        return durata;
    }
    
}
