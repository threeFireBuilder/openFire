package demo.ApplicationEventPublisherAware.sync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/1 2:19 PM
 */
@Slf4j
@Component
public class Test1 {
    public void test() {
        log.info("Test1类线程名："+Thread.currentThread().getName());
    }
}