package com.iebya.base;

import java.lang.reflect.*;

import lombok.Data;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {
        DebugInvocationHandler debugInvocationHandler = new DebugInvocationHandler(new Animal());
        Method eatMethod = Animal.class.getMethod("eat", int.class);
        Object[] argss = new Object[]{1};
        debugInvocationHandler.invoke(debugInvocationHandler, eatMethod, argss);
        Animal animal = new Animal();

        // 获取class的四种方式
        Class animalClass = animal.getClass();
        Class animalClass1 = Animal.class;
        Class animalClass2 = Class.forName("com.iebya.javabase.Animal");
        Class animalClass3 = ClassLoader.getSystemClassLoader().loadClass("com.iebya.javabase.Animal");

    }
}
class DebugInvocationHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method " + method.getName());
        return result;
    }
}

@Data
class Animal {
    int age;
    public void eat(int food) {
        System.out.println("Animal eat " + food);
    }
}

