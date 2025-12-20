public class Song {
  private String title;
  private String artist;
  private String genre;
  private int duration;   // in secondi
  private int year;
  private int streams;    // numero di ascolti

  public Song(String title, String artist, String genre,
              int duration, int year, int streams) {
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.duration = duration;
    this.year = year;
    this.streams = streams;
  }

  public String getTitle() { return title; }
  public String getArtist() { return artist; }
  public String getGenre() { return genre; }
  public int getDuration() { return duration; }
  public int getYear() { return year; }
  public int getStreams() { return streams; }

  @Override
  public String toString() {
    return String.format(
      "%s - %s (%s, %d) [%d sec, %d streams]",
      title, artist, genre, year, duration, streams
    );
  }
}
