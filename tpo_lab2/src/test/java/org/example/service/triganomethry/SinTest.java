package org.example.service.triganomethry;


import function.trigonometric.Sin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {

    private static Double DEFAULT_ACCURACY = 0.000001;

    private Sin sin;


    @BeforeEach
    public void init() {
        sin = new Sin();
    }

    @CsvFileSource(resources = "/trigonometry/sin.csv")
    @ParameterizedTest
    void sinTest(double x, double y) {
        assertEquals(y, sin.calculate(x), DEFAULT_ACCURACY);
    }
}
