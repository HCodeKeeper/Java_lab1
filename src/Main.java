public class Main {
    public static void main(String[] args) {
        int studentNum = 9;
        int C2 = studentNum % 2;
        int C3 = studentNum % 3;
        int C5 = studentNum % 5;
        int C7 = studentNum % 7;
        int C = C3;
        int a = 4;
        int b = 1;
        int n = 7;
        int m = 9;
        System.out.println("StudentNum = 9\nO1 = '-'\nO2 = '-'\nC = 0\nj,i = 'int'");
        System.out.println("C2=" + C2 + "\nC3=" + C3 + "\nC5=" + C5 + "\nC7=" + C7);;

        int sum = 0;
        for (int i = a; i < n; i++) {
            for (int j = b; j < m; j++) {
                int dividend = i - j;
                int divisor = i - C;
                if (divisor == 0) {
                    throw new ArithmeticException("Division by zero");
                } else {
                    int quotient = dividend / divisor;
                    System.out.println(quotient);
                    sum += quotient;
                }
            }
        }

        System.out.println("Result: " + sum);
    }
}