package demo;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/28 7:39 PM
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println();
        System.out.println("-----MyApplicationContextInitializer initialize-----");
    }
}
