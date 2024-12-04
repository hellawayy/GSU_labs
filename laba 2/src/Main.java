import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Bragin",52.00, false);
        Book book2 = new Book("Funtik na lune",23.15, true);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        System.out.println(price(books));
        System.out.println(illustrations(books));
    }

    public static double price(ArrayList<Book> books) {
        double a=0;
        for (Book book : books) {
            a += book.getPrice();
        }

        return a;
    }

    public static int illustrations(ArrayList<Book> books) {
        int a=0;
        for (Book book: books){
            if(book.isIllustration()) {
                a += 1;
            }
        }
        return a;
    }
}
