public class RecursiveFib {

    private static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        else {
            return fib(n-1) + fib(n-2);
        }
    }

    private static int fibItr(int n) {
        int x = 0;
        int y = 1;
        int z = y;
        for (int j = 0; j < n-1; j++) {
            z = y;
            y = x+y;
            x = z;
        }
        return y;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("fib of 5: " + fib(5));
        System.out.println("fib of 5: " + fibItr(5));
    }
}