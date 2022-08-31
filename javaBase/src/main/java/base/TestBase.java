package base;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/7/11 3:52 PM
 */
public class TestBase {

    public static void main(String args[]){

        Long.valueOf(0L);

        int array[] = {1,2,3,4,5,6,7,8};
        List list = Arrays.asList(array);
        // Long count = list.stream().filter(it -> it > 7).count();
//        String s = "1111-3333";
//
//        String ss[] = s.split(",");
//        for (String temp: ss){
//            System.out.println(temp);
//        }

        Long endTime = 1662861600L;
//        endTime = startTime + coursePacketTimeNum / 2 * 7 * 3600;
        String times[] = "1662739200-1662998400".split(",");
        for (String tempTime : times) {
            String s[] = tempTime.split("-");
            if (endTime > Long.valueOf(s[0]) && endTime < Long.valueOf(s[1])){
                System.out.println("add Time");
                endTime = endTime + 7*24 *3600;
            }
        }
        System.out.println(endTime);
        System.out.println(UUID.randomUUID());

        ReentrantLock lock = new ReentrantLock();

        try{
            lock.lock();

            Condition condition = lock.newCondition();
        }finally {
            lock.unlock();
        }


    }
}
