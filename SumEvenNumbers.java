import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Accepting input for startNo
        System.out.print("Enter startNo: ");
        int startNo = scanner.nextInt();

        // Accepting input for endNo
        System.out.print("Enter endNo: ");
        int endNo = scanner.nextInt();

        // (a) Check if startNo is less than 0
        if (startNo < 0) {
            System.out.println("startNo cannot be less than 0");
            return;
        }

        // (b) Check if endNo is less than 0
        if (endNo < 0) {
            System.out.println("endNo cannot be less than 0");
            return;
        }

        // (c) Check if endNo is greater than 9
        if (endNo > 9) {
            System.out.println("endNo cannot be greater than 9");
            return;
        }

        // (d) Check if startNo is greater than endNo
        if (startNo > endNo) {
            System.out.println("startNo must NOT be greater than endNo");
            return;
        }

        int sumEven = 0;
        // Loop through the numbers between startNo and endNo
        for (int i = startNo; i <= endNo; i++) {
            // Check if the number is even
            if (i % 2 == 0) {
                sumEven += i; // Add even number to the sum
            }
        }

        // (e) Print the sum of even numbers
        System.out.println("Sum of Even Numbers = " + sumEven);
    }
}
