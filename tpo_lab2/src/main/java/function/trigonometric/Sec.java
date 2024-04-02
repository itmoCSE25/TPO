package function.trigonometric;

public class Sec {

    private final Cos cos;

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public double calculate(double x) {
        return 1 / cos.calculate(x);
    }
}
