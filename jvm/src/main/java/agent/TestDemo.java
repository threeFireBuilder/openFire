package agent;

/**
 * @author zhangyan
 * @version 1.0
 * @date 2022/6/25 1:20 AM
 */
public class TestDemo {

    /**
     * 地址
     * https://www.cnblogs.com/rickiyang/p/11368932.html
     */

    /**
     *
     * Premain-Class ：包含 premain 方法的类（类的全路径名）
     *
     * Agent-Class ：包含 agentmain 方法的类（类的全路径名）
     *
     * Boot-Class-Path ：设置引导类加载器搜索的路径列表。查找类的特定于平台的机制失败后，引导类加载器会搜索这些路径。按列出的顺序搜索路径。
     * 列表中的路径由一个或多个空格分开。路径使用分层 URI 的路径组件语法。如果该路径以斜杠字符（“/”）开头，则为绝对路径，否则为相对路径。
     * 相对路径根据代理 JAR 文件的绝对路径解析。忽略格式不正确的路径和不存在的路径。如果代理是在 VM 启动之后某一时刻启动的，则忽略不表示 JAR 文件的路径。（可选）
     *
     * Can-Redefine-Classes ：true表示能重定义此代理所需的类，默认值为 false（可选）
     *
     * Can-Retransform-Classes ：true 表示能重转换此代理所需的类，默认值为 false （可选）
     *
     * Can-Set-Native-Method-Prefix： true表示能设置此代理所需的本机方法前缀，默认值为 false（可选）
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("    main start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}
