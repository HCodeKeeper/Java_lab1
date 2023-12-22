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
        System.out.println("C2=" + C2 + "\nC3=" + C3 + "\nC5=" + C5 + "\nC7=" + C7);

        if (C >= a & C <= n){
            System.out.println("Error! i - C will eventually result in 0 and thus in division by zero.");
            return;
        }

        double sum = 0;
        for (int i = a; i < n; i++) {
            for (int j = b; j < m; j++) {
                if (willSubtractionOverflow(i, j) || willSubtractionOverflow(i, C)){
                    System.out.println("Error! Operations with i, j or C result in over/under-flow for int32." +
                            " The program won't calculate the result correctly. Aborting...");
                    return;
                }
                int dividend = i - j;
                int divisor = i - C;
                double quotient = dividend / (double) divisor;
                System.out.println(quotient);
                sum += quotient;
            }
        }

        System.out.println("Result: " + sum);
    }

    public static boolean willAdditionOverflow(int left, int right) {
        if (right < 0 && right != Integer.MIN_VALUE) {
            return willSubtractionOverflow(left, -right);
        } else {
            /*
            If there is no overflow in the addition operation, the sum (left + right) will be a valid integer,
            and XORing it with left won't change the sign bit. Therefore,
            the bitwise AND will not result in a negative value.
            If there is overflow, the XOR operation will cause a change in the sign bit, and the bitwise AND will
            yield a negative value.
             */
            return (~(left ^ right) & (left ^ (left + right))) < 0;
        }
    }

    public static boolean willSubtractionOverflow(int left, int right) {
        if (right < 0) {
            return willAdditionOverflow(left, -right);
        } else {
            /*
            If there is no overflow in the subtraction operation (left - right), the XOR operation between left and the
            result of the subtraction won't change the sign bit. Therefore, the bitwise AND won't result in a negative
            value, and the expression will evaluate to false.
            If there is overflow during subtraction, the XOR operation will cause a change in the sign bit
            (due to overflow). As a result, the bitwise AND will yield a negative value, and the expression
            will evaluate to true.
             */
            return ((left ^ right) & (left ^ (left - right))) < 0;
        }
    }
}