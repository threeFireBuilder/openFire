package demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/28 7:15 PM
 */
@Data
@Component
@ConfigurationProperties("codemao.cloud.gateway")
public class DefaultProperties {

    private String name;

    private Integer age;

}
