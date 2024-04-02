package org.example.service.logarithmic;

import java.io.IOException;

import function.logarifmic.Ln;
import function.logarifmic.Log;
import org.example.service.utils.ArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogTest {

    private static Double DEFAULT_ACCURACY = 0.000001;

    private Ln ln;
    private Log log;

    @BeforeEach
    void init() {
        this.ln = Mockito.mock(Ln.class);
        this.log = new Log(ln);
    }

    @CsvFileSource(resources = "/logarithmic/log_3.csv")
    @ParameterizedTest
    void logWithBase3Test(double x, double y) throws IOException {
        Mockito.when(ln.calculate(x)).thenReturn(
                ArgumentsProvider.getTestedValue("/Users/bekmvlad27/Desktop/study/TPO/tpo_lab2/src/test/resources/logarithmic/ln.csv",x)
        );
        Mockito.when(ln.calculate(3)).thenReturn(
                ArgumentsProvider.getTestedValue("/Users/bekmvlad27/Desktop/study/TPO/tpo_lab2/src/test/resources/logarithmic/ln.csv",3)
        );
        assertEquals(y, log.calculate(x, 3), DEFAULT_ACCURACY);
    }

    @CsvFileSource(resources = "/logarithmic/log_5.csv")
    @ParameterizedTest
    void logWithBase5Test(double x, double y) throws IOException {
        Mockito.when(ln.calculate(x)).thenReturn(
                ArgumentsProvider.getTestedValue("/Users/bekmvlad27/Desktop/study/TPO/tpo_lab2/src/test/resources/logarithmic/ln.csv",x)
        );
        Mockito.when(ln.calculate(5)).thenReturn(
                ArgumentsProvider.getTestedValue("/Users/bekmvlad27/Desktop/study/TPO/tpo_lab2/src/test/resources/logarithmic/ln.csv",5)
        );
        assertEquals(y, log.calculate(x, 5), DEFAULT_ACCURACY);
    }

    @CsvFileSource(resources = "/logarithmic/log_10.csv")
    @ParameterizedTest
    void logWithBase10Test(double x, double y) throws IOException {
        Mockito.when(ln.calculate(x)).thenReturn(
                ArgumentsProvider.getTestedValue("/Users/bekmvlad27/Desktop/study/TPO/tpo_lab2/src/test/resources/logarithmic/ln.csv",x)
        );
        Mockito.when(ln.calculate(10)).thenReturn(
                ArgumentsProvider.getTestedValue("/Users/bekmvlad27/Desktop/study/TPO/tpo_lab2/src/test/resources/logarithmic/ln.csv",10)
        );
        assertEquals(y, log.calculate(x, 5), DEFAULT_ACCURACY);
    }
}
