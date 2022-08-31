package juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/19 2:36 PM
 */
public class CompletableFutureApi {

//    private static ExecutorService executorService = Executors.newFixedThreadPool(5);


    public static void main(String args[]) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        /**
         *  runAsync / supplyAsync
         CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
         System.out.printf("[%s] I am Cool\n", Thread.currentThread().getName());
         });

         CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
         System.out.printf("[%s] Am Awesome\n", Thread.currentThread().getName());
         return null;
         });


        CompletableFuture <String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.printf("[%s] Am Awesome\n", Thread.currentThread().getName());
//            int i = 12/0;
            return "zy";
        }).whenComplete(new BiConsumer <String, Throwable>() {
            @Override
            public void accept(String result, Throwable throwable) {
                System.out.println(Thread.currentThread().getName()+"执行完成！"+result+throwable);
            }
        }).exceptionally(new Function <Throwable, String>() {
            @Override
            public String apply(Throwable t) {
                System.out.println(Thread.currentThread().getName()+"执行失败！" + t.getMessage());
                t.printStackTrace();
                return "";
            }
        });

        Thread.sleep(200);

        // thenAccept
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.printf("[%s] Am Awesome\n", Thread.currentThread().getName());
            return null;
        });

        try {
            cf1.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        CompletableFuture cf = CompletableFuture.supplyAsync(() -> "I am Cool").thenAccept(msg ->
                System.out.printf("[%s] %s and am also Awesome\n", Thread.currentThread().getName(), msg));
        try {
            cf.get();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }


        while (true) {
            {
                CompletableFuture cf = CompletableFuture.supplyAsync(() -> "I am Cool").thenAccept(msg ->
                        System.out.printf("[%s] %s and am also Awesome\n", Thread.currentThread().getName(), msg));
                try {
                    cf.get();
                } catch (Exception ex) {
                    ex.printStackTrace(System.err);
                }
            }
        }


        CompletableFuture cf = CompletableFuture.supplyAsync(() -> "I'm Awesome")
                // 这里的msg就是上一个异步任务的返回结果：I'm Awesome
                .thenApply(msg -> String.format("%s and am Super COOL !!!", msg))
                .thenAccept(msg -> System.out.printf("%s\n", msg));


        ExecutorService executor = Executors.newFixedThreadPool(4);
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> "I'm Stunning", executor)
                .thenCombineAsync(CompletableFuture.supplyAsync(() -> "am New !!!"),
                        (s1, s2) -> String.format("%s AND %s", s1, s2), executor)
                .thenAcceptAsync(msg ->
                        System.out.printf("[%s] %s\n", Thread.currentThread().getName(), msg), executor).thenAccept(msg->
                        executor.shutdown());

         **/

//        CompletableFuture cf = CompletableFuture.supplyAsync(() -> "I'm Awesome")
//                // 这里的msg就是上一个异步任务的返回结果：I'm Awesome
//                .thenApply(msg -> String.format("%s and am Super COOL !!!", msg))
//                .thenAccept(msg -> System.out.printf("%s\n", msg));

//
//        CompletableFuture cf = CompletableFuture.supplyAsync(() -> {
//            System.out.println("23112");
//            System.out.println("23112");
//        }).thenAccept()


        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1/0;
            return 100;
        });
//future.join();
        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
