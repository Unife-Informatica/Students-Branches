public class FilmCommedia extends Film {
    public FilmCommedia(String codUniv,String titolo){
        super(codUniv,titolo);
        this.penale=2.5;
    }
    @Override
    public double calcolaPenale(int giorniRitardo){
        if(giorniRitardo==1){
            return this.penale/2;
        }
        return this.penale*giorniRitardo;
    }
    
}
