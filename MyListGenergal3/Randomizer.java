package com.company;
import java.util.Collection;

public class Randomizer {
    public static boolean randomInteger(Collection<Integer> collection, long number) {
        if (number < 0) {
            return false;
        }
        for (int i = 0; i < number; i++) {
            collection.add((int)(Math.random() * 100));
        }
        return true;
    }

    public static boolean randomDouble(Collection<Double> collection, long number) {
        if (number < 0) {
            return false;
        }
        for (int i = 0; i < number; i++) {
            collection.add((Math.random() * 100));
        }
        return true;
    }

    public static boolean randomString(Collection<String> collection, long number, long dlina ){
        if (number < 0) {
            return false;
        }
        String simvols = "01234567890ABCDEFGHIdhdhdhd";
        for (int i = 0; i < number; i++) {
            for (int g = 0; g < dlina; g++) {
                int ch = (int)(Math.random() * simvols.length());
                collection.add(simvols.substring(ch, ch + 1));
            }
        }
        return true;
    }
}
