package org.example.service.triganomethry;

import java.io.IOException;

import function.trigonometric.Sin;
import function.trigonometric.Tan;
import org.example.service.utils.ArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TanTest {

    private static Double DEFAULT_ACCURACY = 0.000001;

    private Tan tan;
    private Sin sin;

    @BeforeEach
    void init() {
        this.sin = Mockito.mock(Sin.class);
        this.tan = new Tan(sin);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/tan.csv")
    void tanTest(double x, double y) throws IOException {
        Mockito.when(tan.calculate(x)).thenReturn(
                ArgumentsProvider.getTestedValue("/Users/bekmvlad27/Desktop/study/TPO/tpo_lab2/src/test/resources/data/sin.csv", x)
        );
        assertEquals(y, tan.calculate(x), DEFAULT_ACCURACY);
    }
}
