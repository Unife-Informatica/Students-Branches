public class Campo {
    private final int codice;
    private final String nome;

    public Campo(int codice, String nome) {
        this.codice = codice;
        this.nome = nome;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }
}
