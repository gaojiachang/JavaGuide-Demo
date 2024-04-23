> 项目简介：本项目是作者iebya在学习javaGuide时所写的一些demo，源代码位于`src/main/java/com/iebya`路径下。

### 包说明
1. com.iebya包下只有一个Main主类，用于调用其他包下的类。
2. conCurrent包下是关于并发编程的一些demo。

### 注意事项：  
1. 除了conCurrent包下的`MultiThread.java`，`ProducerConsumer.java`，`staticSynchronizedDemo.java`，`uniqueInstanceDemo.java`，`VolatileAtomicityDemo.java`和`VolatileDemo.java`外，其余都有main方法可以单独运行。而这几个类只有静态的myRun方法，建议使用`com.iebya.Main`类调用。