package agency.CGLibDynamic;

import agency.cstatic.HelloImpl;

/**
 * @author yudong
 * @create 2019-11-22 11:39
 */
public class Main {

    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        HelloImpl hello = cgLibProxy.getProxy(HelloImpl.class);
        hello.say("cgLibProxy denny");
    }
}
