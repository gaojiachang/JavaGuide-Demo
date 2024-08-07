package com.iebya.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyDemo {
    public static void main(String[] args) {
        SmsService2 smsServiceProxy = (SmsService2) JdkProxyFactory.getProxy(new SmsServiceImpl2());
        smsServiceProxy.send("java");
    }
}
interface SmsService2 {
    String send(String message);
}
class SmsServiceImpl2 implements SmsService2 {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
class DebugInvocationHandler implements InvocationHandler{
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
}
class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载器
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}
