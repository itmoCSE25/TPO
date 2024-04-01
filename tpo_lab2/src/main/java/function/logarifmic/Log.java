package function.logarifmic;

public class Log {
    public double calculate(double x, double base, int terms) {
        Ln ln = new Ln();
        return ln.calculate(x, terms) / ln.calculate(base, terms);
    }
}
