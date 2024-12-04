import java.util.Scanner;

public class laba1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кол-во чисел Фибоначчи для вычисления: ");
        int n = scanner.nextInt();
        int first = 1;
        int second = 1;
        System.out.print("Результат: " + first + " " + second + " ");

        for (int i = 3; i <= n; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
    }
}