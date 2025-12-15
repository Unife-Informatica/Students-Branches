
import java.util.List;

public class Artista {

    private final String nome;
    private final List<Album> listaAlbum;

    public Artista(String nome, List<Album> listaAlbum) {
        this.nome = nome;
        this.listaAlbum = listaAlbum;
    }

    public String getNome() {
        return nome;
    }

    public List<Album> getListaAlbum() {
        return listaAlbum;
    }

}
