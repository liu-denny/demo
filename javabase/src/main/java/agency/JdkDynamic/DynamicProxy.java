package agency.JdkDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理类
 * @author yudong
 * @create 2019-11-22 11:11
 */
public class DynamicProxy implements InvocationHandler {
    private Object object;

    public DynamicProxy(Object object){
        this.object = object;
    }

    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(object,args);
        after();
        return result;
    }

    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);
    }
}
