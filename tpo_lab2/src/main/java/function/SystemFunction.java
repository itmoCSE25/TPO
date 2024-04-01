package function;

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
        Sec sec = new Sec();
        double secX = sec.calculate(x);

        Cos cos = new Cos();
        double cosX = cos.calculate(x);

        Csc csc = new Csc();
        double cscX = csc.calculate(x);

        Cot cot = new Cot();
        double cotX = cot.calculate(x);

        Tan tan = new Tan();
        double tanX = tan.calculate(x);

        Sin sin = new Sin();
        double sinX = sin.calculate(x);



        return Math.pow((((((((((((((((secX + cosX) / cscX) * cscX) * cotX) + cscX) * tanX) / sinX) - cotX) * (sinX / sinX)) / secX) * (tanX * tanX))) +
                ((cscX + Math.pow(Math.pow(Math.pow(secX, 3), 3), 2)) + (tanX + cscX)))) +
                (cosX * ((cotX * tanX) * (sinX - cscX)))), 2) * Math.pow(((cotX * (Math.pow(secX, 2) * (((cotX + ((sinX / (secX + cosX))) - (cscX + secX))) * cotX) + sinX))) -
                (Math.pow(sinX, 2)), 2) * Math.pow(((((((Math.pow((cosX - cosX), 2) - sinX) - (cscX * (cscX - (secX - cosX))))) *
                ((cosX / Math.pow(cosX, 3)) + ((secX * cosX) + (cosX - ((cosX / (cscX + cosX))) / (cscX / sinX))))))) *
                ((cosX * ((cscX + (sinX / secX))) - cotX) - secX), 2) * Math.pow(((sinX + (((cosX * (cosX / ((tanX * cotX) / cosX)))) * ((secX + ((cscX + cosX)) - secX)) -
                (cotX - sinX)))), 2);
    }

    private double calculateLogarifmic(double x, int terms) {
        Log log = new Log();
        double log5X = log.calculate(x, 5, terms);
        double log10X = log.calculate(x, 10, terms);
        double log3X = log.calculate(x, 3, terms);

        return Math.pow((Math.pow((log5X / log5X), 2) + Math.pow(log10X, 2)), 3) + Math.pow(log3X, 2);
    }
}
