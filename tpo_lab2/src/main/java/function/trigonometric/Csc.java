package function.trigonometric;

public class Csc {
    public double calculate(double x) {
        Sin sin = new Sin();
        return 1 / sin.calculate(x);
    }
}
