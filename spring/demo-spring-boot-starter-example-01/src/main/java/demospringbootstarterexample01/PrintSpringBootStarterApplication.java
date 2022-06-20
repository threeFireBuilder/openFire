package demospringbootstarterexample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/28 5:19 PM
 */
@Configuration
public class PrintSpringBootStarterApplication {
    private static final Logger logger = LoggerFactory.getLogger(PrintSpringBootStarterApplication.class);

    static {
        logger.info("我是自定义starter里面打印的，static");
    }

    @Value("${hanbin.name:}")
    private String name;

    @Bean
    public Person initPerson(){
        logger.info("我是自定义starter里面打印的，我只会在服务启动的时候初始化一下！");
        return new Person(name);
    }

}
