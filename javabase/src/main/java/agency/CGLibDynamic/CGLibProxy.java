package agency.CGLibDynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yudong
 * @create 2019-11-22 11:31
 */
public class CGLibProxy implements MethodInterceptor {

    public void before(){
        System.out.println("CGLibProxy before");
    }

    public void after(){
        System.out.println("CGLibProxy after");
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o,objects);
        after();
        return result;
    }

    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls,this);
    }
}
