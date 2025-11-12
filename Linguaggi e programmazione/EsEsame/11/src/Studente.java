public class Studente extends Iscritto{
    private final float votoMedio;

    public Studente(String nomeCognome, int codiceIscritto, String tipoIscritto, int eta, float votoMedio, String indirizzo
            ) {
        super(nomeCognome, codiceIscritto, tipoIscritto, eta, indirizzo);
        this.votoMedio = votoMedio;
    }

    public float getVotoMedio() {
        return votoMedio;
    }
    
    
    
}