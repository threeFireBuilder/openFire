package base;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/16 5:19 PM
 */
public class MonitorDemo {

    private int a = 0;

    public static void main(String[] args) {

    }

    public synchronized void writer() {     // 1
        a++;                                // 2
    }                                       // 3

    public synchronized void reader() {    // 4
        int i = a;                         // 5
    }
}
