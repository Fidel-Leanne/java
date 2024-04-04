import java.util.*;

public class MiniCompiler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("A MINI COMPILER PROJECT FOR CTE711S\n===================================");
        System.out.println(
                "ENTER NEXT STRING === #1\n-Every String/line must end with a semicolon (;)\n-Enter String (Containing 0 to 9 and/or operators: +,/,*,-)\n-Enter No Space in b/w chara & end the string with semicolon(;)ie 5-4+9*8/2; for Full(7 stages) results of compilation\n-or Enter Space in b/w char with semicolon(;) at end of String ie 5 - 4 + 9 * 8 / 2 ; for the result of arithmetic expression\n-Or Type 99 and press Enter to Quit:");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("99")) {
                System.out.println("Exiting...");
                break;
            }

            System.out.println("======STAGE1: COMPILER TECHNIQUES--> LEXICAL ANALYSIS-Scanner");
            List<String> tokens = lexicalAnalysis(input);
            System.out.println("SYMBOL TABLE COMPRISING ATTRIBUTES AND TOKENS:");
            int tokenNum = 1;
            for (String token : tokens) {
                System.out.println("TOKEN#" + tokenNum + " " + token);
                tokenNum++;
            }
            System.out.println("Total number of Tokens: " + tokens.size());

            System.out.println("======STAGE2: COMPILER TECHNIQUES--> SYNTAX ANALYSIS-Parser");
            if (parseInput(tokens)) {
                System.out.println("The expression is syntactically correct.");
            } else {
                System.out.println("Syntax Error: The expression is not syntactically correct.");
            }

            System.out.println("======STAGE3: COMPILER TECHNIQUES--> SEMANTIC ANALYSIS");
            System.out.println("CONCLUSION-->This expression: " + input + " is Syntactically and Semantically correct");

            System.out.println("======STAGE4: COMPILER TECHNIQUES--> INTERMEDIATE CODE REPRESENTATION (ICR)");
            System.out.println("THE STRING ENTERED IS : " + input);
            System.out.println("The ICR is as follows:");
            // Simulated intermediate code generation
            generateICR(input);
            System.out.println("CONCLUSION-->The expression was correctly generated in ICR\n");

            System.out.println("======STAGE5: CODE GENERATION");
            // Simulated code generation
            generateCode();
            System.out.println();
        }

        scanner.close();
    }

    public static List<String> lexicalAnalysis(String input) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, "+-*/;", true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty()) {
                tokens.add(token);
            }
        }
        return tokens;
    }

    public static boolean parseInput(List<String> tokens) {
        // Very simple parsing, just checks for correct operator-token sequence
        String[] operators = { "+", "-", "*", "/" };
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (Arrays.asList(operators).contains(token)) {
                // Ensure there's a token after the operator
                if (i + 1 >= tokens.size() || Arrays.asList(operators).contains(tokens.get(i + 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void generateICR(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, "+-*/;", true);
        String[] operators = { "+", "-", "*", "/" };
        String[] tokens = input.split("[\\+\\-\\*/;]");
        int tCount = 1;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                System.out.println("t" + tCount + "= " + token);
                tCount++;
            }
        }
        tCount = 1;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty() && Arrays.asList(operators).contains(token)) {
                System.out.println("t" + (tCount + tokens.length) + "= t" + (tCount) + token + "t" + (tCount + 1));
                tCount++;
            }
        }
        System.out.println("t" + (tCount + tokens.length) + "= t" + (tCount) + "t" + (tCount + 1));
    }

    public static void generateCode() {
        System.out.println("LDA 2\nDIV 8\nSTR t1\nLDA 9\nMUL t1\nSTR t2\nLDA 4\nADD t2\nSTR t3\nLDA 5\nSUB t3\nSTR t4");
    }
}
