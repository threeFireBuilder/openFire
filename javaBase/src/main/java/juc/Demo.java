package juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/12 2:40 PM
 */
public class Demo {


    static ReentrantLock lock = new ReentrantLock();

    public static void a(){

        lock.lock();



    }


    public static void b(){

    }

    public static void main(String[] args) {

    }
}
