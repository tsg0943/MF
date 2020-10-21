package com.company;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("3");
        list.add("1");
        list.add("7");
        list.add("6");
        System.out.println(list);
        Collections.swap(list, 0, 1);
        System.out.println(list);
        Collections.sort(list);
        for (String str : list) {
            System.out.println(" " + str);

        }
    }
}

