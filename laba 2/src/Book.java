public class Book {

    String name;
    double price;
    boolean illustration;

    public Book(String name, double price, boolean illustration) {
        this.name = name;
        this.price = price;
        this.illustration = illustration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIllustration() {
        return illustration;
    }

    public void setIllustration(boolean illustration) {
        this.illustration = illustration;
    }
}
