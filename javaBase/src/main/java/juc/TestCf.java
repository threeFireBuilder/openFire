package juc;



import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author nieweijun
 * @since 2022/2/24 10:53
 */
public class TestCf {

    public static void main(String[] args) throws Exception {

//        Stopwatch stopwatch = new Stopwatch("dd");

        List<Double> results = new ArrayList <>();
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture <String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture <Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture <Boolean> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return results.add(fetchPrice((String) code, "https://finance.sina.com.cn/price/"));
        });
        CompletableFuture <Boolean> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return results.add( fetchPrice((String) code, "https://money.163.com/price/"));
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture <Void> cfFetch = CompletableFuture.allOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        try {
            cfFetch.get();
            System.out.println("price: " + results);
        }catch (Exception e){
            System.out.println("price: " + e.getMessage());
        }



        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        // Thread.sleep(200);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }


}
