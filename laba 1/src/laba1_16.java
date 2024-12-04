import java.util.Scanner;
public class laba1_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x: ");
        int x = scanner.nextInt();
        System.out.print("Введите y: ");
        int y = scanner.nextInt();
        if (x > 0 && y > 0) {
            System.out.print("1 четверть");
        } else if (x < 0 && y < 0) {
            System.out.print("3 четверть");
        } else if (x < 0 && y > 0) {
            System.out.print("2 четверть");
        } else if (x > 0 && y < 0) {
            System.out.print("4 четверть");
        }

    }
}
