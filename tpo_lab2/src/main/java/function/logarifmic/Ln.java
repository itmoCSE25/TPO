package function.logarifmic;

public class Ln {
    public double calculate(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException();
        }
        double prec = 1.0 / Math.pow(10, 10);
        double xAbs = Math.abs((x - 1) / (x + 1));
        double sum = 0.0, m = xAbs;

        for (int i = 1; m > prec; i++) {
            sum += m;
            m *= xAbs * xAbs * (2 * i - 1) / (2 * i + 1);
        }
        return (x < 1 ? -2 : 2) * sum;
    }
}
