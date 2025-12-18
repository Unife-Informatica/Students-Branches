class Abbonato {

    private String nome, email;
    private int anniAbbonamento;

    public Abbonato(String nome, String email, int anniAbbonamento) {
        this.nome = nome;
        this.email = email;
        this.anniAbbonamento = anniAbbonamento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getAnniAbbonamento() {
        return anniAbbonamento;
    }

    public void addAnniAbbonamento() {
        addAnniAbbonamento(1);
    }

    public void addAnniAbbonamento(int n) {
        anniAbbonamento += n;
    }
}

class Piattaforma {

    List<Abbonato> listaAbbonati = new ArrayList<>();

    public Piattaforma() {}

    public Piattaforma(List<Abbonato> listaAbbonati) {
        this.listaAbbonati = listaAbbonati;
    }

    public void addAbbonato(Abbonato abbonato) {
        listaAbbonati.add(abbonato);
    }

    public double numeroMedioAnniAbbonati() {
        return listaAbbonati
            .stream()
            .mapToInt(Abbonato::getAnniAbbonamento)
            .average()
            .orElse(0.0);
    }
}
