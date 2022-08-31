package base;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/8/19 3:17 PM
 */
public class TestBuilder {


    public static void main(String args[]){
        A a = A.builder().address("xijiang").name("2312").nickName("213123").build();

        System.out.println(a);
    }
}



@Data
@Builder
class A{

    private String name;

    private String nickName;

    private String address;




}
