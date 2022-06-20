package demospringbootexample06.demo.ApplicationEventPublisherAware;

import lombok.Data;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/4/29 11:06 AM
 */
@Data
public class User {

    private Integer id;
    private String name;
    private String phoneNum;
    private String email;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", phoneNum=" + phoneNum + ", email=" + email + "]";
    }
}
