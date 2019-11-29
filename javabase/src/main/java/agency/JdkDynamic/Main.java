package agency.JdkDynamic;

import agency.cstatic.Hello;
import agency.cstatic.HelloImpl;

/**
 * @author yudong
 * @create 2019-11-22 11:25
 */
public class Main {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);
        Hello helloProxy = dynamicProxy.getProxy();
        helloProxy.say("denny dynamicProxy");
    }
}
