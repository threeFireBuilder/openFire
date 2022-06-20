package demo;

import demospringbootstarterexample01.Person;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@SpringBootApplication
@Import(demospringbootexample06.demo.SpringContextUtil.class)
public class DemoApplication {

    private final Person person;


    @Resource
    private demo.DefaultProperties defaultProperties;

    @Resource
    private Redisson redisson;


    public DemoApplication(Person person) {
        this.person = person;
    }

    @GetMapping("/hello1")
    public String hello1(){
        System.out.println();
        System.out.println(defaultProperties.getAge());
        demo.TestServiceImpl testServiceImpl = demospringbootexample06.demo.SpringContextUtil.getBean("testServiceImpl");
        System.out.println(testServiceImpl.test());
        return defaultProperties.getName();
    }


    @GetMapping("/hello")
    public String hello(){
        //1、获取一把锁，只要锁的名字一样，就是同一把锁
        RLock lock = redisson.getLock("my-lock");
        //2、加锁 默认加锁时间30s
        lock.lock();
        try {
            System.out.println("加锁成功，执行业务..."  + Thread.currentThread().getId());
            TimeUnit.SECONDS.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //3、解锁
            System.out.println("释放锁..." + Thread.currentThread().getId());
            lock.unlock();
        }

        return "hello";

    }

    @Bean
    void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DemoApplication.class);
        application.addInitializers(new MyApplicationContextInitializer());
        application.run(args);



    }

}
