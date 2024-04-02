package org.example.service.triganomethry;

import function.trigonometric.Cos;
import function.trigonometric.Sin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {

    private static Double DEFAULT_ACCURACY = 0.000001;

    private Cos cos;

    @BeforeEach
    void init() {
        cos = new Cos();
    }

    @CsvFileSource(resources = "/data/cos.csv")
    @ParameterizedTest
    void cosTest(double x, double y) {
        assertEquals(y, cos.calculate(x), DEFAULT_ACCURACY);
    }
}
