package com.iebya.collection.list;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayAndArraylistDemo {
    public static void main(String[] args) {
        /*
         * ArrayDemo
         */
        // 初始化一个 String 类型的数组
        String[] stringArr = new String[] { "hello", "world", "!" };
        // 修改数组元素的值
        stringArr[0] = "goodbye";
        System.out.println(Arrays.toString(stringArr));// [goodbye, world, !]
        // 删除数组中的元素，需要手动移动后面的元素
        for (int i = 0; i < stringArr.length - 1; i++) {
            stringArr[i] = stringArr[i + 1];
        }
        stringArr[stringArr.length - 1] = null;
        System.out.println(Arrays.toString(stringArr));// [world, !, null]
        
        /*
         * ArrayListDemo
         */
        // 初始化一个 String 类型的 ArrayList
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("hello", "world", "!"));
        // 添加元素到 ArrayList 中
        stringList.add("goodbye");
        System.out.println(stringList);// [hello, world, !, goodbye]
        // 修改 ArrayList 中的元素
        stringList.set(0, "hi");
        System.out.println(stringList);// [hi, world, !, goodbye]
        // 删除 ArrayList 中的元素
        stringList.remove(0);
        System.out.println(stringList); // [world, !, goodbye]

        

    }
}
