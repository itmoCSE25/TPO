package org.example.service.logarithmic;

import java.io.IOException;

import function.logarifmic.Ln;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LnTest {

    private static Double DEFAULT_ACCURACY = 0.000001;

    private Ln ln;

    @BeforeEach
    void init() {
        this.ln = new Ln();
    }

    @CsvFileSource(resources = "/logarithmic/ln.csv")
    @ParameterizedTest
    void lnTest(double x, double y) {
        assertEquals(y, ln.calculate(x), DEFAULT_ACCURACY);
    }

    @Test
    void lnUndefinedTest() {
        assertThrows(IllegalArgumentException.class, () -> ln.calculate(-1));
        assertThrows(IllegalArgumentException.class, () -> ln.calculate(0));
    }
}
