import function.SystemFunction;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class WriteCSV {

    public void write(String fileName, BigDecimal start, BigDecimal end, BigDecimal step, BigDecimal precision) throws IOException {
        SystemFunction systemFunction = new SystemFunction();

        try (FileWriter writer = new FileWriter(fileName)) {
            BigDecimal x = start;
            writer.write("X, Result\n");

            while (x.compareTo(end) <= 0) {
                double result = systemFunction.calculate(x.doubleValue(), 10);
                writer.write(x + ", " + result + "\n");
                x = x.add(step);
            }
        }
    }
}
