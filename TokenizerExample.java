import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenizerExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number of lines of Program:");
        int numLines = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= numLines; i++) {
            System.out.println("Enter String#" + i + ":");
            String input = scanner.nextLine();
            System.out.println("Output =");
            tokenizeString(input);
        }

        scanner.close();
    }

    private static void tokenizeString(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, "+-*/", true);
        int tokenCount = 0;

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty()) {
                tokenCount++;
                if (isOperator(token)) {
                    System.out.println("TOKEN#" + tokenCount + " " + token + " operator");
                } else {
                    System.out.println("TOKEN#" + tokenCount + " " + token + " Identifier");
                }
            }
        }
        System.out.println("TOTAL NUMBER OF TOKENS FOR STRING#" + input + ":" + tokenCount);
        System.out.println("END OF STRING#" + input);
        System.out.println();
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }
}
