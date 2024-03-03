package org.example.service;

public class ArctgFunctionService {

    public static double arctgSeriesExpansion(double x, int n) {
        double result = 0;
        for (int i = 0; i < n; i++) {
            double term = Math.pow(-1, i) * Math.pow(x, 2 * i + 1) / (2 * i + 1);
            result += term;
        }
        return result;
    }

    public static double arctg(double x) {
        if (Math.abs(x) > 1) {
            return Math.signum(x) * (Math.PI / 2 - arctgSeriesExpansion(1 / Math.abs(x), 100));
        } else {
            return arctgSeriesExpansion(x, 100);
        }
    }
}