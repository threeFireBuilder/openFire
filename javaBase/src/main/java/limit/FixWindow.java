package limit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/7 4:06 PM
 * 固定窗口限流算法
 */

public class FixWindow {

    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    private final int limit = 100;

    private AtomicInteger currentCircleRequestCount = new AtomicInteger(0);

    private AtomicInteger timeCircle = new AtomicInteger(0);

    private void doFixWindow() {
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println(" 当前时间窗口，第 {} 秒 " + timeCircle.get());
            if (timeCircle.get() >= 60) {
                timeCircle.set(0);
                currentCircleRequestCount.set(0);
                System.out.println(" =====进入新的时间窗口===== ");
            }
            if (currentCircleRequestCount.get() > limit) {
                System.out.println("触发限流策略，当前窗口累计请求数 : " + currentCircleRequestCount);
            } else {
                final int requestCount = (int) ((Math.random() * 5) + 1);
                System.out.println("当前发出的 ==requestCount== : " + requestCount);
                currentCircleRequestCount.addAndGet(requestCount);
            }
            timeCircle.incrementAndGet();
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        // new FixWindow().doFixWindow();

        Executors.newScheduledThreadPool(4).scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        long pre = System.currentTimeMillis();
                        try {
                            System.out.println("当前发出的 ==requestCount== : " + Thread.currentThread().getName());
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, 1, 1, TimeUnit.MILLISECONDS);


//        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        long pre = System.currentTimeMillis();
//                        try {
//                            System.out.println("当前发出的 ==requestCount== : " + Thread.currentThread().getName());
//
//                            Thread.sleep(2000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, 0, 1, TimeUnit.SECONDS);
    }


}
