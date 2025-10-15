package com.iebya.javabase;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class AnnotationDemo {
    public static void main(String[] args) {
        try {
            Class<MyClass> obj = MyClass.class;

            // 检查类是否被注解
            if (obj.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = obj.getAnnotation(MyAnnotation.class);
                System.out.println("Value: " + annotation.value());
                System.out.println("Number: " + annotation.number());
            }

            // 检查方法是否被注解
            Method method = obj.getMethod("myMethod");
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("Value: " + annotation.value());
                System.out.println("Number: " + annotation.number());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到。否则上述测试代码中检测不到注解存在
@interface MyAnnotation {
    // 定义元素（类似于方法，但没有实现）
    String value();

    int number() default 0; // 可以提供默认值
}

@MyAnnotation(value = "Example", number = 5)
class MyClass {
    @MyAnnotation("AnotherExample") // 省略number，使用默认值
    public void myMethod() {
    }
}
