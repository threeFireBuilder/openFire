package demo;

import org.springframework.stereotype.Service;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/28 7:59 PM
 */
@Service("testServiceImpl")
public class TestServiceImpl {

    public String test(){
        return  "test";
    }
}
