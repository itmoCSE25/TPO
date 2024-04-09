package org.example.service;

import java.io.IOException;

import function.SystemFunction;
import function.logarifmic.Ln;
import function.logarifmic.Log;
import function.trigonometric.Cos;
import function.trigonometric.Cot;
import function.trigonometric.Csc;
import function.trigonometric.Sec;
import function.trigonometric.Sin;
import function.trigonometric.Tan;
import org.example.service.utils.ArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemFunctionMiddleMockTest {
    private Sin sin;
    private Cos cos;
    private Sec sec;
    private Csc csc;
    private Tan tan;
    private Cot cot;
    private Ln ln;
    private Log log;
    private SystemFunction systemFunction;

    @BeforeEach
    public void init() {
        this.sin = Mockito.mock(Sin.class);
        this.cos = Mockito.mock(Cos.class);
        this.csc = Mockito.mock(Csc.class);
        this.sec = new Sec(cos);
        this.tan = new Tan(sin);
        this.cot = new Cot(tan);
        this.ln = Mockito.mock(Ln.class);
        this.log = new Log(ln);
        this.systemFunction = new SystemFunction(sin, cos, sec, csc, tan, cot, ln, log);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/system_function_middle.csv")
    void systemFunctionTest(double x, double y) throws IOException {
        if (x > 0) {
            mockLogarithmic(x);
        } else {
            mockTrigonometry(x);
        }
        assertEquals(y, systemFunction.calculate(x), 0.00001);
    }

    private void mockTrigonometry(double x) throws IOException {
        String basePath = "trigonometry/";
        Mockito.when(sin.calculate(x)).thenReturn(ArgumentsProvider.getTestedValue(
                basePath + "sin.csv", x
        ));
        Mockito.when(cos.calculate(x)).thenReturn(ArgumentsProvider.getTestedValue(
                basePath + "cos.csv", x
        ));
        Mockito.when(csc.calculate(x)).thenReturn(ArgumentsProvider.getTestedValue(
                basePath + "csc.csv", x
        ));
    }

    private void mockLogarithmic(double x) throws IOException {
        Mockito.when(ln.calculate(x)).thenReturn(ArgumentsProvider.getTestedValue(
                "logarithmic/ln.csv", x
        ));
    }
}
