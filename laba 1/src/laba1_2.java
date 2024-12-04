import java.util.Scanner;

public class laba1_2 {
    public static void main(String[] args) {
        Scanner inputFromLine = new Scanner(System.in);
        System.out.println("Введите текст");
        String textFromLine = inputFromLine.nextLine();
        String reversedText = new StringBuilder(textFromLine).reverse().toString();
        System.out.println(reversedText);
    }
}
