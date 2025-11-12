public class Noleggio {
    private Film film;
    private String codUtente;
    private int giorniRitardo;

    public Noleggio(Film film, String codUtente, int giorniRitardo){
        this.film=film;
        this.codUtente=codUtente;
        this.giorniRitardo=giorniRitardo;
    }

    public double calcolaPenale(){
        return film.calcolaPenale(this.giorniRitardo);
    }
    @Override
    public String toString(){
        return "{Film="+film+", \n codiceUtente="+codUtente
        + ", \n giorniRitardo="+giorniRitardo+", \n PenaleDaPagare="+ calcolaPenale()+"}";
    }
}
