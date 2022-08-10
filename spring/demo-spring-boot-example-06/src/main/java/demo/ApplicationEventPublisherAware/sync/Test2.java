package demo.ApplicationEventPublisherAware.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/1 2:19 PM
 */
@Slf4j
public class Test2 {
    public void testAsync() {
        log.info("Test2类线程名："+Thread.currentThread().getName());
    }
}