package com.company;

public class MyFloat {
    private long mantissa;
    private long exponent;

    public MyFloat(long mantissa, long exponent) {
        this.mantissa = mantissa;
        this.exponent = exponent;
    }

    public void diff(MyFloat x) {
        long mant = this.mantissa;
        long mant1 = x.mantissa;
        long exp = Math.max(this.exponent, x.exponent);
        long rez = 0;
        if (this.exponent > x.exponent) {
            mant1 = mant1 * (long) Math.pow(10, this.exponent - x.exponent);
        } else if (x.exponent > this.exponent) {
            mant = mant * (long) Math.pow(10, x.exponent - this.exponent);
        }
        rez = mant - mant1;
        char[] dot = Long.toString(rez).toCharArray();
        for (int i = 0; i < (dot.length - exp); ++i) {
            System.out.print(dot[i]);
        }
        System.out.print(",");
        for (int i = (dot.length - (int) exp); i < dot.length; ++i) {
            System.out.print(dot[i]);
        }
    }
}
