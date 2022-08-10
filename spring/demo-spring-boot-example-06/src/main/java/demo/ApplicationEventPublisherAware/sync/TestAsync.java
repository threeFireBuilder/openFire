package demo.ApplicationEventPublisherAware.sync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/1 2:18 PM
 */
@Slf4j
@Component
public class TestAsync {
    @Autowired
    private Test test;
    @Autowired
    private Test1 test1;
    public void testCommon(){

        log.info("主线程名:{}"+Thread.currentThread().getName());
        log.info("1st:调用当前类中带有@Async注解的方法...");
        this.testAsync();
        log.info("当前类名:{}",this.getClass().getName());
        log.info("===========================================");
        log.info("2nd:调用其他类Test类中带有@Async注解的方法...");
        test.testAsync();
        Class c= test.getClass();
        log.info("当前类名:{}",c.getName());
        log.info("Test类的父类:{}",c.getSuperclass().getName());
        log.info("===========================================");
        log.info("3rd:调用其他类Test1类不带@Async注解的方法...");
        test1.test();
        log.info("当前类名:{}",test1.getClass().getName());
        log.info("===========================================");
        log.info("4th:调用其他类Test2类（没有被springboot初始化的类）中带有Async注解的方法...");
        Test2 test2 = new Test2();
        test2.testAsync();
        log.info("当前类名:{}",test2.getClass().getName());
    }

    @Async
    public void testAsync(){
        log.info("当前类调用线程名："+Thread.currentThread().getName());
    }
}