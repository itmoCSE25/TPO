import function.SystemFunction;
import function.logarifmic.Ln;
import function.logarifmic.Log;
import function.trigonometric.Cos;
import function.trigonometric.Cot;
import function.trigonometric.Csc;
import function.trigonometric.Sec;
import function.trigonometric.Sin;
import function.trigonometric.Tan;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

public class WriteCSV {
    Sin sin = new Sin();
    Cos cos = new Cos(sin);
    Sec sec = new Sec(cos);
    Csc csc = new Csc(sin);
    Tan tan = new Tan(sin);
    Cot cot = new Cot(tan);
    Ln ln = new Ln();
    Log log = new Log(ln);
    SystemFunction systemFunction = new SystemFunction(sin, cos, sec, csc, tan, cot, ln, log);

    public void write(String fileName, BigDecimal start, BigDecimal end, BigDecimal step, String name) throws IOException {

        try (FileWriter writer = new FileWriter(fileName)) {
            BigDecimal x = start;
            writer.write("X, Result\n");
            if(Objects.equals(name, "sin")){
                while (x.compareTo(end) <= 0) {
                    double result = sin.calculate(x.doubleValue());
                    writer.write(x + ", " + result + "\n");
                    x = x.add(step);
                }
            }
            else if(Objects.equals(name, "cos")){
                while (x.compareTo(end) <= 0) {
                    double result = cos.calculate(x.doubleValue());
                    writer.write(x + ", " + result + "\n");
                    x = x.add(step);
                }
            }
            else if(Objects.equals(name, "tan")){
                while (x.compareTo(end) <= 0) {
                    double result = tan.calculate(x.doubleValue());
                    writer.write(x + ", " + result + "\n");
                    x = x.add(step);
                }
            }
            else if(Objects.equals(name, "cot")){
                while (x.compareTo(end) <= 0) {
                    double result = cot.calculate(x.doubleValue());
                    writer.write(x + ", " + result + "\n");
                    x = x.add(step);
                }
            }
            else if(Objects.equals(name, "csc")){
                while (x.compareTo(end) <= 0) {
                    double result = csc.calculate(x.doubleValue());
                    writer.write(x + ", " + result + "\n");
                    x = x.add(step);
                }
            }
            else if(Objects.equals(name, "sec")){
                while (x.compareTo(end) <= 0) {
                    double result = sec.calculate(x.doubleValue());
                    writer.write(x + ", " + result + "\n");
                    x = x.add(step);
                }
            }
            else if(Objects.equals(name, "ln")){
                while (x.compareTo(end) <= 0) {
                    double result = ln.calculate(x.doubleValue());
                    writer.write(x + ", " + result + "\n");
                    x = x.add(step);
                }
            }
            else if(Objects.equals(name, "log3")){
                while (x.compareTo(end) <= 0) {
                    double result = log.calculate(x.doubleValue(), 3);
                    writer.write(x + ", " + result + "\n");
                    x = x.add(step);
                }
            }
            else if(Objects.equals(name, "log5")){
                while (x.compareTo(end) <= 0) {
                    double result = log.calculate(x.doubleValue(), 5);
                    writer.write(x + ", " + result + "\n");
                    x = x.add(step);
                }
            }
            else if(Objects.equals(name, "log10")){
                while (x.compareTo(end) <= 0) {
                    double result = log.calculate(x.doubleValue(), 10);
                    writer.write(x + ", " + result + "\n");
                    x = x.add(step);
                }
            }
            else if(Objects.equals(name, "func")){
                while (x.compareTo(end) <= 0) {
                    double result = systemFunction.calculate(x.doubleValue());
                    writer.write(x + ", " + result + "\n");
                    x = x.add(step);
                }
            }

        }
    }
}
