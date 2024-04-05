import function.logarifmic.*;
import function.trigonometric.*;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws IOException {
        final double start = -10;
        final double end = 10;
        final double step = 0.1;

        WriteCSV csvWriter = new WriteCSV();

        csvWriter.write(
                "csv/cos.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                "cos");

        csvWriter.write(
                "csv/sin.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                "sin");

        csvWriter.write(
                "csv/tan.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                "tan");

        csvWriter.write(
                "csv/ln.csv",
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(20),
                BigDecimal.valueOf(step),
                "ln");

        csvWriter.write(
                "csv/log3.csv",
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(20),
                BigDecimal.valueOf(step),
                "log3");

        csvWriter.write(
                "csv/log5.csv",
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(20),
                BigDecimal.valueOf(step),
                "log5");

        csvWriter.write(
                "csv/log10.csv",
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(20),
                BigDecimal.valueOf(step),
                "log10");

        csvWriter.write(
                "csv/csc.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                "csc");

        csvWriter.write(
                "csv/sec.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                "sec");

        csvWriter.write(
                "csv/cot.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
               "cot");

        csvWriter.write(
                "csv/func.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                "func");
    }
}
