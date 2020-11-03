package com.company;

public class MyFloat {
    private long mantissa; //создаем приватные переменные типа long 64разрядного целого числа
    private long exponent;

    public MyFloat(long mantissa, long exponent) { //класс, в который передаем параметры
        this.mantissa = mantissa;
        this.exponent = exponent;
    }

    public void diff(MyFloat x) { //реализуем метод вычитания
        long mant = this.mantissa; //присваем mant значение mantissa
        long mant1 = x.mantissa; //обращение к первой части числа
        long exp = Math.max(this.exponent, x.exponent); //выбирает максимальное значение из 2
        long rez = 0;
        if (this.exponent > x.exponent) { //если экспанента а больше экспаненты б
            mant1 = mant1 * (long) Math.pow(10, this.exponent - x.exponent); //то мантисса а на (10 в степени разности экспонент)
        } else if (x.exponent > this.exponent) { //тоже самое, но наоборот
            mant = mant * (long) Math.pow(10, x.exponent - this.exponent);
        }
        rez = mant - mant1;
        char[] dot = Long.toString(rez).toCharArray();//массив типа char- переводит в стринг
        for (int i = 0; i < (dot.length - exp); ++i) { // выводит целую часть
            System.out.print(dot[i]);
        }
        System.out.print(",");//ставит запятую после целой части
        for (int i = (dot.length - (int) exp); i < dot.length; ++i) { //выводит оставшуюся часть
            System.out.print(dot[i]);
        }
    }
}
