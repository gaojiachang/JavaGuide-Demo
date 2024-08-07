package com.iebya.design.adapter;

// 适配器类
class PrinterAdapterO implements Printer {
    private OldPrinter oldPrinter;

    public PrinterAdapterO(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String message) {
        oldPrinter.printOld(message); // 转换方法调用
    }
}

// 客户端代码
public class ObjectAdapter {
    public static void main(String[] args) {
        OldPrinter oldPrinter = new OldPrinter();
        Printer printer = new PrinterAdapterO(oldPrinter);
        printer.print("Hello, World!"); // 使用适配器来调用旧类的方法
    }
}
