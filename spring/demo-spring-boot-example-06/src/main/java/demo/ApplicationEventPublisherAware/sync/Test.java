package demo.ApplicationEventPublisherAware.sync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/1 2:18 PM
 */
@Slf4j
@Component
public class Test {
    @Async
    public void testAsync(){
        log.info("Test类线程名："+Thread.currentThread().getName());
    }

    public void method(){
        log.info("this is Test.method");
    }
}


