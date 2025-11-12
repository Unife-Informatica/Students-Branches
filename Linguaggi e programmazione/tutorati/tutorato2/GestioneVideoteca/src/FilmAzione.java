public class FilmAzione extends Film {
    public FilmAzione(String codUniv, String titolo){
        super(codUniv, titolo);
        this.penale = 3;
    }
    @Override
    public double calcolaPenale(int giorniRitardo){
        if(giorniRitardo>3){
            return 3*this.penale + (giorniRitardo-3)*4;
        }
        return giorniRitardo*this.penale;
    }
}
