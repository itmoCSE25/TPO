package function;

import function.logarifmic.Ln;
import function.logarifmic.Log;
import function.trigonometric.*;

public class SystemFunction {
    public double calculate(double x, int terms) {
        if (x <= 0) {
            return calculateTrigonometric(x);
        } else {
            return calculateLogarifmic(x, terms);
        }
    }

    private double calculateTrigonometric(double x) {
        Sin sin = new Sin();
        double sinX = sin.calculate(x);

        Cos cos = new Cos(sin);
        double cosX = cos.calculate(x);

        Sec sec = new Sec(cos);
        double secX = sec.calculate(x);

        Csc csc = new Csc(sin);
        double cscX = csc.calculate(x);

        Tan tan = new Tan(sin);
        double tanX = tan.calculate(x);

        Cot cot = new Cot(tan);
        double cotX = cot.calculate(x);



        return Math.pow((((((((((((((((secX + cosX) / cscX) * cscX) * cotX) + cscX) * tanX) / sinX) - cotX) * (sinX / sinX)) / secX) * (tanX * tanX))) +
                ((cscX + Math.pow(Math.pow(Math.pow(secX, 3), 3), 2)) + (tanX + cscX)))) +
                (cosX * ((cotX * tanX) * (sinX - cscX)))), 2) * Math.pow(((cotX * (Math.pow(secX, 2) * (((cotX + ((sinX / (secX + cosX))) - (cscX + secX))) * cotX) + sinX))) -
                (Math.pow(sinX, 2)), 2) * Math.pow(((((((Math.pow((cosX - cosX), 2) - sinX) - (cscX * (cscX - (secX - cosX))))) *
                ((cosX / Math.pow(cosX, 3)) + ((secX * cosX) + (cosX - ((cosX / (cscX + cosX))) / (cscX / sinX))))))) *
                ((cosX * ((cscX + (sinX / secX))) - cotX) - secX), 2) * Math.pow(((sinX + (((cosX * (cosX / ((tanX * cotX) / cosX)))) * ((secX + ((cscX + cosX)) - secX)) -
                (cotX - sinX)))), 2);
    }

    private double calculateLogarifmic(double x, int terms) {
        Ln ln = new Ln();
        Log log = new Log(ln);
        double log5X = log.calculate(x, 5);
        double log10X = log.calculate(x, 10);
        double log3X = log.calculate(x, 3);

        return Math.pow((Math.pow((log5X / log5X), 2) + Math.pow(log10X, 2)), 3) + Math.pow(log3X, 2);
    }
}
