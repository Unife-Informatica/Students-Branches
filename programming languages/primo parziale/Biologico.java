public class Biologico extends Reperto {
    private final char fossile;
    private final String specie;

    public Biologico(int codice, int anno, String collocazione, int peso, String tipo, String descrizione,
            String ritrovamento, char fossile, String specie) {
        super(codice, anno, collocazione, peso, tipo, descrizione, ritrovamento);
        this.fossile = fossile;
        this.specie = specie;
    }

    public char getFossile() {
        return fossile;
    }

    public String getSpecie() {
        return specie;
    }

    @Override
    public String toString() {
        return super.toString() + "\t-\t" + getFossile() + "\t" + getSpecie();
    }

}
