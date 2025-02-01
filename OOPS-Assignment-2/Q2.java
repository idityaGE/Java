
class Calculator {

    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static double subtract(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        if(b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}

class Q2 {

    public static void main(String[] args) {
        System.out.println(Calculator.add(1, 2));
        System.out.println(Calculator.add(1.5, 2.5));
        System.out.println(Calculator.subtract(2.5, 1.5));
        System.out.println(Calculator.multiply(2.5, 1.5));
        System.out.println(Calculator.divide(2.5, 1.5));
        System.out.println(Calculator.divide(2.5, 0));
    }
}
