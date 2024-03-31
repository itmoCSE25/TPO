package function;

import function.logarifmic.Log;
import function.trigonometric.*;

public class SystemFunction {
    public static double calculate(double x, int terms) {
        if (x <= 0) {
            return calculateTrigonometric(x);
        } else {
            return calculateLogarifmic(x, terms);
        }
    }

    private static double calculateTrigonometric(double x) {
        double secX = Sec.calculate(x);
        double cosX = Cos.calculate(x);
        double cscX = Csc.calculate(x);
        double cotX = Cot.calculate(x);
        double tanX = Tan.calculate(x);
        double sinX = Sin.calculate(x);


        return Math.pow((((((((((((((((secX + cosX) / cscX) * cscX) * cotX) + cscX) * tanX) / sinX) - cotX) * (sinX / sinX)) / secX) * (tanX * tanX))) +
                ((cscX + Math.pow(Math.pow(Math.pow(secX, 3), 3), 2)) + (tanX + cscX)))) +
                (cosX * ((cotX * tanX) * (sinX - cscX)))), 2) * Math.pow(((cotX * (Math.pow(secX, 2) * (((cotX + ((sinX / (secX + cosX))) - (cscX + secX))) * cotX) + sinX))) -
                (Math.pow(sinX, 2)), 2) * Math.pow(((((((Math.pow((cosX - cosX), 2) - sinX) - (cscX * (cscX - (secX - cosX))))) *
                ((cosX / Math.pow(cosX, 3)) + ((secX * cosX) + (cosX - ((cosX / (cscX + cosX))) / (cscX / sinX))))))) *
                ((cosX * ((cscX + (sinX / secX))) - cotX) - secX), 2) * Math.pow(((sinX + (((cosX * (cosX / ((tanX * cotX) / cosX)))) * ((secX + ((cscX + cosX)) - secX)) -
                (cotX - sinX)))), 2);
    }

    private static double calculateLogarifmic(double x, int terms) {
        double log5X = Log.calculate(x, 5, terms);
        double log10X = Log.calculate(x, 10, terms);
        double log3X = Log.calculate(x, 3, terms);

        return Math.pow((Math.pow((log5X / log5X), 2) + Math.pow(log10X, 2)), 3) + Math.pow(log3X, 2);
    }
}
