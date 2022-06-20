package rule;

import java.util.*;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/2 5:24 PM
 * 负载均衡算法
 */
public class LoadBalacRule {


    // 待路由的Ip列表，Key代表Ip，Value代表该Ip的权重
    public static HashMap <String, Integer> serverWeightMap =
            new HashMap <String, Integer>();

    static {
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.101", 1);
        // 权重为4
        serverWeightMap.put("192.168.1.102", 4);
        serverWeightMap.put("192.168.1.103", 1);
        serverWeightMap.put("192.168.1.104", 1);
        // 权重为3
        serverWeightMap.put("192.168.1.105", 3);
        serverWeightMap.put("192.168.1.106", 1);
        // 权重为2
        serverWeightMap.put("192.168.1.107", 2);
        serverWeightMap.put("192.168.1.108", 1);
        serverWeightMap.put("192.168.1.109", 1);
        serverWeightMap.put("192.168.1.110", 1);
    }


    private static Integer pos = 0;


    /**
     * 轮询算法
     *
     * @return
     */
    public static String getRoundRobinServer() {


        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map <String, Integer> serverMap =
                new HashMap <String, Integer>();
        serverMap.putAll(serverWeightMap);

        if (serverMap.isEmpty()) return null;


        // 取得Ip地址List
        Set <String> keySet = serverMap.keySet();
        ArrayList <String> keyList = new ArrayList <String>();
        keyList.addAll(keySet);

        String server = null;

        synchronized (pos) {
            if (pos >= keyList.size()) {
                pos = 0;
            }
            server = keyList.get(pos);
            pos++;

        }

        return server;
    }


    /**
     * 随机算法
     *
     * @return
     */
    public static String getRandomServer() {


        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map <String, Integer> serverMap =
                new HashMap <String, Integer>();
        serverMap.putAll(serverWeightMap);

        if (serverMap.isEmpty()) return null;


        // 取得Ip地址List
        Set <String> keySet = serverMap.keySet();
        ArrayList <String> keyList = new ArrayList <String>();
        keyList.addAll(keySet);

        Random random = new Random();
        String server = keyList.get(random.nextInt(keyList.size()));


        return server;
    }


    /**
     * 加权算法
     *
     * @return
     */
    public static String getWeigthServer() {


        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map <String, Integer> serverMap =
                new HashMap <String, Integer>();
        serverMap.putAll(serverWeightMap);

        if (serverMap.isEmpty()) return null;

        // 取得Ip地址List
        Set <String> keySet = serverMap.keySet();
        ArrayList <String> keyList = new ArrayList <String>();
        keyList.addAll(keySet);

        Random random = new Random();
        String server = keyList.get(random.nextInt(keyList.size()));


        return server;
    }


    public static void main(String args[]) {
        for (int i = 0; i < 15; i++) {
            System.out.println(getRandomServer());
        }
    }


}
