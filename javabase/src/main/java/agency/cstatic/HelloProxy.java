package agency.cstatic;

/**
 * 代理类
 * @author yudong
 * @create 2019-11-22 10:48
 */
public class HelloProxy implements Hello{

    private Hello hello;

    public HelloProxy(){
        hello = new HelloImpl();
    }

    public void before(){
        System.out.println("hello before");
    }

    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    public void after(){
        System.out.println("hello end");
    }

}
