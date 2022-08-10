package gc;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/7/25 9:49 PM
 * jstack [ options ] pid
 */
public class TestJstack {

    public static void main(String[] args) throws InterruptedException {
//        Thread a = new MyThreadA();
//        Thread b = new MyThreadB();
//        a.setName("线程A");
//        a.start();
//        b.setName("线程B");
//        b.start();
    final Thread myThread = new Thread() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println(Thread.currentThread());
                    try {
                        TimeUnit.SECONDS.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }; // 到这一步，线程的状态是NEW
        // 给线程起个名字，方便排查问题
        myThread.setName("测试线程");
        // 到这一步，线程的状态是RUNNABLE
        myThread.start();

        synchronized (myThread) {
            System.out.println(Thread.currentThread());
            TimeUnit.SECONDS.sleep(60);
        }
    }

}

class MyThreadA extends Thread {

    @Override
    public void run() {
        System.out.println("================B===================");
        synchronized (A.A) {
            System.out.println("线程【" + Thread.currentThread().getName() + "】开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (B.B) {
            }
            System.out.println("线程【" + Thread.currentThread().getName() + "】执行结束。B.B = " + B.B + "; A.A = " + A.A);
        }
    }
}

class MyThreadB extends Thread {
    @Override
    public void run() {
        System.out.println("================B===================");
        synchronized (B.B) {
            System.out.println("线程【" + Thread.currentThread().getName() + "】开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (A.A) {
            }
            System.out.println("线程【" + Thread.currentThread().getName() + "】执行结束。B.B = " + B.B + "; A.A = " + A.A);
        }
    }
}

class A {
    static Integer A = new Integer(1);
}

class B {
    static Integer B = new Integer(1);
}
