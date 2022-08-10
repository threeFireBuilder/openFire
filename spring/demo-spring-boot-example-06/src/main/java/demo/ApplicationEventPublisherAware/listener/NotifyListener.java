package demo.ApplicationEventPublisherAware.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/6 2:58 PM
 */
@Component
public class NotifyListener implements ApplicationListener<NotifyEvent> {

    @Override
    public void onApplicationEvent(NotifyEvent event) {
        System.out.println("邮件地址：" + event.getEmail());
        System.out.println("邮件内容：" + event.getContent());
    }
}
