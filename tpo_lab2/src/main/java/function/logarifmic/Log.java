package function.logarifmic;

public class Log {

    private final Ln ln;

    public Log(Ln ln) {
        this.ln = ln;
    }


    public double calculate(double x, double base) {
        return ln.calculate(x) / ln.calculate(base);
    }
}
