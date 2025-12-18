import java.util.List;

class Persona{
    private String nome, cognome;
    int eta;
    private List<String> passioni;
    public Persona(String nome, String cognome, int eta, List<String> passioni) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.passioni = passioni;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public int getEta() {
        return eta;
    }
    public List<String> getPassioni() {
        return passioni;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("nome=").append(nome);
        sb.append(", cognome=").append(cognome);
        sb.append(", eta=").append(eta);
        sb.append(", passioni=").append(passioni);
        sb.append('}');
        return sb.toString();
    }

}