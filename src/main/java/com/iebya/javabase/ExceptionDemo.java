package com.iebya.javabase;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            // 调用可能抛出异常的方法
            riskyMethod(true);
        } catch (MyCustomException e) {
            // 捕获并处理自定义异常
            System.err.println("捕获到自定义异常: " + e.getMessage());
        }
    }
    // 模拟一个方法，该方法可能会抛出自定义异常
    public static void riskyMethod(boolean triggerException) throws MyCustomException {
        if (triggerException) {
            throw new MyCustomException("触发了自定义异常！");
        }
        System.out.println("方法正常执行");
    }
}
class MyCustomException extends Exception {
    
    // 默认构造方法
    public MyCustomException() {
        super();
    }

    // 带有错误信息的构造方法
    public MyCustomException(String message) {
        super(message);
    }

    // 带有错误信息和可抛出的原因的构造方法
    public MyCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    // 带有可抛出的原因的构造方法
    public MyCustomException(Throwable cause) {
        super(cause);
    }
}