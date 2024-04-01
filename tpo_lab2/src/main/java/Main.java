import function.logarifmic.*;
import function.trigonometric.*;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws IOException {
        final double start = -2;
        final double end = 2;
        final double step = 0.1;
        final int precisionScale = 10;

        WriteCSV csvWriter = new WriteCSV();

        csvWriter.write(
                "csv/cos.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                BigDecimal.valueOf(precisionScale));

        csvWriter.write(
                "csv/sin.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                BigDecimal.valueOf(precisionScale));

        csvWriter.write(
                "csv/tan.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                BigDecimal.valueOf(precisionScale));

        csvWriter.write(
                "csv/ln.csv",
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(20),
                BigDecimal.valueOf(step),
                BigDecimal.valueOf(precisionScale));

        csvWriter.write(
                "csv/log3.csv",
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(20),
                BigDecimal.valueOf(step),
                BigDecimal.valueOf(precisionScale));

        csvWriter.write(
                "csv/log5.csv",
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(20),
                BigDecimal.valueOf(step),
                BigDecimal.valueOf(precisionScale));

        csvWriter.write(
                "csv/log10.csv",
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(20),
                BigDecimal.valueOf(step),
                BigDecimal.valueOf(precisionScale));

        csvWriter.write(
                "csv/csc.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                BigDecimal.valueOf(precisionScale));

        csvWriter.write(
                "csv/sec.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                BigDecimal.valueOf(precisionScale));

        csvWriter.write(
                "csv/cot.csv",
                BigDecimal.valueOf(start),
                BigDecimal.valueOf(end),
                BigDecimal.valueOf(step),
                BigDecimal.valueOf(precisionScale));
    }
}
