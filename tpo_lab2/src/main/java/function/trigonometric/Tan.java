package function.trigonometric;

public class Tan {
    public double calculate(double x) {
        Cos cos = new Cos();
        Sin sin = new Sin();
        return sin.calculate(x) / cos.calculate(x);
    }
}
