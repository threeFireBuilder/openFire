package demo.ApplicationEventPublisherAware.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/6 2:41 PM
 */
@Component // 需对该类进行Bean的实例化
public class TestApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 打印容器中出事Bean的数量
        System.out.println("监听器获得容器中初始化Bean数量：" + event.getApplicationContext().getBeanDefinitionCount());
    }
}

