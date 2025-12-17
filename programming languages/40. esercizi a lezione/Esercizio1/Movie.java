public class Movie {

    private final String title;
    private final String director;
    private final String genre;
    private final int year;
    private final int duration;

    public Movie(String title, String director, String genre, int year, int duration) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s - %s - %d", title, year, director, genre, duration);
    }
}
