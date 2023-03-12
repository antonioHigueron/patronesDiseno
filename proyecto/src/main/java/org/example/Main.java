package org.example;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

interface  Calla{
    public void call(int number);
}

class T implements Calla{
    @Override
    public void call(int number) {
        System.out.println(number);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Abstract_Factory: https://refactoring.guru/es/design-patterns/abstract-factory/java/example
    }


}