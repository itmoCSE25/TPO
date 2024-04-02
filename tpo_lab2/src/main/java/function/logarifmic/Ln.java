package function.logarifmic;

public class Ln {
    public double calculate(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("ln(x) is undefined for x <= 0");
        }
        double result = 0;
        for (int n = 1; n <= 100; n++) {
            result += (Math.pow(-1, n + 1) / n) * Math.pow((x - 1), n);
        }
        return result;
    }
}
