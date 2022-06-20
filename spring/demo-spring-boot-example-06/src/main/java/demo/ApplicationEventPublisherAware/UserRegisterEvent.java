package demo.ApplicationEventPublisherAware;

import demospringbootexample06.demo.ApplicationEventPublisherAware.User;
import org.springframework.context.ApplicationEvent;


/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/29 11:04 AM
 */
public class UserRegisterEvent extends ApplicationEvent {
    private static final long serialVersionUID = -5481658020206295565L;
    private demospringbootexample06.demo.ApplicationEventPublisherAware.User user;

//    public UserRegisterEvent(Object source) {
//        super(source);
//    }
//
//    public UserRegisterEvent(Object source, Clock clock) {
//        super(source, clock);
//    }

    //谁发布的这个事件，souce就是谁（对象）
    public UserRegisterEvent(Object source, demospringbootexample06.demo.ApplicationEventPublisherAware.User user) {
        super(source);
        this.user = user;
    }

    public demospringbootexample06.demo.ApplicationEventPublisherAware.User getUser() {
        return user;
    }
}
