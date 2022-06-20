package gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/5/17 2:01 PM
 */
public class ThreadLocalTest {

    private List<String> messages = new ArrayList <>();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("一枝花算不算浪漫");
        System.out.println(holder.get().messages);
        ThreadLocalTest.clear();
    }
}
