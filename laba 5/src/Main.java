import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+", 3); // Limit to 3 parts
                if (parts.length != 3) {
                    System.out.println("Invalid input format. Expected: <flag> <symbol> <text>");
                    continue;
                }

                int flag = Integer.parseInt(parts[0]);
                char symbol = parts[1].charAt(0);
                String text = parts[2];

                String result = processString(flag, symbol, text);
                System.out.println(result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid flag format.  Must be an integer (0 or 1).");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Invalid symbol format. Must provide a single character.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String processString(int flag, char symbol, String text) {
        if (flag == 0) {
            return text.replace(String.valueOf(symbol), "");
        } else if (flag == 1) {
            int k = 5;
            if (text.length() < k) {
                return text + symbol;
            } else {
                return text.substring(0, k) + symbol + text.substring(k);
            }
        } else {
            return "Invalid flag (must be 0 or 1)";
        }
    }
}