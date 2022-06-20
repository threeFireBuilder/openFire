package gc;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/21 3:22 PM
 */
/*
 * 本实例用于java GC以后，新生代survivor区域的变化，以及晋升到老年代的时间和方式的测试代码。需要自行分步注释不需要的代码进行反复测试对比
 *
 * 由于java的main函数以及其他基础服务也会占用一些eden空间，所以要提前空跑一次main函数，来看看这部分占用。
 *
 * 自定义的代码中，我们使用堆内分配数组和栈内分配数组的方式来分别模拟不可被GC的和可被GC的资源。
 *
 *
 * */

public class GcTest {

    public static void main(String[] args) throws InterruptedException {

        byte[] allocation1, allocation2;
        allocation1 = new byte[30900*1024];
    }
    private static void makeGarbage(int size){
        byte[] byteArrTemp = new byte[size * 1024 * 1024];
    }
}
