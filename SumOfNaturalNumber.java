public class SumOfNaturalNumber {

    public static int recursiveSummation(int value) {
        if (value <= 1)
            return value;

        return recursiveSummation(value - 1) + value;
    }

    public static void main(String[] args) {
        int num1 = recursiveSummation(5);
        int num2 = recursiveSummation(10);

        System.out.println(num1);
        System.out.println(num2);
    }

}
