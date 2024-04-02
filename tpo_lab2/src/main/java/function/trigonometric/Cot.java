package function.trigonometric;

public class Cot {

    private final Tan tan;

    public Cot(Tan tan) {
        this.tan = tan;
    }

    public double calculate(double x) {
        return 1 / tan.calculate(x);

    }
}
