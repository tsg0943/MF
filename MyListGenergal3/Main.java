package com.company;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
            MyList<String> myList = new MyList((a, b) -> a.getValue().toString().compareTo(b.getValue().toString()));//Лямбда выражение
            Randomizer.randomString(myList, 10, 1);
            System.out.println(myList.tostring());
        myList.indexAt(2);
        System.out.println(myList.tostring());
        myList.swap(1, 4);
        System.out.println(myList.tostring());
    }
}

