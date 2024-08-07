package com.iebya.design.adapter;

// 目标接口
interface Printer {
    void print(String message);
}
// 需要适配的类
class OldPrinter {
    public void printOld(String message) {
        System.out.println("Old Printer: " + message);
    }
}
// 适配器类
class PrinterAdapterC extends OldPrinter implements Printer {

    @Override
    public void print(String message) {
        // 使用 OldPrinter 的方法
        printOld(message);
    }
}
// 客户端代码
public class ClassAdapter {
    public static void main(String[] args) {
        Printer printer = new PrinterAdapterC();
        printer.print("Hello, World!"); // 使用适配器来调用旧类的方法
    }
}
