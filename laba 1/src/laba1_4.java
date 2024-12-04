import java.util.Scanner;

public class laba1_4 {
    static int calculateFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для вычисления факториала: ");
        int n = scanner.nextInt();
        System.out.println("Результат" + calculateFactorial(n));
    }
}
