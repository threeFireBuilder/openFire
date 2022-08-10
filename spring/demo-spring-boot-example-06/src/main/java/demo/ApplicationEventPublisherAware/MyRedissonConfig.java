package demo.ApplicationEventPublisherAware;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/5/20 10:32 AM
 */
@Configuration
public class MyRedissonConfig {

//
//    /**
//     * 所有对Redisson的使用都是通过RedissonClient
//     */
//    @Bean(destroyMethod = "shutdown")
//    public RedissonClient redisson() {
//        //1、创建配置
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//
//        //2、根据Config创建出RedissonClient实例
//        RedissonClient redisson = Redisson.create(config);
//        return redisson;
//    }


}
