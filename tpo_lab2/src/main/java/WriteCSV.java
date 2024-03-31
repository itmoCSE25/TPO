import function.SystemFunction;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class WriteCSV {

    public static void write(String fileName, BigDecimal start, BigDecimal end, BigDecimal step, BigDecimal precision) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            BigDecimal x = start;
            writer.write("X, Result\n");

            while (x.compareTo(end) <= 0) {
                double result = SystemFunction.calculate(x.doubleValue(), 10);
                writer.write(x + ", " + result + "\n");
                x = x.add(step);
            }
        }
    }

}




