package function.trigonometric;

public class Cos {

    private final Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    public double calculate(double x) {
        double temp = x % (2 * Math.PI);
        if (x < 0) {
            temp += 2 * Math.PI;
        }

        if (temp > Math.PI / 2 && temp < (Math.PI + Math.PI / 2)) {
            return -Math.sqrt(1 - Math.pow(sin.calculate(x), 2));
        } else {
            double sinSq = Math.pow(sin.calculate(x), 2);
            return Math.sqrt(1 - sinSq);
        }
    }

    private double factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}

