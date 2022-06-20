package demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/5/3 8:01 PM
 */
@Component
public class B {

    @Autowired
    private demospringbootexample06.demo.A a;


    public void setA(demospringbootexample06.demo.A a) {
        this.a = a;
    }



}