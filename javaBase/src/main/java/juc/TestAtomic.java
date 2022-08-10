package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/8 10:25 PM
 */
public class TestAtomic {


    private static AtomicInteger atomicInteger = new AtomicInteger();

    private static int index;


    public static void increase() throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                index = atomicInteger.incrementAndGet();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                index = atomicInteger.incrementAndGet();
            }
        }).start();

        Thread.sleep(1000);
        System.out.println("-----" + index); // 输出结果20000
    }

    public static void main(String[] args) {

//        try {
//            increase();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Integer a = 1;
        Integer b = 2;
        System.out.println(a.compareTo(b));
    }
}
