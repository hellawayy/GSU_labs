import java.io.Serializable;

public class Book implements Serializable {
    public String title;
    public double price;
    public boolean hasIllustrations;

    public Book(String title, double price, boolean hasIllustrations) {
        this.title = title;
        this.price = price;
        this.hasIllustrations = hasIllustrations;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", hasIllustrations=" + hasIllustrations +
                '}';
    }
}