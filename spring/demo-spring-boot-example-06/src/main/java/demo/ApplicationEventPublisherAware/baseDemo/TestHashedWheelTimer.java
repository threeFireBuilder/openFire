package demo.ApplicationEventPublisherAware.baseDemo;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/7/22 1:08 PM
 */
public class TestHashedWheelTimer {


    public static void main(String args[]) {
//        // 构造一个 Timer 实例
//        Timer timer = new HashedWheelTimer();
//
//// 提交一个任务，让它在 5s 后执行
//        Timeout timeout1 = timer.newTimeout(new TimerTask() {
//            @Override
//            public void run(Timeout timeout) {
//                System.out.println("5s 后执行该任务");
//            }
//        }, 5, TimeUnit.SECONDS);
//
//// 再提交一个任务，让它在 10s 后执行
//        Timeout timeout2 = timer.newTimeout(new TimerTask() {
//            @Override
//            public void run(Timeout timeout) {
//                System.out.println("10s 后执行该任务");
//            }
//        }, 10, TimeUnit.SECONDS);
//
//// 取消掉那个 5s 后执行的任务
//        if (!timeout1.isExpired()) {
//            timeout1.cancel();
//        }
//
//// 原来那个 5s 后执行的任务，已经取消了。这里我们反悔了，我们要让这个任务在 3s 后执行
//// 我们说过 timeout 持有上、下层的实例，所以下面的 timer 也可以写成 timeout1.timer()
//        timer.newTimeout(timeout1.task(), 3, TimeUnit.SECONDS);


        Integer integer = new Integer(0);
        System.out.println(integer == 0);
        Integer s = null;
        if (s > 0) {
            System.out.println(11);
        }


    }
}
