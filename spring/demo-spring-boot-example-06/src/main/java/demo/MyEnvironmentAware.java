package demo;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/29 10:57 AM
 */
@Component
public class MyEnvironmentAware implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        // this.environment=environment;
        String projectName = environment.getProperty("hanbin.name");
        System.out.println(projectName);
    }
}
