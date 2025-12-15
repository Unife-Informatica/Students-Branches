
public class Brano {

    private final String titolo;
    private final int durataSecondi;
    private final String genere;
    private final int rating;
    private final boolean isExplicit;

    public Brano(String titolo, int durataSecondi, String genere, int rating, boolean isExplicit) {
        this.titolo = titolo;
        this.durataSecondi = durataSecondi;
        this.genere = genere;
        this.rating = rating;
        this.isExplicit = isExplicit;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getDurataSecondi() {
        return durataSecondi;
    }

    public String getGenere() {
        return genere;
    }

    public int getRating() {
        return rating;
    }

    public boolean isExplicit() {
        return isExplicit;
    }

}
