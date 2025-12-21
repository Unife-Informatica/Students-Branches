public class Match {
  private String homeTeam;
  private String awayTeam;
  private int homeScore;
  private int awayScore;
  private String sport;       // es. "Basket", "Calcio", "Tennis"
  private int year;

  public Match(String homeTeam, String awayTeam, int homeScore, int awayScore, String sport, int year) {
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.homeScore = homeScore;
    this.awayScore = awayScore;
    this.sport = sport;
    this.year = year;
  }

  public String getHomeTeam() { return homeTeam; }
  public String getAwayTeam() { return awayTeam; }
  public int getHomeScore() { return homeScore; }
  public int getAwayScore() { return awayScore; }
  public String getSport() { return sport; }
  public int getYear() { return year; }
  public boolean isDraw() { return homeScore == awayScore; }

  @Override
  public String toString() {
    return String.format(
      "%s %d - %d %s (%s, %d)",
      homeTeam, homeScore, awayScore, awayTeam, sport, year
    );
  }
}
