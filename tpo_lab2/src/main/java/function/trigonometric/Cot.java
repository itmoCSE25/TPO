package function.trigonometric;

import function.logarifmic.Ln;

public class Cot {
    public double calculate(double x) {
        Tan tan = new Tan();
        return 1 / tan.calculate(x);

    }
}
