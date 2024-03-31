package function.trigonometric;

public class Tan {
    public static double calculate(double x) {
        return Sin.calculate(x) / Cos.calculate(x);
    }
}
