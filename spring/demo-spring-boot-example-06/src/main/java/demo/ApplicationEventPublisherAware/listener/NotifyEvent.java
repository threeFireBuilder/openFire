package demo.ApplicationEventPublisherAware.listener;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/6 2:54 PM
 */
@Data
public class NotifyEvent extends ApplicationEvent {


    private String email;

    private String content;

    public NotifyEvent(Object source) {
        super(source);
    }

    public NotifyEvent(Object source, String email, String content) {
        super(source);
        this.email = email;
        this.content = content;
    }
    // 省略getter/setter方法



}
