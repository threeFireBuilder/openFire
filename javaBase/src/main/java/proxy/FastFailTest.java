package proxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/13 3:12 PM
 */


//    public static void main(String[] args) {
////        int num1 = 10;
////        int num2 = 20;
////        swap(num1, num2);
////
////        String a ="a";
////
////        a= "b";
////        System.out.println(a);
////
////        System.out.println("num1 = " + num1);
////        System.out.println("num2 = " + num2);
//
//
//
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= 10; ++i) {
//            list.add(i);
//        }
//        list.removeIf(filter -> filter % 2 == 0); /* 删除list中的所有偶数 */
//        System.out.println(list); /* [1, 3, 5, 7, 9] */
//    }
//
//    public static void swap(int a, int b) {
////        int temp = a;
////        a = b;
////        b = temp;
////        System.out.println("a = " + a);
////        System.out.println("b = " + b);
//
//
//
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= 10; ++i) {
//            list.add(i);
//        }
//        list.removeIf(filter -> filter % 2 == 0); /* 删除list中的所有偶数 */
//        System.out.println(list); /* [1, 3, 5, 7, 9] */
//
//
//    }


/*
 * @desc java集合中Fast-Fail的测试程序。
 *
 *   fast-fail事件产生的条件：当多个线程对Collection进行操作时，若其中某一个线程通过iterator去遍历集合时，该集合的内容被其他线程所改变；则会抛出ConcurrentModificationException异常。
 *   fast-fail解决办法：通过util.concurrent集合包下的相应类去处理，则不会产生fast-fail事件。
 *
 *   本例中，分别测试ArrayList和CopyOnWriteArrayList这两种情况。ArrayList会产生fast-fail事件，而CopyOnWriteArrayList不会产生fast-fail事件。
 *   (01) 使用ArrayList时，会产生fast-fail事件，抛出ConcurrentModificationException异常；定义如下：
 *            private static List<String> list = new ArrayList<String>();
 *   (02) 使用时CopyOnWriteArrayList，不会产生fast-fail事件；定义如下：
 *            private static List<String> list = new CopyOnWriteArrayList<String>();
 *
 * @author skywang
 */
public class FastFailTest {

    private static List <String> list = new ArrayList <String>();

    //private static List<String> list = new CopyOnWriteArrayList<String>();
    public static void main(String[] args) {

        // 同时启动两个线程对list进行操作！
        new ThreadOne().start();
        new ThreadTwo().start();
    }

    private static void printAll() {
        System.out.println("");

        String value = null;
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            value = (String) iter.next();
            System.out.print(value + ", ");
        }
    }

    /**
     * 向list中依次添加0,1,2,3,4,5，每添加一个数之后，就通过printAll()遍历整个list
     */
    private static class ThreadOne extends Thread {
        public void run() {
            int i = 0;
            while (i < 6) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

    /**
     * 向list中依次添加10,11,12,13,14,15，每添加一个数之后，就通过printAll()遍历整个list
     */
    private static class ThreadTwo extends Thread {
        public void run() {
            int i = 10;
            while (i < 16) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

}



