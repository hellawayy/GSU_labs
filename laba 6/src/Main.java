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

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

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
        scanner.close();
    }

    public static void saveBooksToFile(List<Book> books, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(books);
            System.out.println("Данные успешно сохранены в файл " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    static void writeBooksToFile(Scanner scanner) {
        List<Book> books = new ArrayList<>();

        // Ввод книг пользователем
        while (true) {
            System.out.println("Введите название книги (или 'стоп' для завершения):");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("стоп")) {
                break;
            }

            System.out.println("Введите цену книги:");
            double price = 0;
            try {
                price = scanner.nextDouble();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Некорректный ввод цены. Попробуйте ещё раз.");
                scanner.next();
                continue;
            }
            scanner.nextLine();

            System.out.println("Есть ли иллюстрации (да/нет)?");
            boolean hasIllustrations = scanner.nextLine().equalsIgnoreCase("да");

            books.add(new Book(title, price, hasIllustrations));
        }

        saveBooksToFile(books, "books.dat");
    }

    static void readBooksFromFile() {
        List<Book> loadedBooks = loadBooksFromFile("books.dat");
        double totalPrice = 0;
        int illustratedBookCount = 0;

        if (loadedBooks == null) { //Проверка на ошибку чтения
            System.out.println("Ошибка при загрузке данных из файла.");
            return; //Выход из метода, если возникла ошибка
        }

        if(loadedBooks.isEmpty()){ // Проверка на пустой файл
            System.out.println("Файл books.dat пуст.");
            return;
        }


        for (Book book : loadedBooks) {
            totalPrice += book.price;
            if (book.hasIllustrations) {
                illustratedBookCount++;
            }
        }

        System.out.println("\nОбщая стоимость книг: " + totalPrice);
        System.out.println("Количество книг с иллюстрациями: " + illustratedBookCount);

        System.out.println("\nСписок книг:");
        for (Book book : loadedBooks) {
            System.out.println(book);
        }
    }


    public static List<Book> loadBooksFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при чтении из файла: " + e.getMessage());
            return null;
        }
    }
}