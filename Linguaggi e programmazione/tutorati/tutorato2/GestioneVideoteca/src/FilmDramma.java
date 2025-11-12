public class FilmDramma extends Film {
    public FilmDramma(String codUniv, String titolo){
        super(codUniv, titolo);
        this.penale=2;
    }
    @Override
    public double calcolaPenale(int giorniRitardo){
        return this.penale*giorniRitardo;
    }
}
