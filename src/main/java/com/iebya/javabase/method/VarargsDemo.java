package com.iebya.javabase.method;

public class VarargsDemo {
    public static void printVariable(String... args) {
        for (String s : args) {
            System.out.println(s);
        }
    }

    public static void printVariable(String arg1, String arg2) {
        System.out.println(arg1 + arg2);
    }

    public static void main(String[] args) {
        printVariable("a", "b"); // 优先使用固定参数的方法
        printVariable("a", "b", "c", "d");
    }
}
