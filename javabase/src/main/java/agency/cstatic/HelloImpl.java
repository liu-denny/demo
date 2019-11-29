package agency.cstatic;

/**
 * 委托类
 * @author yudong
 * @create 2019-11-22 10:47
 */
public class HelloImpl implements Hello {
    public void say(String name) {
        System.out.println("Hello:" + name);
    }
}
