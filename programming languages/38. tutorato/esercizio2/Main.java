public class Main {
  public static void main() {
    List<Book> listaLibri = new ArrayList<>();

    System.out.println("Pubblicato dopo il 2010: " + listaLibri.stream().filter(l -> l.getPubblicazione() > 2010).toList());

    System.out.println("Ordine crescente di prezzo: " + listaLibri.stream().sorted(Comparator.comparing(Prodotto::getPrezzo)).toList());

    System.out.println("Libri scritti da \"JK Rowling\"" + listaLibri.stream().filter(l -> "JK Rowling".equalsIgnoreCase(l.getAutore())).toList());

    System.out.println("Libri per anno di pubblicazione descrescente: " + listaLibri.stream()
     .sorted(Comparator.comparingInt(Book::getPubblicazione).reversed())
     .forEach(System.out::println);
    );

    List<String> uniqueTags = books.stream()
        .map(Book::getTags)          // Stream<List<String>>
        .filter(Objects::nonNull)    // evita NullPointerException
        .flatMap(List::stream)       // Stream<String>
        .distinct()                  // rimuove duplicati
        .toList();                   // Java 16+

  }
}
