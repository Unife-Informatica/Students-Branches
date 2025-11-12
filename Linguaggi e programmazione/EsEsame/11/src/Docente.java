public class Docente extends Iscritto{
    private final String corsoPrincipale;

    public Docente(String nomeCognome, int codiceIscritto, String tipoIscritto, int eta,
    String corsoPrincipale, String indirizzo) {
        super(nomeCognome, codiceIscritto, tipoIscritto, eta, indirizzo);
        this.corsoPrincipale = corsoPrincipale;
    }

    public String getCorsoPrincipale() {
        return corsoPrincipale;
    }
    
    
}