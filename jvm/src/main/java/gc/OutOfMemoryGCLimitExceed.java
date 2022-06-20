package gc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/5/24 2:33 PM
 */
public class OutOfMemoryGCLimitExceed {

    public static void addRandomDataToMap() {
        Map<Integer, String> dataMap = new HashMap<>();
        Random r = new Random();
        while (true) {
            dataMap.put(r.nextInt(), String.valueOf(r.nextInt()));
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        addRandomDataToMap();

    }
}
