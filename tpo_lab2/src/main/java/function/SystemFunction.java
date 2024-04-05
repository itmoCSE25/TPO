package function;

import function.logarifmic.Ln;
import function.logarifmic.Log;
import function.trigonometric.*;

public class SystemFunction {

    private final Sin sin;
    private final Cos cos;
    private final Sec sec;
    private final Csc csc;
    private final Tan tan;
    private final Cot cot;
    private final Ln ln;
    private final Log log;

    public SystemFunction(Sin sin, Cos cos, Sec sec, Csc csc, Tan tan, Cot cot, Ln ln, Log log) {
        this.sin = sin;
        this.cos = cos;
        this.sec = sec;
        this.csc = csc;
        this.tan = tan;
        this.cot = cot;
        this.ln = ln;
        this.log = log;
    }

    public double calculate(double x) {
        if (x <= 0) {
            return calculateTrigonometric(x);
        } else {
            return calculateLogarifmic(x);
        }
    }

    private double calculateTrigonometric(double x) {
        double sinX = sin.calculate(x);
        double cosX = cos.calculate(x);
        double secX = sec.calculate(x);
        double cscX = csc.calculate(x);
        double tanX = tan.calculate(x);
        double cotX = cot.calculate(x);


        return (((Math.pow((((((((((((((secX + cosX) / cscX) * cscX) * cotX) + cscX) * tanX) / sinX) - cotX) * (sinX / sinX)) / secX) * (tanX * tanX)) + ((cscX + Math.pow(Math.pow(Math.pow(secX, 3), 3),2)) + (tanX + cscX))) + (cosX * ((cotX * tanX) * (sinX - cscX)))),2) * ((cotX * (Math.pow(secX, 2) * (((cotX + ((sinX / (secX + cosX)) - (cscX + secX))) * cotX) + sinX))) - Math.pow(sinX, 2))) * ((((Math.pow((cosX - cosX), 2) - sinX) - (cscX * (cscX - (secX - cosX)))) * ((cosX / (Math.pow(cosX, 3))) + ((secX * cosX) + (cosX - ((cosX / (cscX + cosX)) / (cscX / sinX)))))) * ((cosX * ((cscX + (sinX / secX)) - cotX)) - secX))) + ((sinX + (Math.pow(((cosX * (cosX / ((tanX * cotX) / cosX))) * ((secX + ((cscX + cosX) - secX)) - (cotX - sinX))), 2))) + cscX));
    }

    private double calculateLogarifmic(double x) {
        double log5X = log.calculate(x, 5);
        double log10X = log.calculate(x, 10);
        double log3X = log.calculate(x, 3);

        return Math.pow((Math.pow((log5X / log5X), 2) + Math.pow(log10X, 2)), 3) + Math.pow(log3X, 2);
    }
}
