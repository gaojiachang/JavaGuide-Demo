package com.iebya.base;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        Animalt dog = food -> "return: Dog eat " + food;
        System.out.println(dog.eat("bone"));
        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.forEach(s -> System.out.println(s));   

    }
}

interface Animalt {
    String eat(String food);
}