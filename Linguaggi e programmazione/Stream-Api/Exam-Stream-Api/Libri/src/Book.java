public class Book {
    private String title;
    private String author;
    private String genre;
    private double price;
    private int pages;
    private int year;

    public Book

    (String title, String author, String genre, double price, int pages, int year) {
        this.title = title;

        this.author = author;

        this.genre = genre;

        this.price = price;
        this.pages = pages;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", genre=" + genre + ", price=" + price + ", pages="
                + pages + ", year=" + year + "]";
    }

}