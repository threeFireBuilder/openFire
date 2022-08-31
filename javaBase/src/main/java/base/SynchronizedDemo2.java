package base;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/16 4:41 PM
 * 深入JVM看字节码，创建如下的代码：
 * 使用javac命令进行编译生成.class文件 javac SynchronizedDemo2.java
 * 使用javap命令反编译查看.class文件的信息 javap -verbose SynchronizedDemo2.class
 * 参考链接： https://pdai.tech/md/java/thread/java-thread-x-key-synchronized.html#synchronize%E4%BF%AE%E9%A5%B0%E9%9D%99%E6%80%81%E6%96%B9%E6%B3%95
 */
public class SynchronizedDemo2 {

    Object object = new Object();
    public void method1() {
        synchronized (object) {

        }
        method2();
    }

    private static void method2() {

    }
}
