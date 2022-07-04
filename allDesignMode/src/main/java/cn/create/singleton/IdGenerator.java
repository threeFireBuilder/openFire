package cn.create.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/6/24 3:48 PM
 */
public class IdGenerator {

    /**
     * 饿汉式
     *
     private AtomicLong id = new AtomicLong(0);
     private static final IdGenerator instance = new IdGenerator();

     private IdGenerator() {
     }

     public static IdGenerator getInstance() {
     return instance;
     }

     public long getId() {
     return id.incrementAndGet();
     }

     如果实例占用资源多，按照 fail-fast 的设计原则（有问题及早暴露），那我们也希望在程序启动时就将这个实例初始化好。
     如果资源不够，就会在程序启动的时候触发报错（比如 Java 中的 PermGen Space OOM），我们可以立即去修复。
     这样也能避免在程序运行一段时间后，突然因为初始化这个实例占用资源过多，导致系统崩溃，影响系统的可用性。
     */

    /**
     * 懒汉式
     */

    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator instance;

    private IdGenerator() {
    }

    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String args[]) {
        System.out.println(new IdGenerator());
    }
}
