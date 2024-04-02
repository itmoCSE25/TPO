package function.trigonometric;

public class Tan {

    private final Cos cos;
    private final Sin sin;

    public Tan(Sin sin) {
        this.sin = sin;
        this.cos = new Cos(sin);
    }

    public double calculate(double x) {
        return sin.calculate(x) / cos.calculate(x);
    }
}
