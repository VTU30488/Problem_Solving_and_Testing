import java.util.*;

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String operator = sc.next();
        int b = sc.nextInt();

        Calculator calc = new Calculator();

        try {
            double result;

            if (operator.equals("+")) {
                result = calc.add(a, b);
            } else if (operator.equals("/")) {
                result = calc.divide(a, b);
            } else {
                System.out.println("Invalid Operation");
                return;
            }

            System.out.println("Test Passed");

        } catch (ArithmeticException e) {
            System.out.println("Test Failed");
        }

        sc.close();
    }
}