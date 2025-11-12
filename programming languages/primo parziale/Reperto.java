public class Reperto {
    private final int codice, anno, peso;
    private final String tipo, descrizione, ritrovamento, collocazione;

    public Reperto(int codice, int anno, String collocazione, int peso, String tipo, String descrizione,
            String ritrovamento) {
        this.codice = codice;
        this.anno = anno;
        this.collocazione = collocazione;
        this.peso = peso;
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.ritrovamento = ritrovamento;
    }

    public int getCodice() {
        return codice;
    }

    public int getAnno() {
        return anno;
    }

    public String getCollocazione() {
        return collocazione;
    }

    public int getPeso() {
        return peso;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getRitrovamento() {
        return ritrovamento;
    }

    @Override
    public String toString() {
        return getTipo() + "\t" + getCodice() + "\t" + getDescrizione() + "\t" + getAnno() + "\t" + getCollocazione() + "\t" + getPeso() + "\t" + getRitrovamento() + "\t";
    }

}
