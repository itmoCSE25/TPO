package org.example.lab1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArctgFunctionTest {
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0.5, 0.46364760900080587",
            "-0.5, -0.46364760900080587",
            "1, 0.7853981633974483",
            "-1, -0.7853981633974483",
            "10, 1.4711276743037347",
            "-10, -1.4711276743037347"
    })
    public void testArctg(double x, double expected) {
        double result = ArctgFunction.arctg(x);
        System.out.println("\nx = "+ x+ "\nresult = "+ result+"\nexpect = "+expected);
        assertEquals(expected, result, 0.003);
    }
}