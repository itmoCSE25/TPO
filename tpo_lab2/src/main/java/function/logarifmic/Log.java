package function.logarifmic;

public class Log {
    public static double calculate(double x, double base, int terms) {
        return Ln.calculate(x, terms) / Ln.calculate(base, terms);
    }
}


