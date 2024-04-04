import java.util.Scanner;

public class SumOfCubes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input startNo and endNo
        System.out.print("Enter 2 Numbers separated with a space (startNo and endNo): ");
        int startNo = scanner.nextInt();
        int endNo = scanner.nextInt();

        // Check conditions
        if (startNo < 0) {
            System.out.println("startNo cannot be less than 0");
            return;
        }

        if (endNo < 0) {
            System.out.println("endNo cannot be less than 0");
            return;
        }

        if (endNo > 9) {
            System.out.println("endNo cannot be greater than 9");
            return;
        }

        if (startNo > endNo) {
            System.out.println("startNo must NOT be greater than endNo");
            return;
        }

        // Calculate sum of cubes
        int sumCube = 0;
        for (int i = startNo; i <= endNo; i++) {
            sumCube += i * i * i;
        }

        // Output result
        System.out.println("Sum of Cube of Numbers = " + sumCube);
    }
}
