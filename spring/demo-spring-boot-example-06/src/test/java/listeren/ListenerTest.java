package listeren;

import demo.ApplicationEventPublisherAware.listener.NotifyEvent;
import demo.DemoApplication;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/6 2:58 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ListenerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testListener() {

        System.out.println("这是一个测试类");
        NotifyEvent event = new NotifyEvent("object", "abc@qq.com", "This is the content");

        webApplicationContext.publishEvent(event);
    }
}