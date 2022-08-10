package gc;

/**
 * @author zhangyan
 * @version 1.0
 * JVM参数： -XX:NewSize=100m -XX:MaxNewSize=100m -XX:InitialHeapSize=200m -XX:MaxHeapSize=200m -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * @date 2022/7/25 10:24 PM
 */
public class TestJstate {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(30000);
        while(true){
            loadData();
        }
    }

    public static final int _1KB = 1024;

    /**
     * 模拟每秒50个请求，每次请求分配100kb的数组
     * @throws InterruptedException
     */
    private static void loadData() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[100 * _1KB ];
        }
        data = null;

        Thread.sleep(1000);
    }
}
