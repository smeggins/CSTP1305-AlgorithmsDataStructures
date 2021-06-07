public class countRecursive {

    // this is tail recursive because the last line of the method is
    // a recursive call
    private static void countdown(int n) {
        System.out.println("value of n: " + n);
        if (n > 1) {
            countdown(n-1);
        }
    }

    private static void countdownItr(int n) {
        while (n > 0) {
            System.out.println("value of n: " + n);
            --n;
        }
    }

    public static void main(String[] args) throws Exception {
        // Basic countdown using itr and recur
        System.out.println("Start countdown with 10: ");
        countdown(10);
        System.out.println("Start countdownItr with 10: ");
        countdownItr(10);
    }
}