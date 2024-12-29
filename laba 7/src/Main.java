import com.example.exceptions.BookNotFoundException;
import com.example.exceptions.DataAccessException;
import com.example.exceptions.InvalidPriceException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:");
        System.out.println("1. Запись книг в файл");
        System.out.println("2. Чтение книг из файла");

        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Неверный формат выбора.");
            return;
        }
        scanner.nextLine();
        try {
            switch (choice) {
                case 1:
                    writeBooksToFile(scanner);
                    break;
                case 2:
                    readBooksFromFile();
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        } catch (Exception e){
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
        finally {
            scanner.close();
        }
    }

    static void writeBooksToFile(Scanner scanner) throws DataAccessException {
        List<Book> books = new ArrayList<>();
        while (true) {
            System.out.println("Введите название книги (или 'стоп' для завершения):");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("стоп")) {
                break;
            }

            double price = 0;
            boolean priceValid = false;

            while (!priceValid) {
                try {
                    System.out.println("Введите цену книги:");
                    price = scanner.nextDouble();
                    if (price <= 0) {
                        throw new InvalidPriceException("Цена должна быть положительной.");
                    }
                    priceValid = true;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Некорректный ввод цены. Попробуйте ещё раз.");
                    scanner.next();
                } catch (InvalidPriceException e) {
                    System.out.println(e.getMessage());
                }
                scanner.nextLine();
            }


            System.out.println("Есть ли иллюстрации (да/нет)?");
            boolean hasIllustrations = scanner.nextLine().equalsIgnoreCase("да");

            books.add(new Book(title, price, hasIllustrations));
        }

        try {
            saveBooksToFile(books, "books.dat");
        }
        catch (DataAccessException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
            throw e;
        }
    }



    static void readBooksFromFile()  {
        List<Book> loadedBooks = null;
        try {
            loadedBooks = loadBooksFromFile("books.dat");
        } catch (DataAccessException e) {
            System.err.println("Ошибка чтения из файла: " + e.getMessage());
            return;
        }

        if (loadedBooks == null) {
            System.out.println("Ошибка при загрузке данных из файла.");
            return;
        }

        if (loadedBooks.isEmpty()) {
            System.out.println("Файл books.dat пуст.");
            return;
        }


        double totalPrice = 0;
        int illustratedBookCount = 0;

        try {

            for (Book book : loadedBooks) {
                totalPrice =  calculatePrice(totalPrice, book.price);
                if (book.hasIllustrations) {
                    illustratedBookCount++;
                }
            }
        }catch (ArithmeticException e){
            System.err.println("Ошибка при расчете стоимости: " + e.getMessage());
            return;
        } catch (OutOfMemoryError e) {
            System.err.println("Недостаточно памяти при расчете стоимости" + e.getMessage());
            return;
        }


        System.out.println("\nОбщая стоимость книг: " + totalPrice);
        System.out.println("Количество книг с иллюстрациями: " + illustratedBookCount);

        System.out.println("\nСписок книг:");
        for (Book book : loadedBooks) {
            System.out.println(book);
        }

    }

    private static double calculatePrice(double currentPrice, double bookPrice) throws ArithmeticException{
        if(Double.MAX_VALUE - currentPrice < bookPrice)
            throw new ArithmeticException("Переполнение при подсчете стоимости книг.");
        return currentPrice + bookPrice;

    }

    public static void saveBooksToFile(List<Book> books, String filename) throws DataAccessException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(books);
            System.out.println("Данные успешно сохранены в файл " + filename);
        } catch (IOException e) {
            throw new DataAccessException("Ошибка при записи в файл: ", e);
        }
    }

    public static List<Book> loadBooksFromFile(String filename) throws DataAccessException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new DataAccessException("Ошибка при чтении из файла.", e);
        }
    }

}