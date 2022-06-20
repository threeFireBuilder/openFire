package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/29 3:07 PM
 */
public class SpringClient {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(demo.DefaultProperties.class);
        ac.registerShutdownHook();

    }
}
