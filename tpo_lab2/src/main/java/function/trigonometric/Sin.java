package function.trigonometric;

public class Sin {
    public double calculate(double x) {
        double result = 0;
        for (int n = 0; n < 10; n++) {
            result += Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
        }
        return result;
    }

    private static double factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
