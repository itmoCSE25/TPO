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

public class WriteCSV {

    public void write(String fileName, BigDecimal start, BigDecimal end, BigDecimal step, BigDecimal precision) throws IOException {
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Sec sec = new Sec(cos);
        Csc csc = new Csc(sin);
        Tan tan = new Tan(sin);
        Cot cot = new Cot(tan);
        Ln ln = new Ln();
        Log log = new Log(ln);
        SystemFunction systemFunction = new SystemFunction(sin, cos, sec, csc, tan, cot, ln, log);

        try (FileWriter writer = new FileWriter(fileName)) {
            BigDecimal x = start;
            writer.write("X, Result\n");

            while (x.compareTo(end) <= 0) {
                double result = systemFunction.calculate(x.doubleValue());
                writer.write(x + ", " + result + "\n");
                x = x.add(step);
            }
        }
    }
}
