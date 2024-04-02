package org.example.service.triganomethry;

import java.io.IOException;

import function.trigonometric.Cos;
import function.trigonometric.Sin;
import org.example.service.utils.ArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {

    private static Double DEFAULT_ACCURACY = 0.000001;

    private Sin sin;
    private Cos cos;

    @BeforeEach
    void init() {
        this.sin = Mockito.mock(Sin.class);
        this.cos = new Cos(sin);
    }

    @CsvFileSource(resources = "/trigonometry/cos.csv")
    @ParameterizedTest
    void cosTest(double x, double y) throws IOException {
        Mockito.when(sin.calculate(x)).thenReturn(
                ArgumentsProvider.getTestedValue("/Users/bekmvlad27/Desktop/study/TPO/tpo_lab2/src/test/resources/trigonometry/sin.csv",x)
        );
        assertEquals(y, cos.calculate(x), DEFAULT_ACCURACY);
    }
}
