package function.trigonometric;

public class Csc {

    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public double calculate(double x) {
        return 1 / sin.calculate(x);
    }
}
