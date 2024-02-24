public class recursionOfSumOfEven {

    public static int recursionSumOfEven(int value) {
        if (value <= 0) {
            return 0; // Base case: return 0 if value is non-positive
        } else if (value % 2 == 0) {
            // If value is even, add it to the sum of even numbers up to value-1
            return recursionSumOfEven(value - 1) + value;
        } else {
            // If value is odd, proceed to the next number without including it in the sum
            return recursionSumOfEven(value - 1);
        }
    }

    public static void main(String[] args) {

        int val1 = recursionSumOfEven(6);
        int val2 = recursionSumOfEven(10);

        System.out.println(val1);
        System.out.println(val2);

    }

}