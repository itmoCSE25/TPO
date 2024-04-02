package org.example.service.triganomethry;

import java.io.IOException;

import function.trigonometric.Cot;
import function.trigonometric.Tan;
import org.example.service.utils.ArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CotTest {

    private static Double DEFAULT_ACCURACY = 0.000001;

    private Tan tan;
    private Cot cot;

    @BeforeEach
    void init() {
        this.tan = Mockito.mock(Tan.class);
        this.cot = new Cot(tan);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/cot.csv")
    void cotTest(double x, double y) throws IOException {
        Mockito.when(tan.calculate(x)).thenReturn(
                ArgumentsProvider.getTestedValue(
                        "/Users/bekmvlad27/Desktop/study/TPO/tpo_lab2/src/test/resources/data/tan.csv", x
                )
        );
        assertEquals(y, cot.calculate(x), DEFAULT_ACCURACY);
    }
}
