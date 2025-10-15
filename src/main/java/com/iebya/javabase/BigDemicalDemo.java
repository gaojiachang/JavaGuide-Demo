package com.iebya.javabase;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDemicalDemo {
    public static void main(String[] args) {
        float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999905
        System.out.println(a == b);// false

        System.out.println("______________________");

        BigDecimal aa = new BigDecimal("1.0");
        BigDecimal bb = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        BigDecimal x = aa.subtract(bb);
        BigDecimal y = bb.subtract(c);
        System.out.println(x.compareTo(y));// 0

        System.out.println("______________________");

        BigDecimal d = new BigDecimal("1.0");
        BigDecimal e = BigDecimal.valueOf(1.0); // 存在精度丢失风险
        System.out.println(d);
        System.out.println(e);

        System.out.println("______________________");

        BigDecimal f = new BigDecimal("1.0");
        BigDecimal g = new BigDecimal("0.9");
        System.out.println(f.add(g));// 1.9
        System.out.println(f.subtract(g));// 0.1
        System.out.println(f.multiply(g));// 0.90
        // System.out.println(f.divide(g));// 无法除尽，抛出 ArithmeticException 异常
        System.out.println(f.divide(g, 2, RoundingMode.HALF_UP));// 1.11

        System.out.println("______________________");

        BigDecimal h = new BigDecimal("1");
        BigDecimal i = new BigDecimal("1.0");
        System.out.println(h.compareTo(i));// 0
        System.out.println(h.equals(i));// false

        System.out.println("______________________");
        BigDecimal m = new BigDecimal("1.255433");
        BigDecimal n = m.setScale(3, RoundingMode.HALF_DOWN);
        System.out.println(n);// 1.255

    }
}
