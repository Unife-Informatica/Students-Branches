
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Artisti {

    private final List<Artista> listaArtisti = new ArrayList<>();

    public Artisti(boolean generaArtisti) {
        if (generaArtisti) {
            this.generaArtisti();
        }
    }

    public void generaArtisti() {

    }

    public int conteggioGenere(String genere) {
        return (int) listaArtisti.stream()
                .flatMap(artista -> artista.getListaAlbum().stream())
                .flatMap(album -> album.getListaBrani().stream())
                .filter(brano -> genere.equalsIgnoreCase(brano.getGenere()))
                .count();
    }

    public List<Brano> top(int limit) {
        return listaArtisti.stream()
                .flatMap(artista -> artista.getListaAlbum().stream())
                .flatMap(album -> album.getListaBrani().stream())
                .sorted(Comparator.comparingInt(Brano::getRating)
                        .thenComparing(Brano::getTitolo))
                .limit(limit)
                .toList();
    }

    public boolean familyFriendlyCheck() {
        return listaArtisti.stream()
                .flatMap(artista -> artista.getListaAlbum().stream())
                .flatMap(album -> album.getListaBrani().stream())
                .noneMatch(Brano::isExplicit); // true se nessun brano è esplicito
    }

    public String artistaProlisso() {
        return listaArtisti.stream()
                .max(Comparator.comparingInt(
                        artista -> artista.getListaAlbum().stream()
                                .flatMap(album -> album.getListaBrani().stream())
                                .mapToInt(Brano::getDurataSecondi)
                                .sum()
                ))
                .map(Artista::getNome) // restituisce il nome dell'artista
                .orElse("");            // valore di default se listaArtisti è vuota
    }

    public Map<String, Integer> calcolaDurataPost(int offset) {
        return listaArtisti.stream()
                .collect(Collectors.toMap(
                        Artista::getNome,
                        artista -> artista.getListaAlbum().stream()
                                .filter(album -> album.getAnnoUscita() >= offset)
                                .flatMap(album -> album.getListaBrani().stream())
                                .mapToInt(Brano::getDurataSecondi)
                                .sum()
                ));
    }

    public Map<String, String> calcolaGenerePrincipale() {
        return listaArtisti.stream()
                .collect(Collectors.toMap(
                        Artista::getNome,
                        artista -> artista.getListaAlbum().stream()
                                .flatMap(album -> album.getListaBrani().stream())
                                .collect(Collectors.groupingBy(
                                        Brano::getGenere,
                                        Collectors.counting()
                                ))
                                .entrySet().stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse("Unknown")
                ));
    }

    public List<Artista> getListaArtisti() {
        return listaArtisti;
    }

}
