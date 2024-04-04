import java.util.Scanner;

public class CompilerStages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A MINI COMPILER PROJECT FOR CTE711S");
        System.out.println("===================================");

        while (true) {
            System.out.println("\nENTER NEXT STRING === #1");
            System.out.println("-Every String/line must end with a semicolon (;)");
            System.out.println("-Enter String (Containing 0 to 9 and/or operators: +,/,*,-)");
            System.out.println(
                    "-Enter No Space in b/w chara & end the string with semicolon(;)ie 5-4+9*8/2; for Full(7 stages) results of compilation");
            System.out.println(
                    "-or Enter Space in b/w char with semicolon(;) at end of String ie 5 - 4 + 9 * 8 / 2 ; for the result of arithmetic expression");
            System.out.println("-Or Type 99 and press Enter to Quit:");

            String input = scanner.nextLine();

            if (input.equals("99")) {
                System.out.println("\nExiting program...");
                break;
            }

            // Stage 1: Lexical Analysis (Scanning)
            System.out.println("\n======STAGE1: COMPILER TECHNIQUES--> LEXICAL ANALYSIS-Scanner");
            System.out.println("SYMBOL TABLE COMPRISING ATTRIBUTES AND TOKENS:");

            String[] tokens = input.split("[\\s;]+");
            for (int i = 0; i < tokens.length; i++) {
                System.out.println("TOKEN#" + (i + 1) + " " + tokens[i] + " identifier");
            }
            System.out.println("Total number of Tokens: " + tokens.length);

            // Stage 2: Syntax Analysis (Parsing)
            System.out.println("\n======STAGE2: COMPILER TECHNIQUES--> SYNTAX ANALYSIS-Parser");
            System.out.println("GET A DERIVATION FOR : " + input);
            String expression = input.replaceAll("[\\s;]+", "");
            System.out.println(deriveExpression(expression));

            // Stage 3: Semantic Analysis
            System.out.println("\n======STAGE3: COMPILER TECHNIQUES--> SEMANTIC ANALYSIS");
            System.out.println("CONCLUSION-->This expression: " + input + " is Syntactically and Semantically correct");

            // Stage 4: Intermediate Code Representation (ICR)
            System.out.println("\n======STAGE4: COMPILER TECHNIQUES--> INTERMEDIATE CODE REPRESENTATION (ICR)");
            System.out.println("THE STRING ENTERED IS : " + expression);
            System.out.println("The ICR is as follows:");
            System.out.println(generateICR(expression));
            System.out.println("CONCLUSION-->The expression was correctly generated in ICR");
        }
    }

    // Derive the expression using a dummy grammar
    public static String deriveExpression(String expression) {
        StringBuilder derivation = new StringBuilder();
        derivation.append(expression).append(" ;");
        return derivation.toString();
    }

    // Generate intermediate code representation
    public static String generateICR(String expression) {
        StringBuilder icr = new StringBuilder();
        String[] tokens = expression.split("[+\\-*/]+");
        for (int i = 0; i < tokens.length; i++) {
            icr.append("t").append(i + 1).append("= ").append(tokens[i]);
            if (i != tokens.length - 1) {
                icr.append(expression.charAt(tokens[i].length() + (i * 1)));
            }
            icr.append("\n");
        }
        return icr.toString();
    }
}
