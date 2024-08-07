package com.iebya.base;

public class GenericsDemo {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.setData("Hello, World!");
        System.out.println(box.getData());
        printArray(new Integer[]{1, 2, 3});
    }

    // 泛型方法
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

}

// 泛型类
class Box<T> {
    private T data;

    public Box() {
    }

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

// 泛型接口
interface Generator<T> {
    public T method();
}

class GeneratorImpl<T> implements Generator<T> {
    @Override
    public T method() {
        return null;
    }
}

class GeneratorImpl2<T> implements Generator<String> {
    @Override
    public String method() {
        return "hello";
    }
}
