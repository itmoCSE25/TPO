package function.trigonometric;

public class Cos {
    public double calculate(double x) {
        double result = 0;
        for (int n = 0; n < 10; n++) {
            result += Math.pow(-1, n) * Math.pow(x, 2 * n) / factorial(2 * n);
        }
        return result;
    }

    private double factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}

