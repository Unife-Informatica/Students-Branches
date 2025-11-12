public class Noleggio {
    private String codCustomer;
    private Film film;
    private int giorniRitardo;
    public Noleggio(String codCustomer,Film film, int giorniRitardo){
        this.codCustomer=codCustomer;
        this.film=film;
        this.giorniRitardo=giorniRitardo;
    }
    public double calcolaPenale(){
        return film.calcolaPenale(this.giorniRitardo);
    }
    @Override
    public String toString(){
        return "{Film:["+film+"]"+",\ncodiceUtente:"+codCustomer+",\ngiorniRitardo:"+giorniRitardo+",\nPenaleDaPagare:"+calcolaPenale()+"}";
    }
}
