package demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/28 7:42 PM
 */
@Component
@Order(2)
public class AgentApplicationRun implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println();
        System.out.println("-----AgentApplicationRun run-----");
    }
}
