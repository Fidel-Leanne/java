import java.util.Scanner;

public class Lab05_B {

    private static boolean isValid(String input) {
        if (!input.matches("[A-Za-z+-/*]+")) {
            System.out.println(
                    "# SYNTAX ERROR- Numbers 0,1 to 9 are not allowed. String should contain A to Z and a to z & operators +,-,*,/");
            return false;
        } else if (input.matches(".*[+-/*]{2,}.*") || input.matches(".*[A-Za-z]{2,}.*")) {
            System.out.println(
                    "# SEMANTIC ERROR- two operators (*,-,+,/) or Identifier (A to Z and a to z) cannot be written together!");
            return false;
        } else if (!input.matches(".*[+-/*].*")) {
            System.out.println("# SEMANTIC ERROR-Invalid String! There is no operator in the String (+, /, -, *,)");
            return false;
        } else if (input.matches(".*[^A-Za-z+-/*].*")) {
            System.out.println(
                    "# SEMANTIC ERROR-Invalid String! Use of Special Characters ie &, &&, $, %, !, ; , etc, not permitted.");
            return false;
        }
        return true;
    }

    private static void processString(String input) {
        System.out.println("======STAGE1: COMPILER TECHNIQUES--> LEXICAL ANALYSIS-Scanner\n" +
                "SYMBOL TABLE COMPRISING ATTRIBUTES AND TOKENS:");
        String[] tokens = input.split("(?=[-+*/])|(?<=[-+*/])");
        int tokenCount = 0;
        for (String token : tokens) {
            tokenCount++;
            System.out.println("TOKEN#" + tokenCount + " " + token);
        }
        System.out.println("Total number of Tokens: " + tokenCount);
        System.out.println("GIVEN THE GRAMMAR: E=E1 | E=E1*E2 | E=E1+E2 | E=digit | E={0,1,2,3,4,5,6,7,8,9}\n");

        System.out.println("======STAGE2: COMPILER TECHNIQUES--> SYNTAX ANALYSIS-Parser");
        System.out.println("GET A DERIVATION FOR :  " + input);
        System.out.println("ASSUME:      1=A, 2=B, 3=C, 4=D, 5=E, 6=F, 7=G, 8=H, 9=I\n");

        int digitCount = 0;
        for (String token : tokens) {
            if (token.matches("[A-Za-z]")) {
                System.out.print(" E" + (digitCount + 1) + " ");
                digitCount++;
            } else if (token.matches("[-+*/]")) {
                System.out.print(token);
            }
        }
        System.out.println("\n");

        System.out.println("======STAGE3: COMPILER TECHNIQUES--> SEMANTIC ANALYSIS");
        System.out.println("CONCLUSION-->This expression:  " + input + "  is Syntactically and Semantically correct\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter NEXT STRING (Type 99 to Exit):");
            String input = scanner.nextLine().trim();

            if (input.equals("99")) {
                System.out.println("Exit");
                break;
            }

            if (!isValid(input)) {
                System.out.println(
                        "CONCLUSION-->Wrong expression: " + input + " No Derivation done! PLS RE-ENTER A VALID STRING");
            } else {
                processString(input);
            }
        }

        scanner.close();
    }

}
