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

public class SystemFunctionTest {

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
        this.sec = Mockito.mock(Sec.class);
        this.csc = Mockito.mock(Csc.class);
        this.tan = Mockito.mock(Tan.class);
        this.cot = Mockito.mock(Cot.class);
        this.ln = Mockito.mock(Ln.class);
        this.log = Mockito.mock(Log.class);
        this.systemFunction = new SystemFunction(sin, cos, sec, csc, tan, cot, ln, log);

    }

    @BeforeEach
    public void init1() {
        this.sin = Mockito.mock(Sin.class);
        this.cos = Mockito.mock(Cos.class);
//        this.sec = Mockito.mock(Sec.class);
        this.csc = Mockito.mock(Csc.class);
//        this.tan = Mockito.mock(Tan.class);
//        this.cot = Mockito.mock(Cot.class);
        this.ln = Mockito.mock(Ln.class);
//        this.log = Mockito.mock(Log.class);
        this.systemFunction = new SystemFunction(sin, cos, sec, csc, tan, cot, ln, log);

    }

    @BeforeEach
    public void init2() {
        this.sin = Mockito.mock(Sin.class);
//        this.cos = Mockito.mock(Cos.class);
//        this.sec = Mockito.mock(Sec.class);
//        this.csc = Mockito.mock(Csc.class);
//        this.tan = Mockito.mock(Tan.class);
//        this.cot = Mockito.mock(Cot.class);
        this.ln = Mockito.mock(Ln.class);
//        this.log = Mockito.mock(Log.class);
        this.systemFunction = new SystemFunction(sin, cos, sec, csc, tan, cot, ln, log);

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/system_function.csv")
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
        Mockito.when(sec.calculate(x)).thenReturn(ArgumentsProvider.getTestedValue(
                basePath + "sec.csv", x
        ));
        Mockito.when(csc.calculate(x)).thenReturn(ArgumentsProvider.getTestedValue(
                basePath + "csc.csv", x
        ));
        Mockito.when(tan.calculate(x)).thenReturn(ArgumentsProvider.getTestedValue(
                basePath + "tan.csv", x
        ));
        Mockito.when(cot.calculate(x)).thenReturn(ArgumentsProvider.getTestedValue(
                basePath + "cot.csv", x
        ));
    }

    private void mockLogarithmic(double x) throws IOException {
        Mockito.when(ln.calculate(x)).thenReturn(ArgumentsProvider.getTestedValue(
                "logarithmic/ln.csv", x
        ));
        Mockito.when(log.calculate(x, 3)).thenReturn(ArgumentsProvider.getTestedValue(
                "logarithmic/log_3.csv", x
        ));
        Mockito.when(log.calculate(x, 5)).thenReturn(ArgumentsProvider.getTestedValue(
                "logarithmic/log_5.csv", x
        ));
        Mockito.when(log.calculate(x, 10)).thenReturn(ArgumentsProvider.getTestedValue(
                "logarithmic/log_10.csv", x
        ));
    }
}
