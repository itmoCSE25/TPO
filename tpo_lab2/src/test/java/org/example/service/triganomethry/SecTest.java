package org.example.service.triganomethry;

import java.io.IOException;

import function.trigonometric.Cos;
import function.trigonometric.Sec;
import org.example.service.utils.ArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecTest {
    private static Double DEFAULT_ACCURACY = 0.000001;

    private Cos cos;
    private Sec sec;

    @BeforeEach
    void init() {
        this.cos = Mockito.mock(Cos.class);
        this.sec = new Sec(cos);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/csc.csv")
    void cscTest(double x, double y) throws IOException {
        Mockito.when(cos.calculate(x)).thenReturn(
                ArgumentsProvider.getTestedValue(
                        "/Users/bekmvlad27/Desktop/study/TPO/tpo_lab2/src/test/resources/data/cos.csv", x
                )
        );
        assertEquals(y, sec.calculate(x), DEFAULT_ACCURACY);
    }
}
