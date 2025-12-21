public class Product {
  private String name;
  private String category;  // es. "Alimentari", "Elettronica", "Abbigliamento"
  private double price;
  private int stock;        // quantità disponibile

  public Product(String name, String category, double price, int stock) {
    this.name = name;
    this.category = category;
    this.price = price;
    this.stock = stock;
  }

  public String getName() { return name; }
  public String getCategory() { return category; }
  public double getPrice() { return price; }
  public int getStock() { return stock; }

  @Override
  public String toString() {
    return String.format("%s (%s) - €%.2f - stock: %d", name, category, price, stock);
  }
}

