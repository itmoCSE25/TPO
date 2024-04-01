package function.trigonometric;

public class Sec {
    public double calculate(double x) {
        Cos cos = new Cos();
        return 1 / cos.calculate(x);
    }
}
